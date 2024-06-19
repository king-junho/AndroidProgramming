package hansung.ac.kr.src.fg_profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import hansung.ac.kr.R;
import hansung.ac.kr.config.BaseFragment;
import hansung.ac.kr.databinding.FragmentCalendarBinding;
import hansung.ac.kr.databinding.FragmentProfileBinding;
import hansung.ac.kr.src.login.LoginActivity;
import hansung.ac.kr.src.profile_edit.ProfileEditActivity;
import hansung.ac.kr.src.survey.SurveyActivity;
import java.util.Objects;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends BaseFragment<FragmentProfileBinding> {

    public ProfileFragment() {
        super(FragmentProfileBinding::bind, R.layout.fragment_profile);
    }

    private FragmentProfileBinding binding;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListener();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false); // 예시: 실제 바인딩 클래스로 수정
        View rootView = binding.getRoot();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        setListener();
    }

    // 프레퍼런스 값 업데이트 함수
    private void updateUI(String uid, String email, String pwValue, String nameValue, String birthValue, String phoneValue, String addressValue, String heightValue, String weightValue, String proteinAmountValue) {
        SharedPreferences sharedPreference = requireContext().getSharedPreferences("userInfo", AppCompatActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString("uid", uid);
        editor.putString("email", email);
        editor.putString("password", pwValue);
        editor.putString("name", nameValue);
        editor.putString("birth", birthValue);
        editor.putString("phone", phoneValue);
        editor.putString("address", addressValue);
        editor.putString("height", heightValue);
        editor.putString("weight", weightValue);
        editor.putString("proteinAmount", proteinAmountValue);
        editor.apply();
    }

    private void updateUI2(String heightValue, String weightValue, String proteinAmountValue) {
        SharedPreferences sharedPreference = requireContext().getSharedPreferences("surveyInfo", AppCompatActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString("height", heightValue);
        editor.putString("weight", weightValue);
        editor.putString("proteinAmount", proteinAmountValue);
        editor.apply();
    }

    private void setListener() {
        if(getBinding()==null)
            return;
        // 마이페이지 개인정보 표시
        SharedPreferences sharedPreference = requireContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String nameValue = sharedPreference.getString("name", "User name");
        String emailValue = sharedPreference.getString("email", "User email");
        getBinding().fgProfileTvUserName.setText(nameValue);
        getBinding().fgProfileTvEmail.setText(emailValue);

        String weightValue = sharedPreference.getString("weight", "User weight");
        String heightValue = sharedPreference.getString("height", "User height");
        String proteinAmountValue = sharedPreference.getString("proteinAmount", "User proteinAmount");
        getBinding().fgProfileTvWeight.setText(weightValue + "kg");
        getBinding().fgProfileTvHeight.setText(heightValue + "cm");
        getBinding().fgProfileTvProtein.setText(proteinAmountValue + "g");


        if ("User weight".equals(weightValue)) {
            SharedPreferences sharedPreferenceSurvey = requireContext().getSharedPreferences("surveyInfo", Context.MODE_PRIVATE);
            String weightValueSurvey = sharedPreferenceSurvey.getString("weight", "User weight");
            String heightValueSurvey = sharedPreferenceSurvey.getString("height", "User height");
            String proteinAmountValueSurvey = sharedPreferenceSurvey.getString("proteinAmount", "User proteinAmount");
            getBinding().fgProfileTvWeight.setText(weightValueSurvey + "kg");
            getBinding().fgProfileTvHeight.setText(heightValueSurvey + "cm");
            getBinding().fgProfileTvProtein.setText(proteinAmountValueSurvey + "g");
        }

        // 개인정보 수정 페이지로 이동
        getBinding().fgProfileLayoutSetting.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ProfileEditActivity.class);
            startActivity(intent);
        });

        // 로그아웃 기능
        getBinding().fgProfileTvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                updateUI(null, null, null, null, null, null, null, null, null, null);
                updateUI2(null, null, null);
                Intent intent = new Intent(requireContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        // 설문조사 수정 페이지로 이동
        getBinding().fgProfileLayoutSurvey.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), SurveyActivity.class);
            startActivity(intent);
        });
    }
}