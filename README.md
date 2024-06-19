# 헬린이들을 위한 단백질 보충 식단 추천 서비스

유튜브 링크
https://youtu.be/mDkicFmwGYw

<img width="230" alt="image" src="https://user-images.githubusercontent.com/54922625/206559927-793f5dc9-c25c-45c1-9bb2-cb6491f119e5.jpeg"/>


## 프로젝트 소개
<img width="682" alt="image" src="https://user-images.githubusercontent.com/54922625/206564601-1d1581b9-2ee4-486b-a5d9-f6641d5391d9.png">

 ### 🐾 기획 의도
 

 
 #### MZ세대에서 트렌드 키워드로 뽑히는 #운동 #자기관리
MZ 세대를 중심으로 트렌드인 #운동과 #자기관리는 SNS에서 큰 인기를 끌고 있으며, 건강과 체력 관리에 대한 관심이 높아지 있는 현상에 집중해 앱을 구상했다.

<table>
 <tr>
  <td><img width="531" alt="image" src="https://user-images.githubusercontent.com/54922625/206523332-8978f4d8-5465-46c7-ab64-0e652e1e43f0.png" width="230"></td>
  <td><img src="https://user-images.githubusercontent.com/54922625/206525532-0ba8adfe-5cdc-493f-89eb-431e55ada284.jpeg" width="230" height="350"></td>
 </tr>
 <tr>
  <td>"대학내일 통계자료"</td>
  <td>인스타 #오운완 인증글</td>
 </tr>
</table>

 
 ### 🐾 아이디어 내기
 운동 루틴이나 운동 방법을 알려주는 앱은 많지만 식단을 관리해주고 추천해주고 공유하는 앱은 없다는 사실 발견
 시대상황과 앱 상황을 고려해 단백질 식단을 추천하고 서로 공유할 수 있는 **개인 맞춤형 단백질 식단 관리 및 제공 서비스**를 기획했다.
 
 1. 설문 조사를 통해 개인정보와 상품에 대한 선호도조사를 바탕으로 단백질 식단을 추천, 제공
 2. 하루 목표 단백질 섭취율을 체크해 주는 기능 제공
 3. 카테고리 별 개별 상품 확인 기능 제공 


## 📔템플릿구조
- 폴더 구조는 크게 config 폴더, src 폴더, util 폴더로 이루어져 있다.

---

> config 폴더
> 

```
근간이 되는 코드들이 위치해 있다.

< ApplicationClass >

앱이 실행될 때 맨 처음 실행되는(싱글톤 객체) 코드들이 위치해 있다.

< BaseActivity & BaseFragment >

로딩창을 띄우는 것, 토스트 메세지 띄우는 것 등 자주 쓰이지만, 중복이 많이 되는 코드를 모듈화 하여 작성한 코드들이 위치해 있다.

```

---

> src 폴더
> 

```

src 폴더는 Config/ 의 베이스 코드들을 기반으로, Activity나 Fragment 등을 동작시키는
즉 앱을 동작시키는 구체적인 구현을 코드들이 위치해 있다.

src 폴더는 도메인(화면)별로 폴더가 나눠져있다.
src 폴더의 구조는 메인화면, 스플래쉬 화면 등 큰 도메인별로 나눠져있고, Fragment별 작은 도메인으로 나눠져있다.

- rv : ViewPager나 RecyclerView 설정에 대한 코드들이 위치해 있다.

```

---

> util 폴더
> 

```

도구처럼 사용되는 Dialog 로딩 코드가 위치해 있다.

```
  


  
 [**앱 처음 실행 시**]

 <table>
  <tr>
   <td><img src="https://user-images.githubusercontent.com/109564764/206642963-bac026b0-aa50-4e59-875d-edb0bbe7f753.png" width="200"/></td>
   <td><img src="https://user-images.githubusercontent.com/109564764/206642817-9d7d6d55-165f-498c-8b36-ab86365fea3c.png" width="200"/></td>
   <td><img src="https://user-images.githubusercontent.com/109564764/206642890-0d53c15e-2623-4822-a6cf-046637383962.png" width="200"/></td>
  </tr>
 </table>

 앱을 실행 후 로딩 될 때 백구 캐릭터가 담긴 splash 화면으로 시작합니다.</br>
 사용자는 계정이 있는 경우 로그인하여 메인 페이지로 이동하고 첫 사용자 일 경우에는 회원가입을 진행합니다.</br>
 회원 가입은 이메일, 비밀번호, 이름 외 개인 정보들을 입력하고 완료 시 파이어베이스 DB로 저장됩니다.</br>
 
 <br><br><br>
 
  [**메인 페이지 (피드)**]

 <table>
  <tr>
   <td><img src="https://user-images.githubusercontent.com/109564764/206645139-7b839e17-9724-40ef-879e-154716528bc5.png" width="200"/></td>
   <td><img src="https://user-images.githubusercontent.com/109564764/206645425-c005d9b4-5031-4dbd-8685-552a9e7561b3.png" width="200"/></td>
  </tr>
 </table>
 메인화면에 피드 부분에서는 카테고리 별 서비스에서 제공하는 상품들 목록을 확인할 수 있습니다. </br>
 상하 스크롤을 통해 카테고리 확인이 가능합니다.</br>
 <br><br>
 </table>
 
 
 [**메인 페이지 (캘린더)**]
  
 <table>
  <tr>
   <td><img src="https://user-images.githubusercontent.com/109564764/206646277-65fbb2c4-cdc1-4006-a4dd-18db0cd98254.png" width="200"/></td>
  </tr>
 </table>
 

 [**메인 페이지 (마이페이지)**]

 <table>
  <tr>
   <td><img src="https://user-images.githubusercontent.com/109564764/206646565-d1b6aaf0-37fb-4641-99a4-1356c36eea88.png" width="200"/></td>
   <td><img src="https://user-images.githubusercontent.com/109564764/206646614-7d204f81-ae3f-4766-804b-b5ed5d733530.png" width="200"/></td>
  </tr>
 </table>
 마이페이지 부분에서는 사용자의 프로필과 신체정보, 목표 단백질량을 볼 수 있고 개인 정보와 설문 정보를 수정할 수 있습니다.</br>
 개인정보 수정 버튼을 클릭 시 프로필 수정 화면이 나타나고 개인정보를 변경할 수 있습니다. </br>
 

 #### 1. 사용자 정보
   1. 이메일 형식과 비밀번호 형식(영문, 숫자, 특수문자 조합), 빈칸 유무를 확인 후 이상이 없으면 회원가입 함수를 실행한다.
      
   // 회원가입 완료 버튼
  
    private void setListener() {
        binding.signupImgBack.setOnClickListener(view -> finish());

        //FirebaseAuth 인스턴스 가져오기
        auth = FirebaseAuth.getInstance();

        //회원가입 완료 버튼 클릭 리스너
        binding.signupTvFinish.setOnClickListener(view -> {
            //사용자가 입력한 데이터 값 가져오기
            emailValue = binding.signupEditId.getText().toString();
            pwValue = binding.signupEditPw.getText().toString();
            nameValue = binding.signupEditName.getText().toString();
            birthValue = binding.signupEditBirthday.getText().toString();
            phoneValue = binding.signupEditNumber.getText().toString();
            addressValue = binding.signupEditTown.getText().toString();
            //메일 형식 올바른지 확인
            if (Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
                //비밀번호 형식 올바른지 확인
                if (Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\\$@\\$!%*#?&])[A-Za-z[0-9]\\$@\\$!%*#?&]{8,20}$", pwValue)) {
                    //항목 빠짐 없이 입력했는지 확인
                    if (!nameValue.isEmpty() && !birthValue.isEmpty() && !phoneValue.isEmpty() && !addressValue.isEmpty()) {
                        createAccount(emailValue, pwValue);
                    } else {
                        Toast.makeText(getApplicationContext(), "모든 항목을 입력하세요.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "8~16자 영문, 숫자, 특수문자를 사용하세요.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show();
            }
        });

        회원가입 폼 입력필드에 텍스트 변경 리스너 추
        binding.signupEditId.addTextChangedListener(new EditTextWatcher());
        binding.signupEditPw.addTextChangedListener(new EditTextWatcher());
        binding.signupEditName.addTextChangedListener(new EditTextWatcher());
        binding.signupEditTown.addTextChangedListener(new EditTextWatcher());
        binding.signupEditBirthday.addTextChangedListener(new EditTextWatcher());
        binding.signupEditNumber.addTextChangedListener(new EditTextWatcher());
    }

  
   2. 이메일 중복없이 회원가입에 성공하면 Firebase Authentication에 계정을 등록한다. 실패 시 Toast 메세지 출력

   ``` 
//회원가입 함수
private void createAccount(String email, String password) {
        //Firebase를 이용하여 이메일과 비밀번호로 사용자 계정 생성
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {//계정 생성 성공
                        FirebaseUser user = auth.getCurrentUser();
                        if (user != null) {//생성된 사용자 정보 가져오기
                            String userEmail = user.getEmail();
                            String uid = user.getUid();

                            //정보에 맞게 UI 업데이트 및 사용자 정보 저장 함수 호출
                            updateUI(uid, userEmail, pwValue, nameValue, birthValue, phoneValue, addressValue);
                            writeNewUser(uid, nameValue, birthValue, phoneValue, addressValue);

                            //설문조사 액티비티로 이동
                            Intent intent = new Intent(this, SurveyActivity.class);
                            intent.putExtra("user_id", userEmail);
                            startActivity(intent);
                        }
                    } else {
                        //계정 생성 실패
                        Toast.makeText(getApplicationContext(), "이미 존재하는 이메일입니다.", Toast.LENGTH_SHORT).show();
                        //UI초기 상태로 업데이트트
                        updateUI(null, null, null, null, null, null, null);
                    }
                });
    }
   ```
  
   3. 회원가입에서 입력한 정보를 Firebase Realtime DataBase users에 저장한다. 각각의 타입은 아래와 같다.
   <table>
     <tr>
     <td>타입</td>
     <td>설문 정보</td>
    </tr>
    <tr>
     <td>String</td>
     <td>name, birth, phone, address</td>
    </tr>
   </table>

  
   ```
   // 파이어베이스 Realtime Database 저장 형식
  public static class User {
        public String name;
        public String birth;
        public String phone;
        public String address;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String name, String birth, String phone, String address) {
            this.name = name;
            this.birth = birth;
            this.phone = phone;
            this.address = address;
        }

   // Firebase Realtime Database 저장 함수
  private void writeNewUser(String email, String name, String birth, String phone, String,address) {
        //Firebase Realtime Datase 참조
        database = FirebaseDatabase.getInstance().getReference();
        //새로운 User객체 생성
        User user = new User(name, birth, phone, address);
        //'users' 노드 아래에 이메일을 키로 하여 사용자 데이터 저
        database.child("users").child(email).setValue(user);
    }
   ```
  
   4. signIn 함수를 사용해 Firebase Authentication에 저장된 데이터와 일치 여부를 판단한다.
      Firebase Realtime Database에 저장된 데이터를 조회하여 변수에 저장한 뒤 마이페이지 내용을 유저에 맞게 변경한다.
   ``` 
    // 로그인 함수
   private void signIn(String email, String password) {
         //Firebase Authentication을 이용하여 이메일과 비밀번호로 로그인 시도
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                        if (task.isSuccessful()) {
                            //로그인 성공
                            FirebaseUser user = auth.getCurrentUser();
                            if (user != null) {
                                //사용자 정보 가져오기
                                String uid = user.getUid();
                                String userEmail = user.getEmail();

                                //UI 업데이트 함수 호출
                                updateUI("uid", uid);
                                updateUI("email", userEmail);
                                updateUI("password", password);

                                //Firebase Realtime Database의 참조 데이터 가져오기
                                database = FirebaseDatabase.getInstance().getReference();
                                
                                //데이터 베이스에서 사용자 이름 가져오기 database.child("users").child(uid).child("name").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()) {
                                            String nameValue = snapshot.getValue(String.class);
                                            updateUI("name", nameValue);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Not yet implemented
                                    }
                                });
                                
                                  //데이터 베이스에서 사용자 생일일 가져오기database.child("users").child(uid).child("birth").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()) {
                                            String birthValue = snapshot.getValue(String.class);
                                            updateUI("birth", birthValue);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Not yet implemented
                                    }
                                });
                                //데이터 베이스에서 사용자 번호 가져오기database.child("users").child(uid).child("phone").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()) {
                                            String phoneValue = snapshot.getValue(String.class);
                                            updateUI("phone", phoneValue);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Not yet implemented
                                    }
                                });
                                //데이터 베이스에서 사용자 주소소 가져오기database.child("users").child(uid).child("address").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()) {
                                            String addressValue = snapshot.getValue(String.class);
                                            updateUI("address", addressValue);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Not yet implemented
                                    }
                                });
                                
                                //데이터 베이스에서 사용자 설문 정보보 가져오기  
                                database.child("Survey").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            String userId = dataSnapshot.child("user_id").getValue(String.class);
                                            if (userId != null && userId.equals(userEmail)) {
                                                String heightValue = dataSnapshot.child("user_height").getValue(String.class);
                                                updateUI("height", heightValue);
                                                Integer proteinAmountValue = dataSnapshot.child("user_proteinAmount").getValue(Integer.class);
                                                if (proteinAmountValue != null) {
                                                    updateUI("proteinAmount", String.valueOf(proteinAmountValue));
                                                }
                                                break;
                                            }
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Not yet implemented
                                    }
                                });
                            }
                        } else {  //로그인 실패시시
                            Toast.makeText(LoginActivity.this, "이메일 또는 비밀번호를 잘못 입력했습니다.", Toast.LENGTH_SHORT).show();
                            updateUI("uid", null);
                            updateUI("email", null);
                            updateUI("password", null);
                            updateUI("name", null);
                            updateUI("birth", null);
                            updateUI("phone", null);
                            updateUI("address", null);
                            updateUI("height", null);
                            updateUI("weight", null);
                            updateUI("proteinAmount", null);
                        }
                    }
                });
    }
   ```
  
   5. 이미 로그인한 유저는 별도의 로그인없이 메인 액티비티로 이동한다.
   ``` 
    protected void onStart() {
        super.onStart();
        //현재 로그인된 사용자 정보 저장
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {//로그인 기록 있으면 reload함수 실행
            reload();
        }
    }

     // 로그인 기록이 있으면 메인 액티비티로 이동
    private void reload() {
        //MainActivy 인텐트 생성
        Intent intent = new Intent(this, MainActivity.class);
        //MainActivity 인텐트 실행
        startActivity(intent);
        //현재 액티비티 종료
        finish();
    }

   ```
   6. 로그아웃
   ``` 
   // 로그아웃 기능
  getBinding().fgProfileTvLogout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Firebase 인증에서 로그아웃
        FirebaseAuth.getInstance().signOut();
        
        // UI를 초기 상태로 업데이트하는 함수 호출
        updateUI(null, null, null, null, null, null, null, null, null, null);
        updateUI2(null, null, null);
        
        // LoginActivity로 이동하는 인텐트를 생성하고 시작
        Intent intent = new Intent(requireContext(), LoginActivity.class);
        startActivity(intent);
    }
});
   ```

 #### 2. 설문조사 정보
  1. 설문조사에서 조사한 설문정보를 Firebase Realtime DataBase에 저장한다. 각각의 타입은 아래와 같다.
  <table>
    <tr>
    <td>타입</td>
    <td>설문 정보</td>
   </tr>
   <tr>
    <td>String</td>
    <td>user_id, user_height, user_weight, user_proteinPurpose, user_trainingPurpose, user_trainingTime, user_snackYn</td>
   </tr>
   <tr>
    <td>Int</td>
    <td>user_proteinAmount</td>
   </tr>
   <tr>
    <td>List<String>?</td>
    <td>user_dietCnt, user_allergy</td>
   </tr>
   <tr>
    <td>List<String>?</td>
    <td>user_proPre, user_flaPre</td>
   </tr>
  </table>
  
  ``` 
public class Survey {
    private String user_id;
    private String user_height;
    private String user_weight;
    private String user_proteinPurpose;
    private String user_trainingPurpose;
    private String user_trainingCnt;
    private String user_trainingTime;
    private List<String> user_dietCnt;
    private List<String> user_allergy;
    private String user_snackYn;
    private List<Integer> user_proPre;
    private List<Integer> user_flaPre;
    private Integer user_proteinAmount;

    public Survey() {
        // Default constructor required for Firebase
    }

    public Survey(String user_id, String user_height, String user_weight, String user_proteinPurpose,
                  String user_trainingPurpose, String user_trainingCnt, String user_trainingTime,
                  List<String> user_dietCnt, List<String> user_allergy, String user_snackYn,
                  List<Integer> user_proPre, List<Integer> user_flaPre, Integer user_proteinAmount) {
        this.user_id = user_id;
        this.user_height = user_height;
        this.user_weight = user_weight;
        this.user_proteinPurpose = user_proteinPurpose;
        this.user_trainingPurpose = user_trainingPurpose;
        this.user_trainingCnt = user_trainingCnt;
        this.user_trainingTime = user_trainingTime;
        this.user_dietCnt = user_dietCnt;
        this.user_allergy = user_allergy;
        this.user_snackYn = user_snackYn;
        this.user_proPre = user_proPre;
        this.user_flaPre = user_flaPre;
        this.user_proteinAmount = user_proteinAmount;
    }
  //.....get,set()함수 생략
}
 ```

   2. 설문조사를 하면서 저장해둔 유저의 키, 몸무게, 필요단백질량을 프래퍼런스로 저장하여 프로필 화면에서 유저가 확인할 수 있도록 한다.
   그리고 설문조사 수정하기 버튼을 누르면 설문조사 내용을 수정할 수 있다.
   ``` 
 private void setListener() {
        if(getBinding()==null)
            return;
        // 마이페이지 개인정보 표시
        SharedPreferences sharedPreference = requireContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        //SharedPreferences에서 체중, 신장, 단백질 섭취량 값 가져오기
        String weightValue = sharedPreference.getString("weight", "User weight");
        String heightValue = sharedPreference.getString("height", "User height");
        String proteinAmountValue = sharedPreference.getString("proteinAmount", "User proteinAmount");
        //UI에 체중, 신장, 단백질 섭취량 값 결
        getBinding().fgProfileTvWeight.setText(weightValue + "kg");
        getBinding().fgProfileTvHeight.setText(heightValue + "cm");
        getBinding().fgProfileTvProtein.setText(proteinAmountValue + "g");

       // 체중 값이 기본값인 경우 설문조사에서 가져온 값으로 설정
        if ("User weight".equals(weightValue)) {
            SharedPreferences sharedPreferenceSurvey = requireContext().getSharedPreferences("surveyInfo", Context.MODE_PRIVATE);
            String weightValueSurvey = sharedPreferenceSurvey.getString("weight", "User weight");
            String heightValueSurvey = sharedPreferenceSurvey.getString("height", "User height");
            String proteinAmountValueSurvey = sharedPreferenceSurvey.getString("proteinAmount", "User proteinAmount");

             // UI에 설문조사에서 가져온 체중, 신장, 단백질 섭취량 값 설정
            getBinding().fgProfileTvWeight.setText(weightValueSurvey + "kg");
            getBinding().fgProfileTvHeight.setText(heightValueSurvey + "cm");
            getBinding().fgProfileTvProtein.setText(proteinAmountValueSurvey + "g");
        }

         // 개인정보 수정 페이지로 이동하는 클릭 리스너 설정
        getBinding().fgProfileLayoutSetting.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ProfileEditActivity.class);
            startActivity(intent);
        });

  ```

### 🍎개선할 점
-객체 지향적 설계 개선
  ```
현재 코드에서는 리스너 구현이나 데이터 처리 로직이 활발히 사용되고 있지만, 이를 객체 지향적으로 재구성하여 코드의 재사용성과 유지보수성을 높일 필요가 있습니다.
예를 들어, BaseActivity와 BaseFragment에서 중복되는 코드를 추상 클래스로 분리하고, 공통 기능을 상속받아 사용하는 방법을 고려할 수 있습니다.
  ```

- 설문조사 반영
  ```
설문조사 데이터의 저장 및 수정 부분에서 SharedPreferences를 사용하고 있으나, Firebase Realtime Database와의 연동을 완벽히 구현하지 못한 상황입니다.
getBinding()하는 부분에서 계속 null 값이 나오는데 수정/보수 필요합니다.
  ```

-UI/UX 개선
  ```
현재 UI는 이미지와 설명이 조합된 형태로 구성되어 있으며, 사용자 경험을 더 향상시킬 수 있는 방법을 찾아야 합니다.
메인 페이지의 데이터를 더 직관적으로 탐색할 수 있는 인터페이스 개선이 필요합니다.
  ```
