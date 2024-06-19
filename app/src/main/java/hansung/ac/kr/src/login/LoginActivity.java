package hansung.ac.kr.src.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import hansung.ac.kr.R;
import hansung.ac.kr.config.BaseActivity;
import hansung.ac.kr.databinding.ActivityLoginBinding;
import hansung.ac.kr.src.MainActivity;
import hansung.ac.kr.src.signup.SignupActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    private FirebaseAuth auth;
    private DatabaseReference database;

    public LoginActivity(){
        super(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        setListener();
    }

    @Override
    protected ActivityLoginBinding getBinding() {
        return ActivityLoginBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            reload();
        }
    }

    private void reload() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void checkData() {
        String email = binding.loginEditId.getText().toString();
        String password = binding.loginEditPw.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {
            binding.loginBtnLogin.setBackgroundResource(R.drawable.bg_btn_activity);
            binding.loginBtnLogin.setTextColor(getResources().getColor(R.color.white));
        } else {
            binding.loginBtnLogin.setBackgroundResource(R.drawable.bg_btn_disabled);
            binding.loginBtnLogin.setTextColor(getResources().getColor(R.color.subGrey));
        }
    }

    private void updateUI(String title, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(title, value);
        editor.apply();
    }

    private void signIn(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            if (user != null) {
                                String uid = user.getUid();
                                String userEmail = user.getEmail();
                                updateUI("uid", uid);
                                updateUI("email", userEmail);
                                updateUI("password", password);

                                database = FirebaseDatabase.getInstance().getReference();
                                database.child("users").child(uid).child("name").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()) {
                                            String nameValue = snapshot.getValue(String.class);
                                            updateUI("name", nameValue);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Not yet implemented
                                    }
                                });
                                database.child("users").child(uid).child("birth").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()) {
                                            String birthValue = snapshot.getValue(String.class);
                                            updateUI("birth", birthValue);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Not yet implemented
                                    }
                                });
                                database.child("users").child(uid).child("phone").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()) {
                                            String phoneValue = snapshot.getValue(String.class);
                                            updateUI("phone", phoneValue);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Not yet implemented
                                    }
                                });
                                database.child("users").child(uid).child("address").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()) {
                                            String addressValue = snapshot.getValue(String.class);
                                            updateUI("address", addressValue);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Not yet implemented
                                    }
                                });

                                database.child("Survey").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            String userId = dataSnapshot.child("user_id").getValue(String.class);
                                            if (userId != null && userId.equals(userEmail)) {
                                                String heightValue = dataSnapshot.child("user_height").getValue(String.class);
                                                updateUI("height", heightValue);
                                                Integer proteinAmountValue = dataSnapshot.child("user_proteinAmount").getValue(Integer.class);
                                                if (proteinAmountValue != null) {
                                                    updateUI("proteinAmount", String.valueOf(proteinAmountValue));
                                                }
                                                break;
                                            }
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Not yet implemented
                                    }
                                });
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "이메일 또는 비밀번호를 잘못 입력했습니다.", Toast.LENGTH_SHORT).show();
                            updateUI("uid", null);
                            updateUI("email", null);
                            updateUI("password", null);
                            updateUI("name", null);
                            updateUI("birth", null);
                            updateUI("phone", null);
                            updateUI("address", null);
                            updateUI("height", null);
                            updateUI("weight", null);
                            updateUI("proteinAmount", null);
                        }
                    }
                });
    }

    private void setListener() {
        binding.loginBtnLogin.setOnClickListener(v -> {
            String email = binding.loginEditId.getText().toString();
            String password = binding.loginEditPw.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                showCustomToast("이메일, 비밀번호를 입력하세요.");
            } else {
                signIn(email, password);
            }
        });

        binding.loginTvSignup.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });

        binding.loginEditId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && s.length() > 0) {
                    binding.loginEditId.setBackgroundResource(R.drawable.bg_activity);
                } else {
                    binding.loginEditId.setBackgroundResource(R.drawable.bg_btn_disabled);
                }
                checkData();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not used
            }
        });

        binding.loginEditPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && s.length() > 0) {
                    binding.loginEditPw.setBackgroundResource(R.drawable.bg_activity);
                } else {
                    binding.loginEditPw.setBackgroundResource(R.drawable.bg_btn_disabled);
                }
                checkData();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not used
            }
        });
    }
}
