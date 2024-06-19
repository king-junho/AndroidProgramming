package hansung.ac.kr.src.survey;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.*;

import hansung.ac.kr.R;
import hansung.ac.kr.config.BaseActivity;
import hansung.ac.kr.databinding.ActivitySurveyBinding;
import hansung.ac.kr.src.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class SurveyActivity extends BaseActivity<ActivitySurveyBinding> {

    private String semail;

    public SurveyActivity(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySurveyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        semail = getIntent().getStringExtra("user_id");
        binding.surveyBtnSave.setOnClickListener(v -> saveSurveyData());
    }

    @Override
    protected ActivitySurveyBinding getBinding() {
        return null;
    }

    private void saveSurveyData(){
        // 컴포넌트 변수에 담기
        EditText heightEdit = findViewById(R.id.survey_edit_height);
        EditText weightEdit = findViewById(R.id.survey_edit_weight);

        RadioGroup proteinPurposeRadioButtonGroup = findViewById(R.id.survey_rg_proteinpurpose);
        RadioGroup trainingPurposeRadioButtonGroup = findViewById(R.id.survey_rg_trainpurpose);
        RadioGroup trainingCntRadioButtonGroup = findViewById(R.id.survey_rg_trainingcnt);
        RadioGroup trainingTimeRadioButtonGroup = findViewById(R.id.survey_rg_trainingtime);

        CheckBox dietCntBreakfast = findViewById(R.id.survey_cb_dietcnt_breakfast);
        CheckBox dietCntLunch = findViewById(R.id.survey_cb_dietcnt_lunch);
        CheckBox dietCntDinner = findViewById(R.id.survey_cb_dietcnt_dinner);

        // 알러지
        CheckBox allergy1 = findViewById(R.id.survey_cb_allergy_1);
        CheckBox allergy2 = findViewById(R.id.survey_cb_allergy_2);
        CheckBox allergy3 = findViewById(R.id.survey_cb_allergy_3);
        CheckBox allergy4 = findViewById(R.id.survey_cb_allergy_4);
        CheckBox allergy5 = findViewById(R.id.survey_cb_allergy_5);

        RadioGroup snackynRadioButtonGroup = findViewById(R.id.survey_rg_snackyn);

        RadioGroup proPre1 = findViewById(R.id.survey_rg_chickensausage);
        RadioGroup proPre2 = findViewById(R.id.survey_rg_chickenball);
        RadioGroup proPre3 = findViewById(R.id.survey_rg_saucechicken);
        RadioGroup proPre4 = findViewById(R.id.survey_rg_beefsteak);
        RadioGroup proPre5 = findViewById(R.id.survey_rg_godeungeo);
        RadioGroup proPre6 = findViewById(R.id.survey_rg_chickensteak);

        RadioGroup flaPre1 = findViewById(R.id.survey_rg_spicy);
        RadioGroup flaPre2 = findViewById(R.id.survey_rg_very_spicy);
        RadioGroup flaPre3 = findViewById(R.id.survey_rg_pepper);
        RadioGroup flaPre4 = findViewById(R.id.survey_rg_garlic);
        RadioGroup flaPre5 = findViewById(R.id.survey_rg_original);
        RadioGroup flaPre6 = findViewById(R.id.survey_rg_soy);
        RadioGroup flaPre7 = findViewById(R.id.survey_rg_cream);
        RadioGroup flaPre8 = findViewById(R.id.survey_rg_vege);

        Button addBtn = findViewById(R.id.survey_btn_save);

        DAOSurvey dao = new DAOSurvey();

        addBtn.setOnClickListener(v -> {
            String sHeight = heightEdit.getText().toString();
            String sWeight = weightEdit.getText().toString();

            RadioButton proteinPurposeRadioButton = findViewById(proteinPurposeRadioButtonGroup.getCheckedRadioButtonId());
            String sProteinPurpose = radioButtonNullCheck(proteinPurposeRadioButton);

            RadioButton trainingPurposeRadioButton = findViewById(trainingPurposeRadioButtonGroup.getCheckedRadioButtonId());
            String sTrainingPurpose = radioButtonNullCheck(trainingPurposeRadioButton);

            RadioButton trainingCntRadioButton = findViewById(trainingCntRadioButtonGroup.getCheckedRadioButtonId());
            String sTrainingCnt = radioButtonNullCheck(trainingCntRadioButton);

            RadioButton trainingTimeRadioButton = findViewById(trainingTimeRadioButtonGroup.getCheckedRadioButtonId());
            String sTrainingTime = radioButtonNullCheck(trainingTimeRadioButton);

            List<String> sDietCnt = sendCheck(dietCntBreakfast, dietCntLunch, dietCntDinner);
            List<String> sAllergy = sendCheck(allergy1, allergy2, allergy3, allergy4, allergy5);

            RadioButton snackynRadioButton = findViewById(snackynRadioButtonGroup.getCheckedRadioButtonId());
            String sSnackYn = radioButtonNullCheck(snackynRadioButton);

            String sPropre1 = radioButtonNullCheck(findViewById(proPre1.getCheckedRadioButtonId()));
            String sPropre2 = radioButtonNullCheck(findViewById(proPre2.getCheckedRadioButtonId()));
            String sPropre3 = radioButtonNullCheck(findViewById(proPre3.getCheckedRadioButtonId()));
            String sPropre4 = radioButtonNullCheck(findViewById(proPre4.getCheckedRadioButtonId()));
            String sPropre5 = radioButtonNullCheck(findViewById(proPre5.getCheckedRadioButtonId()));
            String sPropre6 = radioButtonNullCheck(findViewById(proPre6.getCheckedRadioButtonId()));

            List<Integer> sPropreResult = sendRadio(sPropre1, sPropre2, sPropre3, sPropre4, sPropre5, sPropre6);

            String sFlapre1 = radioButtonNullCheck(findViewById(flaPre1.getCheckedRadioButtonId()));
            String sFlapre2 = radioButtonNullCheck(findViewById(flaPre2.getCheckedRadioButtonId()));
            String sFlapre3 = radioButtonNullCheck(findViewById(flaPre3.getCheckedRadioButtonId()));
            String sFlapre4 = radioButtonNullCheck(findViewById(flaPre4.getCheckedRadioButtonId()));
            String sFlapre5 = radioButtonNullCheck(findViewById(flaPre5.getCheckedRadioButtonId()));
            String sFlapre6 = radioButtonNullCheck(findViewById(flaPre6.getCheckedRadioButtonId()));
            String sFlapre7 = radioButtonNullCheck(findViewById(flaPre7.getCheckedRadioButtonId()));
            String sFlapre8 = radioButtonNullCheck(findViewById(flaPre8.getCheckedRadioButtonId()));
            List<Integer> sFlapreResult = sendRadio(sFlapre1, sFlapre2, sFlapre3, sFlapre4, sFlapre5, sFlapre6, sFlapre7, sFlapre8);

            int sProteinAmount = calculateProtein(Integer.parseInt(sHeight), Integer.parseInt(sWeight), sTrainingPurpose);

            if (sProteinPurpose == null ||
                    sTrainingPurpose == null ||
                    sTrainingCnt == null ||
                    sTrainingTime == null ||
                    sSnackYn == null) {
                Toast.makeText(getApplicationContext(), "모든 항목을 설문해주세요!", Toast.LENGTH_SHORT).show();
            } else {
                Survey survey = new Survey(
                        semail,
                        sHeight,
                        sWeight,
                        sProteinPurpose,
                        sTrainingPurpose,
                        sTrainingCnt,
                        sTrainingTime,
                        sDietCnt,
                        sAllergy,
                        sSnackYn,
                        sPropreResult,
                        sFlapreResult,
                        sProteinAmount
                );

                dao.add(survey).addOnSuccessListener(aVoid -> {
                    onClickShowAlert(sProteinAmount, sFlapreResult.toArray(new Integer[0]), sPropreResult.toArray(new Integer[0]));
                    updateUI("height", sHeight);
                    updateUI("weight", sWeight);
                    updateUI("proteinAmount", Integer.toString(sProteinAmount));

                    // 입력창 초기화
                    heightEdit.setText("");
                    weightEdit.setText("");
                    proteinPurposeRadioButton.setChecked(false);
                    trainingPurposeRadioButton.setChecked(false);
                    trainingCntRadioButton.setChecked(false);
                    trainingTimeRadioButton.setChecked(false);

                    setCheckBoxFalse(dietCntBreakfast, dietCntLunch, dietCntDinner);
                    setCheckBoxFalse(allergy1, allergy2, allergy3, allergy4, allergy5);
                }).addOnFailureListener(e -> {
                    Log.e("SurveyActivity", "Firestore 데이터 추가 실패", e); // 이 부분에서 로그 추가

                });
            }
        });
    }

    private List<String> sendCheck(CheckBox... checkBox) {
        StringBuilder checked = new StringBuilder();
        for (CheckBox ch : checkBox) {
            if (ch.isChecked()) {
                checked.append(ch.getText().toString()).append(",");
            }
        }
        String[] hArr = checked.toString().split(",");
        List<String> cList = new ArrayList<>();
        for (String s : hArr) {
            cList.add(s);
        }
        return cList;
    }

    private List<Integer> sendRadio(String... text) {
        List<Integer> checkedList = new ArrayList<>();
        for (String t : text) {
            checkedList.add(radioConvertToNum(t));
        }
        return checkedList;
    }

    private int radioConvertToNum(String t) {
        switch (t) {
            case "매우 그렇다":
                return 4;
            case "그렇다":
                return 3;
            case "아니다":
                return 2;
            case "전혀 아니다":
                return 1;
            default:
                return 0;
        }
    }

    private void onClickShowAlert(int sProteinAmount, Integer[] sFlapreResult, Integer[] sPropreResult) {
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SurveyActivity.this)
                .setTitle("Protein Amount and Survey Results")
                .setMessage("Protein Amount: " + sProteinAmount + "\n" +
                        "Flavor Preferences: " + intArrayToString(sFlapreResult) + "\n" +
                        "Protein Preferences: " + intArrayToString(sPropreResult))
                .setPositiveButton("OK", (dialog, which) -> {
                    Intent intent = new Intent(SurveyActivity.this, MainActivity.class);
                    startActivity(intent);
                });

        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();
    }

    private String intArrayToString(Integer[] intArray) {
        StringBuilder result = new StringBuilder();
        for (Integer i : intArray) {
            result.append(i).append(", ");
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 2); // Remove the trailing comma and space
        }
        return result.toString();
    }

    private void updateUI(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private void setCheckBoxFalse(CheckBox... checkBoxes) {
        for (CheckBox checkBox : checkBoxes) {
            checkBox.setChecked(false);
        }
    }

    private String radioButtonNullCheck(RadioButton radioButton) {
        return (radioButton != null) ? radioButton.getText().toString() : null;
    }

    private int calculateProtein(int height, int weight, String trainingPurpose) {
        double proteinAmount;
        switch (trainingPurpose) {
            case "벌크업":
                proteinAmount = weight * 2.2;
                break;
            case "린매스업":
                proteinAmount = weight * 2.0;
                break;
            case "다이어트":
                proteinAmount = weight * 1.5;
                break;
            default:
                proteinAmount = weight * 1.0;
                break;
        }
        return (int) proteinAmount;
    }
}
