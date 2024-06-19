package hansung.ac.kr.src.fg_product.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import hansung.ac.kr.databinding.ItemRecommendProductBinding;
import java.util.ArrayList;
public class RecommendProductListRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<RecommendProductListDataClass> dataSet;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public RecommendProductListRvAdapter(ArrayList<RecommendProductListDataClass> dataSet) {
        this.dataSet = dataSet;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRecommendProductBinding binding = ItemRecommendProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RecommendProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecommendProductViewHolder) {
            RecommendProductViewHolder productViewHolder = (RecommendProductViewHolder) holder;
            productViewHolder.bind(dataSet.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }

    public class RecommendProductViewHolder extends RecyclerView.ViewHolder {

        private ItemRecommendProductBinding binding;

        public RecommendProductViewHolder(ItemRecommendProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onClick(getAdapterPosition());
                    }
                }
            });
        }

        public void bind(RecommendProductListDataClass item) {
            binding.itemRecommendProductImgMain.setClipToOutline(true);

            Glide.with(binding.getRoot())
                    .load(item.getTitle_image())
                    .centerCrop()
                    .into(binding.itemRecommendProductImgMain);

            binding.itemRecommendProductTvTitle.setText(item.getTitle());
        }
    }
}