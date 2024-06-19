package hansung.ac.kr.src;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import hansung.ac.kr.R;
import hansung.ac.kr.config.BaseActivity;
import hansung.ac.kr.databinding.ActivityMainBinding;
import hansung.ac.kr.src.dto.DietInfo;
import hansung.ac.kr.src.dto.LocalDB;
import hansung.ac.kr.src.fg_calendar.CalendarFragment;
import hansung.ac.kr.src.fg_product.ProductFragment;
import hansung.ac.kr.src.fg_profile.ProfileFragment;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class MainActivity extends BaseActivity {
    private Fragment productFragment;
    private Fragment calendarFragment;
    private Fragment profileFragment;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth auth;

    public MainActivity(){
        super(null);
    }
    protected ViewBinding getBinding(){
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.auth = FirebaseAuth.getInstance();
        int proteinAmount = getIntent().getIntExtra("proteinAmount", 85);
        int[] flavour = getIntent().getIntArrayExtra("flavour");
        int[] product = getIntent().getIntArrayExtra("product");
        int allergy = getIntent().getIntExtra("allergy", -1);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Survey");

        Log.d("p", String.valueOf(proteinAmount));
        Log.d("flavour", String.valueOf(flavour));
        Log.d("product", String.valueOf(product));

        productFragment = new ProductFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_fragment, productFragment).commit();

        binding.mainBnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId= item.getItemId();
                if (itemId == R.id.main_calender) {
                    moveCalendar();
                } else if (itemId == R.id.main_product) {
                    moveProduct();
                } else if (itemId == R.id.main_profile) {
                    moveProfile();
                }
                return true;
            }
        });
    }

    private final void getValue(final String email) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String sFHeight = dataSnapshot.child("user_height").getValue(String.class);
                    String sFWeight = dataSnapshot.child("user_weight").getValue(String.class);
                    String sFProteinPurpose = dataSnapshot.child("user_proteinPurpose").getValue(String.class);
                    String sFSnackYn = dataSnapshot.child("user_snackYn").getValue(String.class);
                    String sFTrainingCnt = dataSnapshot.child("user_trainingCnt").getValue(String.class);
                    String sFTrainingPurpose = dataSnapshot.child("user_trainingPurpose").getValue(String.class);
                    String sFTrainingTime = dataSnapshot.child("user_trainingTime").getValue(String.class);
                    ArrayList sFAllergy = (ArrayList) dataSnapshot.child("user_allergy").getValue();
                    ArrayList sFDietCnt = (ArrayList) dataSnapshot.child("user_dietCnt").getValue();
                    ArrayList sFPropre = (ArrayList) dataSnapshot.child("user_proPre").getValue();
                    ArrayList sFFlapre = (ArrayList) dataSnapshot.child("user_flaPre").getValue();

                    Log.d("1. 키", sFHeight);
                    Log.d("2. 무게", sFWeight);
                    Log.d("3. 단백질 섭취 목적", sFProteinPurpose);
                    Log.d("4. 간식 여부", sFSnackYn);
                    Log.d("5. 훈련 횟수", sFTrainingCnt);
                    Log.d("6. 훈련 목적", sFTrainingPurpose);
                    Log.d("7. 훈련 시간", sFTrainingTime);
                    Log.d("8. 알러지", String.valueOf(sFAllergy));
                    Log.d("9. 하루 식단", String.valueOf(sFDietCnt));
                    Log.d("10. 제품별 선호도", String.valueOf(sFPropre));
                    Log.d("11. 맛 선호도", String.valueOf(sFFlapre));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("DBError", error.getMessage());
            }
        });
    }

    private final void moveProduct() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (calendarFragment != null) transaction.hide(calendarFragment);
        if (profileFragment != null) transaction.hide(profileFragment);

        if (productFragment == null) {
            productFragment = new ProductFragment();
            transaction.add(R.id.main_layout_fragment, productFragment);
        } else {
            transaction.show(productFragment);
        }

        transaction.commit(); // commit() 호출은 마지막에 한 번만 호출되도록 수정
    }

    private final void moveCalendar() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (productFragment != null) transaction.hide(productFragment);
        if (profileFragment != null) transaction.hide(profileFragment);

        if (calendarFragment == null) {
            calendarFragment = new CalendarFragment();
            transaction.add(R.id.main_layout_fragment, calendarFragment);
        } else {
            transaction.show(calendarFragment);
        }

        transaction.commit(); // commit() 호출은 마지막에 한 번만 호출되도록 수정
    }

    private final void moveProfile() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (productFragment != null) transaction.hide(productFragment);
        if (calendarFragment != null) transaction.hide(calendarFragment);

        if (profileFragment == null) {
            profileFragment = new ProfileFragment();
            transaction.add(R.id.main_layout_fragment, profileFragment);
        } else {
            transaction.show(profileFragment);
        }

        transaction.commit(); // commit() 호출은 마지막에 한 번만 호출되도록 수정
    }

    @NotNull
    public final DietInfo makeDietCalendar(int proteinAmount, @Nullable int[] flavour, @NotNull Integer[] product, int allergy, int month) {
        Integer[] case1 = new Integer[]{1,3,4,7,8,10,12};
        Integer[] case2 = new Integer[]{4,6,9,11};
        int totalAmount = 84;

        if(Arrays.asList(case1).contains(month)){
            totalAmount=93;
        }
        else if(Arrays.asList(case2).contains(month)){
            totalAmount=90;
        }
        ArrayList<Integer> finalProduct = new ArrayList<>();
        int sum=0;
        int sumCheck=0;
        int max=0;

        for(int i=0; i<product.length; i++){
            if(i!=allergy){
                sum+=product[i];
                finalProduct.add(product[i]);
            }
            else if(i==allergy){
                finalProduct.add(0);
            }
        }

        Log.d("FINAL PRODUCT CHECK : ", finalProduct.toString());
        max = finalProduct.get(0);
        int idx=0;

        for(int i=0; i<finalProduct.size(); i++){
            if(finalProduct.get(i)>max){
                max=finalProduct.get(i);
                idx=i;
            }

            int value=(totalAmount/sum) * finalProduct.get(i);
            sumCheck +=value;
            finalProduct.set(i,value);
        }
        if(totalAmount-sumCheck>0){
            finalProduct.set(idx,finalProduct.get(idx)+(totalAmount-sumCheck));
        }

        DietInfo dietInfo = new DietInfo();
        LocalDB localDB = new LocalDB();
        ArrayList<String> dietList = new ArrayList<>();

        for(int i=0; i<finalProduct.size(); i++){
            if(finalProduct.get(i)!=null && finalProduct.get(i)==0){
                continue;
            }
            Random random=new Random();
            int j=0;
            while(j<=finalProduct.get(i)){
                dietList.add(localDB.getProduct()[i][random.nextInt(localDB.getProduct()[i].length)].toString());
                if(j==finalProduct.get(i)){
                    break;
                }
                j++;
            }
        }
        Collections.shuffle(dietList);

        for (int i = 0; i < totalAmount / 3; i++) {
            dietInfo.getCalendar()[i][0] = dietList.get(3 * i);
            dietInfo.getCalendar()[i][1] = dietList.get(3 * i + 1);
            dietInfo.getCalendar()[i][2] = dietList.get(3 * i + 2);
        }

        if (70 < proteinAmount - 20) {
            for (int i = 0; i < totalAmount / 3; i++) {
                dietInfo.getCalendar()[i][0] = dietList.get(2 * i);
                dietInfo.getCalendar()[i][1] = dietList.get(2 * i + 1);
            }
        }
        return dietInfo;
    }

}
