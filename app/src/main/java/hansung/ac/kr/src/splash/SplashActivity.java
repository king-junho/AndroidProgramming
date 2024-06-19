package hansung.ac.kr.src.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import hansung.ac.kr.config.BaseActivity;
import hansung.ac.kr.databinding.ActivitySplashBinding;
import hansung.ac.kr.src.login.LoginActivity;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    public SplashActivity(){
        super(null);
    }
    @Override
    protected ActivitySplashBinding getBinding() {
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 1500);
    }
}