package hansung.ac.kr.src.diet_details.util;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalMarginItemDecoration extends RecyclerView.ItemDecoration {

    private final int horizontalMarginInPx;

    public HorizontalMarginItemDecoration(Context context, @DimenRes int horizontalMarginInDp) {
        this.horizontalMarginInPx = (int) context.getResources().getDimension(horizontalMarginInDp);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.right = horizontalMarginInPx;
        outRect.left = horizontalMarginInPx;
    }
}