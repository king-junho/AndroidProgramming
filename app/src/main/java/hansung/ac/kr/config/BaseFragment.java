package hansung.ac.kr.config;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class BaseFragment<B extends ViewBinding> extends Fragment {
    private final ViewBindingFunction<B> bind;
    private final @LayoutRes int layoutResId;
    private B _binding;
    private final ArrayList<Toast> toastList = new ArrayList<>();

    public BaseFragment(ViewBindingFunction<B> bind, @LayoutRes int layoutResId) {
        super();
        this.bind = bind;
        this.layoutResId = layoutResId;
    }

    public B getBinding() {
        return _binding;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater,container,savedInstanceState);
        if (rootView == null) {
            throw new IllegalStateException("Root view must not be null");
        }
        if (bind != null) {
            _binding = bind.apply(rootView);
        } else {
        throw new IllegalStateException("ViewBindingFunction must not be null");
        }
        return _binding.getRoot();
    }

    @Override
    public void onStop() {
        for (Toast toast : toastList) {
            toast.cancel();
        }
        toastList.clear();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        _binding = null;
        super.onDestroyView();
    }

    public void showCustomToast(String message) {
        Toast toast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        toast.show();
        toastList.add(toast);
    }

    public void showLoadingDialog(Context context) {
        // Implement your loading dialog logic here
    }

    public void dismissLoadingDialog() {
        // Implement your loading dialog dismissal logic here
    }

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

        if (!yearsCurrent[0].equals(yearsFeed[0])) { // 1년 이상 차이날 때
            return feedCreated.split(" ")[0];
        } else if (Math.abs(Integer.parseInt(yearsCurrent[1]) - Integer.parseInt(yearsFeed[1])) > 1) { // 1달 이상 차이날 때
            return feedCreated.split(" ")[0];
        } else if (Math.abs(Integer.parseInt(yearsCurrent[2]) - Integer.parseInt(yearsFeed[2])) > 7) { // 7일 이상 차이날 때
            return feedCreated.split(" ")[0];
        } else if (Math.abs(Integer.parseInt(yearsCurrent[2]) - Integer.parseInt(yearsFeed[2])) > 0) { // 7일 이하 1일 이상 차이날 때
            int temp = Math.abs(Integer.parseInt(yearsCurrent[2]) - Integer.parseInt(yearsFeed[2]));
            return temp + "일 전";
        } else if (Math.abs(Integer.parseInt(timeCurrent[0]) - Integer.parseInt(timeFeed[0])) > 0) { // 1시간 이상 차이날 때
            return Math.abs(Integer.parseInt(timeCurrent[0]) - Integer.parseInt(timeFeed[0])) + "시간 전";
        } else if (Math.abs(Integer.parseInt(timeCurrent[1]) - Integer.parseInt(timeFeed[1])) > 0) { // 1분 이상 차이날 때
            return Math.abs(Integer.parseInt(timeCurrent[1]) - Integer.parseInt(timeFeed[1])) + "분 전";
        } else {
            return Math.abs(Integer.parseInt(timeCurrent[2]) - Integer.parseInt(timeFeed[2])) + "초 전";
        }
    }

    // Functional interface for ViewBinding

    @FunctionalInterface
    public interface ViewBindingFunction<B extends ViewBinding> {
        B apply(View view);
    }
}