package hansung.ac.kr.src.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import hansung.ac.kr.R;
import hansung.ac.kr.config.BaseActivity;
import hansung.ac.kr.databinding.ActivityLoginBinding;
import hansung.ac.kr.databinding.ActivitySignupBinding;
import hansung.ac.kr.src.survey.SurveyActivity;

import java.util.regex.Pattern;

public class SignupActivity extends BaseActivity<ActivitySignupBinding> {

    private String emailValue;
    private String pwValue;
    private String nameValue;
    private String birthValue;
    private String phoneValue;
    private String addressValue;

    private FirebaseAuth auth;
    private DatabaseReference database;

    public SignupActivity(){
        super(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListener();
    }

    @Override
    protected ActivitySignupBinding getBinding() {
        return ActivitySignupBinding.inflate(getLayoutInflater());
    }

    private void updateUI(String uid, String email, String pwValue, String nameValue, String birthValue, String phoneValue, String addressValue) {
        SharedPreferences sharedPreference = getSharedPreferences("userInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString("uid", uid);
        editor.putString("email", email);
        editor.putString("password", pwValue);
        editor.putString("name", nameValue);
        editor.putString("birth", birthValue);
        editor.putString("phone", phoneValue);
        editor.putString("address", addressValue);
        editor.apply();
    }

    public static class User {
        public String name;
        public String birth;
        public String phone;
        public String address;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String name, String birth, String phone, String address) {
            this.name = name;
            this.birth = birth;
            this.phone = phone;
            this.address = address;
        }
    }

    private void writeNewUser(String email, String name, String birth, String phone, String address) {
        database = FirebaseDatabase.getInstance().getReference();
        User user = new User(name, birth, phone, address);

        database.child("users").child(email).setValue(user);
    }

    private void createAccount(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        if (user != null) {
                            String userEmail = user.getEmail();
                            String uid = user.getUid();
                            updateUI(uid, userEmail, pwValue, nameValue, birthValue, phoneValue, addressValue);
                            writeNewUser(uid, nameValue, birthValue, phoneValue, addressValue);

                            Intent intent = new Intent(this, SurveyActivity.class);
                            intent.putExtra("user_id", userEmail);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "이미 존재하는 이메일입니다.", Toast.LENGTH_SHORT).show();
                        updateUI(null, null, null, null, null, null, null);
                    }
                });
    }

    private void checkData() {
        if (binding.signupEditId.getText() != null && !binding.signupEditId.getText().toString().isEmpty() &&
                binding.signupEditPw.getText() != null && !binding.signupEditPw.getText().toString().isEmpty() &&
                binding.signupEditName.getText() != null && !binding.signupEditName.getText().toString().isEmpty() &&
                binding.signupEditTown.getText() != null && !binding.signupEditTown.getText().toString().isEmpty() &&
                binding.signupEditNumber.getText() != null && !binding.signupEditNumber.getText().toString().isEmpty() &&
                binding.signupEditBirthday.getText() != null && !binding.signupEditBirthday.getText().toString().isEmpty()) {
            binding.signupTvFinish.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_btn_activity));
            binding.signupTvFinish.setTextColor(ContextCompat.getColor(this, R.color.white));
        } else {
            binding.signupTvFinish.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_btn_disabled));
            binding.signupTvFinish.setTextColor(ContextCompat.getColor(this, R.color.subGrey));
        }
    }

    private void setListener() {
        binding.signupImgBack.setOnClickListener(view -> finish());

        auth = FirebaseAuth.getInstance();

        binding.signupTvFinish.setOnClickListener(view -> {
            emailValue = binding.signupEditId.getText().toString();
            pwValue = binding.signupEditPw.getText().toString();
            nameValue = binding.signupEditName.getText().toString();
            birthValue = binding.signupEditBirthday.getText().toString();
            phoneValue = binding.signupEditNumber.getText().toString();
            addressValue = binding.signupEditTown.getText().toString();

            if (Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
                if (Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\\$@\\$!%*#?&])[A-Za-z[0-9]\\$@\\$!%*#?&]{8,20}$", pwValue)) {
                    if (!nameValue.isEmpty() && !birthValue.isEmpty() && !phoneValue.isEmpty() && !addressValue.isEmpty()) {
                        createAccount(emailValue, pwValue);
                    } else {
                        Toast.makeText(getApplicationContext(), "모든 항목을 입력하세요.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "8~16자 영문, 숫자, 특수문자를 사용하세요.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show();
            }
        });

        binding.signupEditId.addTextChangedListener(new EditTextWatcher());
        binding.signupEditPw.addTextChangedListener(new EditTextWatcher());
        binding.signupEditName.addTextChangedListener(new EditTextWatcher());
        binding.signupEditTown.addTextChangedListener(new EditTextWatcher());
        binding.signupEditBirthday.addTextChangedListener(new EditTextWatcher());
        binding.signupEditNumber.addTextChangedListener(new EditTextWatcher());
    }

    private class EditTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            checkData();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    }
}