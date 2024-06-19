package hansung.ac.kr.src.fg_product;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.io.Serializable;
import java.util.ArrayList;

import hansung.ac.kr.R;
import hansung.ac.kr.config.BaseFragment;
import hansung.ac.kr.databinding.FragmentCalendarBinding;
import hansung.ac.kr.src.fg_product.rv.RecommendProductListDataClass;
import hansung.ac.kr.src.fg_product.rv.RecommendProductListRvAdapter;
import hansung.ac.kr.databinding.FragmentProductBinding;
import hansung.ac.kr.src.product_details.ProductDetailsActivity;

public final class ProductFragment extends BaseFragment {
    private final ArrayList<RecommendProductListDataClass> recommendProductList = new ArrayList<>();
    private final ArrayList<RecommendProductListDataClass> bestProductList = new ArrayList<>();
    private final ArrayList<RecommendProductListDataClass> fishProductList = new ArrayList<>();
    private final ArrayList<RecommendProductListDataClass> sauceChickenProductList = new ArrayList<>();
    private final ArrayList<RecommendProductListDataClass> chickenSteakProductList = new ArrayList<>();
    private final ArrayList<RecommendProductListDataClass> beefSteakProductList = new ArrayList<>();
    private final ArrayList<RecommendProductListDataClass> beefBallProductList = new ArrayList<>();


    private FragmentProductBinding binding;
    private RecommendProductListRvAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setRecyclerView();
        setListener();
    }



    private void setRecyclerView() {
        //닭가슴살볼
        recommendProductList.add(new RecommendProductListDataClass(R.drawable.cbx001_1,R.drawable.cbx001_2,R.drawable.cbx001_3,R.drawable.cbx001_4,"오리지널"));
        recommendProductList.add(new RecommendProductListDataClass(R.drawable.cbx002_1,R.drawable.cbx002_2,R.drawable.cbx002_3,R.drawable.cbx002_4,"스파이시"));
        recommendProductList.add(new RecommendProductListDataClass(R.drawable.cbx003_1,R.drawable.cbx003_2,R.drawable.cbx003_3,R.drawable.cbx003_4,"치즈"));
        recommendProductList.add(new RecommendProductListDataClass(R.drawable.cbx004_1,R.drawable.cbx004_2,R.drawable.cbx004_3,R.drawable.cbx004_4,"깻잎"));
        recommendProductList.add(new RecommendProductListDataClass(R.drawable.cbx005_1,R.drawable.cbx005_2,R.drawable.cbx005_3,R.drawable.cbx005_4,"자반김"));

        //닭가슴살 소세지
        bestProductList.add(new RecommendProductListDataClass(R.drawable.csx003_1,R.drawable.csx003_2,R.drawable.csx003_3,R.drawable.csx003_4,"청양고추"));
        bestProductList.add(new RecommendProductListDataClass(R.drawable.csx007_1,R.drawable.csx007_2,R.drawable.csx007_3,R.drawable.csx007_4,"훈제"));
        bestProductList.add(new RecommendProductListDataClass(R.drawable.csx005_1,R.drawable.csx005_2,R.drawable.csx005_3,R.drawable.csx005_4,"카레"));
        bestProductList.add(new RecommendProductListDataClass(R.drawable.csx001_1,R.drawable.csx001_2,R.drawable.csx001_3,R.drawable.csx001_4,"매콤치즈"));
        bestProductList.add(new RecommendProductListDataClass(R.drawable.csx002_1,R.drawable.csx002_2,R.drawable.csx002_3,R.drawable.csx002_4,"고추"));
        bestProductList.add(new RecommendProductListDataClass(R.drawable.csx004_1,R.drawable.csx004_2,R.drawable.csx004_3,R.drawable.csx004_4,"마늘"));
        bestProductList.add(new RecommendProductListDataClass(R.drawable.csx006_1,R.drawable.csx006_2,R.drawable.csx006_3,R.drawable.csx006_4,"불닭"));
        bestProductList.add(new RecommendProductListDataClass(R.drawable.csx008_1,R.drawable.csx008_2,R.drawable.csx008_3,R.drawable.csx008_4,"할라피뇨"));
        bestProductList.add(new RecommendProductListDataClass(R.drawable.csx009_1,R.drawable.csx009_2,R.drawable.csx009_3,R.drawable.csx009_4,"견과"));
        bestProductList.add(new RecommendProductListDataClass(R.drawable.csx0010_1,R.drawable.csx0010_2,R.drawable.csx0010_3,R.drawable.csx0010_4,"현미"));

        //달가슴살 스테이크
        chickenSteakProductList.add(new RecommendProductListDataClass(R.drawable.stx001_1,R.drawable.stx001_2,R.drawable.stx001_3,R.drawable.stx001_4,"오리지널"));
        chickenSteakProductList.add(new RecommendProductListDataClass(R.drawable.stx002_1,R.drawable.stx002_2,R.drawable.stx002_3,R.drawable.stx002_4,"갈릭"));
        chickenSteakProductList.add(new RecommendProductListDataClass(R.drawable.stx003_1,R.drawable.stx003_2,R.drawable.stx003_3,R.drawable.stx003_4,"고추"));
        chickenSteakProductList.add(new RecommendProductListDataClass(R.drawable.stx004_1,R.drawable.stx004_2,R.drawable.stx004_3,R.drawable.stx004_4,"호박"));
        chickenSteakProductList.add(new RecommendProductListDataClass(R.drawable.stx005_1,R.drawable.stx005_2,R.drawable.stx005_3,R.drawable.stx005_4,"야채"));
        chickenSteakProductList.add(new RecommendProductListDataClass(R.drawable.stx006_1,R.drawable.stx006_2,R.drawable.stx006_3,R.drawable.stx006_4,"토마토"));
        chickenSteakProductList.add(new RecommendProductListDataClass(R.drawable.stx007_1,R.drawable.stx007_2,R.drawable.stx007_3,R.drawable.stx007_4,"로스트갈릭"));
        chickenSteakProductList.add(new RecommendProductListDataClass(R.drawable.stx008_1,R.drawable.stx008_2,R.drawable.stx008_3,R.drawable.stx008_4,"자색고구마"));
        chickenSteakProductList.add(new RecommendProductListDataClass(R.drawable.stx009_1,R.drawable.stx009_2,R.drawable.stx009_3,R.drawable.stx009_4,"매콤토마토"));
        chickenSteakProductList.add(new RecommendProductListDataClass(R.drawable.stx0010_1,R.drawable.stx0010_2,R.drawable.stx0010_3,R.drawable.stx0010_4,"흑마늘"));

        //소스 닭가슴살
        sauceChickenProductList.add(new RecommendProductListDataClass(R.drawable.scx001_1,R.drawable.scx001_2,R.drawable.scx001_3,R.drawable.scx001_4,"갈릭스테이크"));
        sauceChickenProductList.add(new RecommendProductListDataClass(R.drawable.scx002_1,R.drawable.scx002_2,R.drawable.scx002_3,R.drawable.scx002_4,"깐풍기"));
        sauceChickenProductList.add(new RecommendProductListDataClass(R.drawable.scx003_1,R.drawable.scx003_2,R.drawable.scx003_3,R.drawable.scx003_4,"레몬크림"));
        sauceChickenProductList.add(new RecommendProductListDataClass(R.drawable.scx004_1,R.drawable.scx004_2,R.drawable.scx004_3,R.drawable.scx004_4,"매콤바베큐"));
        sauceChickenProductList.add(new RecommendProductListDataClass(R.drawable.scx005_1,R.drawable.scx005_2,R.drawable.scx005_3,R.drawable.scx005_4,"매콤칠리"));
        sauceChickenProductList.add(new RecommendProductListDataClass(R.drawable.scx006_1,R.drawable.scx006_2,R.drawable.scx006_3,R.drawable.scx006_4,"까르보나라"));
        sauceChickenProductList.add(new RecommendProductListDataClass(R.drawable.scx007_1,R.drawable.scx007_2,R.drawable.scx007_3,R.drawable.scx007_4,"블랙소이"));
        sauceChickenProductList.add(new RecommendProductListDataClass(R.drawable.scx008_1,R.drawable.scx008_2,R.drawable.scx008_3,R.drawable.scx008_4,"짜장"));
        sauceChickenProductList.add(new RecommendProductListDataClass(R.drawable.scx009_1,R.drawable.scx009_2,R.drawable.scx009_3,R.drawable.scx009_4,"짬뽕"));
        sauceChickenProductList.add(new RecommendProductListDataClass(R.drawable.scx010_1,R.drawable.scx010_2,R.drawable.scx010_3,R.drawable.scx010_4,"머스터드"));

        //생선류
        fishProductList.add(new RecommendProductListDataClass(R.drawable.fx001_1,R.drawable.fx001_2,R.drawable.fx001_3,R.drawable.fx001_4,"고등어구이"));
        fishProductList.add(new RecommendProductListDataClass(R.drawable.fx002_1,R.drawable.fx002_2,R.drawable.fx002_3,R.drawable.fx002_4,"꽁치구이"));
        fishProductList.add(new RecommendProductListDataClass(R.drawable.fx003_1,R.drawable.fx003_2,R.drawable.fx003_3,R.drawable.fx003_4,"삼치구이"));
        fishProductList.add(new RecommendProductListDataClass(R.drawable.fx004_1,R.drawable.fx004_2,R.drawable.fx004_3,R.drawable.fx004_4,"연어구이"));
        fishProductList.add(new RecommendProductListDataClass(R.drawable.fx005_1,R.drawable.fx005_2,R.drawable.fx005_3,R.drawable.fx005_4,"장어 데리야끼"));
        fishProductList.add(new RecommendProductListDataClass(R.drawable.fx006_1,R.drawable.fx006_2,R.drawable.fx006_3,R.drawable.fx006_4,"장어 매콤"));

        //소고기 볼
        beefBallProductList.add(new RecommendProductListDataClass(R.drawable.bbx001_1,R.drawable.bbx001_2,R.drawable.bbx001_3,R.drawable.bbx001_4,"마늘"));
        beefBallProductList.add(new RecommendProductListDataClass(R.drawable.bbx002_1,R.drawable.bbx002_2,R.drawable.bbx002_3,R.drawable.bbx002_4,"오리지널"));
        beefBallProductList.add(new RecommendProductListDataClass(R.drawable.bbx003_1,R.drawable.bbx003_2,R.drawable.bbx003_3,R.drawable.bbx003_4,"청양고추"));

        //소고기 스테이크
        beefSteakProductList.add(new RecommendProductListDataClass(R.drawable.bsx001_1,R.drawable.bsx001_2,R.drawable.bsx001_3,R.drawable.bsx001_4,"오리지널"));
        beefSteakProductList.add(new RecommendProductListDataClass(R.drawable.bsx002_1,R.drawable.bsx002_2,R.drawable.bsx002_3,R.drawable.bsx002_4,"청양고추"));


        binding.fgProductRvMain.setAdapter(new RecommendProductListRvAdapter(recommendProductList));
        binding.fgProductRvMain.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.fgProductRvBest.setAdapter(new RecommendProductListRvAdapter(bestProductList));
        binding.fgProductRvBest.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.fgProductRvChickenSteak.setAdapter(new RecommendProductListRvAdapter(chickenSteakProductList));
        binding.fgProductRvChickenSteak.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.fgProductRvSauceChicken.setAdapter(new RecommendProductListRvAdapter(sauceChickenProductList));
        binding.fgProductRvSauceChicken.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.fgProductRvFish.setAdapter(new RecommendProductListRvAdapter(fishProductList));
        binding.fgProductRvFish.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.fgProductRvBeefBall.setAdapter(new RecommendProductListRvAdapter(beefBallProductList));
        binding.fgProductRvBeefBall.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.fgProductRvBeefSteak.setAdapter(new RecommendProductListRvAdapter(beefSteakProductList));
        binding.fgProductRvBeefSteak.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

    }

    private void setListener() {

        RecommendProductListRvAdapter.OnItemClickListener listener = position -> {
            Intent intent = new Intent(requireContext(), ProductDetailsActivity.class);
            intent.putExtra("info", (Serializable) recommendProductList.get(position));
            startActivity(intent);
        };

        if(getBinding()==null){
            return;
        }


        ((RecommendProductListRvAdapter) ((FragmentProductBinding) getBinding()).fgProductRvMain.getAdapter()).setItemClickListener(listener);
        ((RecommendProductListRvAdapter) ((FragmentProductBinding) getBinding()).fgProductRvBest.getAdapter()).setItemClickListener(listener);
        ((RecommendProductListRvAdapter) ((FragmentProductBinding) getBinding()).fgProductRvChickenSteak.getAdapter()).setItemClickListener(listener);
        ((RecommendProductListRvAdapter) ((FragmentProductBinding) getBinding()).fgProductRvSauceChicken.getAdapter()).setItemClickListener(listener);
        ((RecommendProductListRvAdapter) ((FragmentProductBinding) getBinding()).fgProductRvFish.getAdapter()).setItemClickListener(listener);
        ((RecommendProductListRvAdapter) ((FragmentProductBinding) getBinding()).fgProductRvBeefBall.getAdapter()).setItemClickListener(listener);
        ((RecommendProductListRvAdapter) ((FragmentProductBinding) getBinding()).fgProductRvBeefSteak.getAdapter()).setItemClickListener(listener);
    }


    public ProductFragment() {
        super(FragmentProductBinding::bind, R.layout.fragment_product);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
