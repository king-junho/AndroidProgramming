package hansung.ac.kr.src.diet_details;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import hansung.ac.kr.R;
import hansung.ac.kr.config.BaseActivity;
import hansung.ac.kr.databinding.ActivityDietDetailsBinding;
import hansung.ac.kr.src.diet_details.rv.DietDetailsDataClass;
import hansung.ac.kr.src.diet_details.rv.DietDetailsRvAdapter;
import hansung.ac.kr.src.diet_details.util.HorizontalMarginItemDecoration;

import java.util.ArrayList;
public class DietDetailsActivity extends BaseActivity<ActivityDietDetailsBinding> {
    private ArrayList<DietDetailsDataClass> dietList = new ArrayList<>();
    private Intent receiveIntent;
    private ArrayList<DietDetailsDataClass> dietDetailsList = new ArrayList<>();
    private final int DIET_DETAILS_CODE = 101;
    private ArrayList<Integer> changeProteinAmount = new ArrayList<>();
    private String date = "";

    protected DietDetailsActivity(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        receiveIntent = getIntent();
        if (receiveIntent != null) {
            if (!receiveIntent.getStringExtra("date").isEmpty()) {
                date = receiveIntent.getStringExtra("date");
                Log.d("weagfwag", date);
            }

            if (receiveIntent.getSerializableExtra("dietList") != null) {
                dietDetailsList = (ArrayList<DietDetailsDataClass>) receiveIntent.getSerializableExtra("dietList");
            }
        }

        for (int i = 0; i < 30; i++) {
            changeProteinAmount.add(0);
        }

        Log.d("weagawgawg", date);

        for (int i = 0; i < dietDetailsList.size(); i++) {
            dietList.add(dietDetailsList.get(i));
        }

        setViewPager();
        setListener();
    }

    @Override
    protected ActivityDietDetailsBinding getBinding() {
        return null;
    }

    private void setListener() {
        binding.dietDetailsImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ewgawgewag", changeProteinAmount.toString());
                receiveIntent.putExtra("proteinAmountList", changeProteinAmount);
                receiveIntent.putExtra("pos", 12);
                setResult(DIET_DETAILS_CODE, receiveIntent);
                finish();
            }
        });

        ((DietDetailsRvAdapter) binding.dietDetailsVp2Main.getAdapter()).setItemClickListener(new DietDetailsRvAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, int addAmount) {
                changeProteinAmount.set(position, changeProteinAmount.get(position) + addAmount);
            }
        });
    }

    private void setViewPager() {
        binding.dietDetailsVp2Main.setAdapter(new DietDetailsRvAdapter(dietList));

        // You need to retain one page on each side so that the next and previous items are visible
        binding.dietDetailsVp2Main.setOffscreenPageLimit(1);

        // Add a PageTransformer that translates the next and previous items horizontally
        // towards the center of the screen, which makes them visible
        float nextItemVisiblePx = getResources().getDimension(R.dimen.viewpager_next_item_visible);
        float currentItemHorizontalMarginPx = getResources().getDimension(R.dimen.viewpager_current_item_horizontal_margin);
        float pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx;
        ViewPager2.PageTransformer pageTransformer = new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                page.setTranslationX(-pageTranslationX * position);
                // Next line scales the item's height. You can remove it if you don't want this effect
                page.setScaleY(1 - (0.1f * Math.abs(position)));
                page.setScaleX(1f);
                // If you want a fading effect uncomment the next line:
                // page.setAlpha(0.25f + (1 - Math.abs(position)));
            }
        };

        binding.dietDetailsVp2Main.setPageTransformer(pageTransformer);

        // The ItemDecoration gives the current (centered) item horizontal margin so that
        // it doesn't occupy the whole screen width. Without it the items overlap
        HorizontalMarginItemDecoration itemDecoration = new HorizontalMarginItemDecoration(
                this,
                R.dimen.viewpager_current_item_horizontal_margin
        );
        binding.dietDetailsVp2Main.addItemDecoration(itemDecoration);

        binding.dietDetailsVp2Main.setCurrentItem(Integer.parseInt(date.split("\\.")[1]) - 1, false);
    }

}