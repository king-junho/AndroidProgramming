package hansung.ac.kr.src.product_details.rv;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import hansung.ac.kr.databinding.ItemProductDetailsBinding;
import java.util.ArrayList;


public class ProductDetailsRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ProductDetailsDataClass> dataSet;

    public ProductDetailsRvAdapter(ArrayList<ProductDetailsDataClass> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemProductDetailsBinding binding = ItemProductDetailsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductDetailsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProductDetailsViewHolder) {
            ((ProductDetailsViewHolder) holder).bind(dataSet.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ProductDetailsViewHolder extends RecyclerView.ViewHolder {

        private ItemProductDetailsBinding binding;

        public ProductDetailsViewHolder(ItemProductDetailsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ProductDetailsDataClass item) {
            binding.itemProductDetailsImgMain.setClipToOutline(true);

            Glide.with(binding.getRoot())
                    .load(item.getImage())
                    .into(binding.itemProductDetailsImgMain);
        }
    }
}