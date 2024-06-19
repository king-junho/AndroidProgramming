package hansung.ac.kr.config;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class ApplicationClass extends Application {
    public static SharedPreferences sharedPreferences;
    public static String test = "hello test";

    // 앱이 처음 생성되는 순간, SP를 새로 만들어주고, 레트로핏 인스턴스를 생성합니다.
    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = getApplicationContext().getSharedPreferences("INFO", Context.MODE_PRIVATE);
        Log.d("awegweagwgwea", "hello");
    }
}