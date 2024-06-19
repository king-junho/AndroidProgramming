package hansung.ac.kr.src.product_details;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import hansung.ac.kr.config.BaseActivity;
import hansung.ac.kr.databinding.ActivityProductDetailsBinding;
import hansung.ac.kr.src.fg_product.rv.RecommendProductListDataClass;
import hansung.ac.kr.src.product_details.rv.ProductDetailsDataClass;
import hansung.ac.kr.src.product_details.rv.ProductDetailsRvAdapter;
import java.util.ArrayList;

public class ProductDetailsActivity extends BaseActivity<ActivityProductDetailsBinding> {

    private ArrayList<ProductDetailsDataClass> productDetailsList = new ArrayList<>();
    private Intent receiveIntent;
    private RecommendProductListDataClass info;


    public ProductDetailsActivity() {
        super(null);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        receiveIntent = getIntent();
        info = (RecommendProductListDataClass) receiveIntent.getSerializableExtra("info");

        setRecyclerView();
    }

    private void setRecyclerView() {
        productDetailsList.add(new ProductDetailsDataClass(info.getImage_1()));
        productDetailsList.add(new ProductDetailsDataClass(info.getImage_2()));
        productDetailsList.add(new ProductDetailsDataClass(info.getImage_3()));

        binding.productDetailsRvMain.setLayoutManager(new LinearLayoutManager(this));
        binding.productDetailsRvMain.setAdapter(new ProductDetailsRvAdapter(productDetailsList));
    }

    @Override
    protected ActivityProductDetailsBinding getBinding() {
        return ActivityProductDetailsBinding.inflate(getLayoutInflater());
    }
}