package hansung.ac.kr.config;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class BaseActivity<B extends ViewBinding> extends AppCompatActivity {

    protected B binding;
    private ArrayList<Toast> toastList = new ArrayList<>();

    private final LayoutInflater inflater;

    protected BaseActivity(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getBinding();
        setContentView(binding.getRoot());
    }

    protected abstract B getBinding();

    @Override
    protected void onStop() {
        for (Toast toast : toastList) {
            toast.cancel();
        }
        toastList.clear();
        super.onStop();
    }

    // Show loading dialog
    public void showLoadingDialog(Context context) {
        // Implement loading dialog display logic
    }

    // Dismiss loading dialog
    public void dismissLoadingDialog() {
        // Implement loading dialog dismissal logic
    }

    // Show custom toast
    public void showCustomToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
        toastList.add(toast);
    }

    // Calculate and return time difference
    public String calculationTime(String feedCreated) {
        long start = System.currentTimeMillis();
        Date date = new Date(start);
        SimpleDateFormat allFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat mFormat = new SimpleDateFormat("HH:mm:ss");
        String time = mFormat.format(date);
        String allTime = allFormat.format(date);

        String[] timeCurrent = time.split(":");
        String[] yearsCurrent = allTime.split(" ")[0].split("-");

        String[] timeFeed = feedCreated.split(" ")[1].split(":"); // 시,분,초
        String[] yearsFeed = feedCreated.split(" ")[0].split("-"); // 연도,월,일

        if (!yearsCurrent[0].equals(yearsFeed[0])) { // More than 1 year difference
            return feedCreated.split(" ")[0];
        } else if (Math.abs(Integer.parseInt(yearsCurrent[1]) - Integer.parseInt(yearsFeed[1])) > 1) { // More than 1 month difference
            return feedCreated.split(" ")[0];
        } else if (Math.abs(Integer.parseInt(yearsCurrent[2]) - Integer.parseInt(yearsFeed[2])) > 7) { // More than 7 days difference
            return feedCreated.split(" ")[0];
        } else if (Math.abs(Integer.parseInt(yearsCurrent[2]) - Integer.parseInt(yearsFeed[2])) > 0) { // Between 1 and 7 days difference
            int temp = Math.abs(Integer.parseInt(yearsCurrent[2]) - Integer.parseInt(yearsFeed[2]));
            return temp + "일전";
        } else if (Math.abs(Integer.parseInt(timeCurrent[0]) - Integer.parseInt(timeFeed[0])) > 0) { // More than 1 hour difference
            return Math.abs(Integer.parseInt(timeCurrent[0]) - Integer.parseInt(timeFeed[0])) + "시간전";
        } else if (Math.abs(Integer.parseInt(timeCurrent[1]) - Integer.parseInt(timeFeed[1])) > 0) { // More than 1 minute difference
            return Math.abs(Integer.parseInt(timeCurrent[1]) - Integer.parseInt(timeFeed[1])) + "분전";
        } else {
            return Math.abs(Integer.parseInt(timeCurrent[2]) - Integer.parseInt(timeFeed[2])) + "초전";
        }
    }

    // Close keyboard
    public void closeKeyboard() {
        InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
            manager.hideSoftInputFromWindow(
                    getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS
            );
        }
    }
}