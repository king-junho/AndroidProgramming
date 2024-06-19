package hansung.ac.kr.src.fg_calendar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import hansung.ac.kr.R;
import hansung.ac.kr.config.BaseFragment;
import hansung.ac.kr.databinding.FragmentCalendarBinding;
import hansung.ac.kr.src.diet_details.DietDetailsActivity;
import hansung.ac.kr.src.diet_details.rv.DietDetailsDataClass;
import hansung.ac.kr.src.dto.DietInfo;
import hansung.ac.kr.src.dto.LocalDB;
import hansung.ac.kr.src.fg_calendar.data_class.ProteinAmountDataClass;

public class CalendarFragment extends BaseFragment<FragmentCalendarBinding>{

    public CalendarFragment() {
        super(FragmentCalendarBinding::bind, R.layout.fragment_calendar);
    }
    private final String TAG = "CalendarFragmentTAG";

    private String month = "";
    private String day = "";

    private final ArrayList<ProteinAmountDataClass> proteinAmountList = new ArrayList<>();
    private final ArrayList<DietDetailsDataClass> dietDetailsList = new ArrayList<>();

    private final int DIET_DETAILS_CODE = 101;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth auth;



    private FragmentCalendarBinding binding;

    private final ActivityResultLauncher<Intent> preDietDetailsActivityContractStartActivityResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == DIET_DETAILS_CODE) {
                    if (result.getData() != null) {
                        ArrayList<Integer> amountList = (ArrayList<Integer>) result.getData().getSerializableExtra("proteinAmountList");
                        for (int i = 0; i < amountList.size(); i++) {
                            proteinAmountList.get(i).setCurrentAmount(proteinAmountList.get(i).getCurrentAmount() + amountList.get(i));
                        }
                        binding.fgCalendarTvCurrentProtein.setText(proteinAmountList.get(Integer.parseInt(day) - 1).getCurrentAmount() + "g");
                        Log.d("wegwegaes", amountList.toString());
                    }
                }
            });

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd", Locale.getDefault());
        String getTime = sdf.format(date);
        month = getTime.split("\\.")[0];
        day = getTime.split("\\.")[1];

        Log.d("weagawegawegwaeg", getTime);

        binding.fgCalendarTvDate.setText(getTime);
        setListener();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Survey");
        auth = FirebaseAuth.getInstance();
        String email = Objects.requireNonNull(auth.getCurrentUser()).getEmail();
        binding=getBinding();

        databaseReference.get().addOnSuccessListener(dataSnapshot -> {
            HashMap<String, Object> data = (HashMap<String, Object>) dataSnapshot.getChildren().iterator().next().getValue();
            Log.d("전부다", data.toString());
            int[] fflavour = null;
            int[] fproduct = null;
            Integer fproteinAmount = null;

            if (Objects.equals(data.get("user_id").toString(), email)) {
                ArrayList<Integer> sFFlavour = (ArrayList<Integer>) data.get("user_flaPre");
                ArrayList<Integer> sFProduct = (ArrayList<Integer>) data.get("user_proPre");
                int sFProtein = (int) data.get("user_proteinAmount");
                fflavour = strToArray(sFFlavour);
                fproduct = strToArray(sFProduct);
                fproteinAmount = sFProtein;
            }

            // DB에서 받아오는 부분 ---------------------------------------
            // 제품 순서 : 소시지, 볼, 소스, 소고기, 생선, 스테이크, 프로틴, 간식
            // allergy : product 배열 idx

            int proteinAmount = fproteinAmount != null ? fproteinAmount : 85;
            int[] flavour = fflavour != null ? fflavour : new int[]{4, 2, 3, 5, 4, 3, 2, 1};
            int[] product = fproduct != null ? fproduct : new int[]{5, 2, 3, 4, 1, 4};

            int allergy = 4; // 생선
            int month = 12; //캘린더 정보에서 받아오기

            DietInfo result = makeDietCalendar(proteinAmount, flavour, product, allergy, month);

            binding.fgCalendarTvTargetProtein.setText(proteinAmount + "g");
            binding.fgCalendarTvCurrentProtein.setText("0g");

            for (int i = 0; i < 30; i++) {
                proteinAmountList.add(new ProteinAmountDataClass(proteinAmount, 0));
                dietDetailsList.add(
                        new DietDetailsDataClass(
                                Integer.toString(month),
                                Integer.toString(i + 1),
                                result.getCalendar()[i][0],
                                result.getCalendar()[i][1],
                                result.getCalendar()[i][2],
                                result.getCalendar()[i][3],
                                result.getCalendar()[i][4]
                        )
                );
                Log.d(TAG, "2022/12/" + (i + 1) + " 아침 : " + result.getCalendar()[i][0]);
                Log.d(TAG, "2022/12/" + (i + 1) + " 점심 : " + result.getCalendar()[i][1]);
                Log.d(TAG, "2022/12/" + (i + 1) + " 저녁 : " + result.getCalendar()[i][2]);
                Log.d(TAG, "2022/12/" + (i + 1) + " 간식1 :" + result.getCalendar()[i][3]);
                Log.d(TAG, "2022/12/" + (i + 1) + " 간식2 :" + result.getCalendar()[i][4]);
                Log.d(TAG, "----------------------------------------------");
            }
        });
    }

    private int[] strToArray(ArrayList<Integer> arraylist) {
        int[] result = new int[10];
        for (int i = 0; i < arraylist.size(); i++) {
            result[i] = arraylist.get(i);
            Log.d("result", java.util.Arrays.toString(result));
        }
        return result;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();


        return rootView;
    }
    private void setListener() {
        binding.fgCalendarTvMore.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(), DietDetailsActivity.class);
            intent.putExtra("date", month + "." + day);
            intent.putExtra("dietList", dietDetailsList);

            preDietDetailsActivityContractStartActivityResult.launch(intent);
        });

        binding.fgCalendarMain.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                day = Integer.toString(dayOfMonth);

                proteinAmountList.get(dayOfMonth - 1);

                if ((dayOfMonth - 1) > 0 && (dayOfMonth - 1) < 31) {
                    binding.fgCalendarTvTargetProtein.setText(proteinAmountList.get(dayOfMonth - 1).getTargetAmount() + "g");
                    binding.fgCalendarTvCurrentProtein.setText(proteinAmountList.get(dayOfMonth - 1).getCurrentAmount() + "g");
                }
                binding.fgCalendarTvDate.setText((month + 1) + "." + dayOfMonth);
            }
        });

    }

    public DietInfo makeDietCalendar(int proteinAmount, int[] flavour, int[] product, int allergy, int month) {
        // 1. 받아온 달에 맞춰 필요한 총 상품 갯수 산출
        int[] case1 = {1, 3, 4, 7, 8, 10, 12};
        int[] case2 = {4, 6, 9, 11};
        int totalAmount = 28 * 3;
        if (contains(case1, month)) totalAmount = 31 * 3;
        else if (contains(case2, month)) totalAmount = 30 * 3;

        // 2. 알러지를 제외한 상품 리스트 생성
        ArrayList<Integer> finalProduct = new ArrayList<>();
        int sum = 0; // 제품 선호 비율에 따라 식단을 구성하기 위한 변수
        int sumCheck = 0; // 비율별로 구성하고 모자란 제품을 채워주기 위한 변수

        for (int i = 0; i < product.length; i++) {
            if (i != allergy) {
                sum += product[i];
                finalProduct.add(product[i]);
            } else if (i == allergy) {
                finalProduct.add(0);
            }
        }
        Log.d("FINAL PRODUCT CHECK :: ", finalProduct.toString());

        // 3. 제품 선호 비율에 맞게 한달치 제품을 배정하고 모자란 부분은 제일 선호가 높았던 제품으로 채워줌
        int max = finalProduct.get(0);
        int idx = 0;
        for (int i = 0; i < finalProduct.size(); i++) {
            if (finalProduct.get(i) > max) {
                max = finalProduct.get(i);
                idx = i;
            }
            int value = (totalAmount / sum * finalProduct.get(i)) / 1;
            sumCheck += value;
            finalProduct.set(i, value); // finalProduct 배열을 선호 수치에 따라 한달치 상품 갯수 비율에 맞게 수정
        }
        // ex) finalProduct = [10, 15, 20, 20, 0, 25+3]
        if (totalAmount - sumCheck > 0) finalProduct.set(idx, finalProduct.get(idx) + (totalAmount - sumCheck)); // 한달치 식단을 짜고 모자란 갯수는 제일 선호도가 높은 제품으로 채워줌

        // 4. 하루 필요 단백질양을 고려하여 식단 산출
        // dietInfo에 30일치 식단 넣어서 보내줄거임.
        DietInfo dietInfo = new DietInfo();
        LocalDB localDb = new LocalDB();
        ArrayList<String> dietList = new ArrayList<>();

        for (int i = 0; i < finalProduct.size(); i++) {
            if (finalProduct.get(i) == 0) continue; // 알러지 상품은 제외
            Random random = new Random();

            for (int j = 0; j <= finalProduct.get(i); j++) {
                dietList.add(localDb.getProduct()[i][random.nextInt(localDb.getProduct()[i].length)]);
            }
        }
        java.util.Collections.shuffle(dietList); // 구성된 제품을 랜덤하게 셔플

        for (int i = 0; i < (totalAmount / 3); i++) {
            dietInfo.getCalendar()[i][0] = dietList.get(3 * i);
            dietInfo.getCalendar()[i][1] = dietList.get(3 * i + 1);
            dietInfo.getCalendar()[i][2] = dietList.get(3 * i + 2);
        }

        // 단백질 양이 부족하면 채워줌
        if (70 < proteinAmount - 20) {
            for (int i = 0; i < (totalAmount / 3); i++) {
                dietInfo.getCalendar()[i][3] = localDb.getProtein()[i % 10];
            }
            if (91 < proteinAmount - 20) {
                for (int i = 0; i < (totalAmount / 3); i++) {
                    dietInfo.getCalendar()[i][4] = localDb.getAppetizer()[i % 5];
                }
            }
        }

        return dietInfo;
    }

    private boolean contains(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) return true;
        }
        return false;
    }
}
