package hansung.ac.kr.src.survey;

import java.util.List;

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

    // Getters and setters (generated automatically or manually as needed)
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_height() {
        return user_height;
    }

    public void setUser_height(String user_height) {
        this.user_height = user_height;
    }

    public String getUser_weight() {
        return user_weight;
    }

    public void setUser_weight(String user_weight) {
        this.user_weight = user_weight;
    }

    public String getUser_proteinPurpose() {
        return user_proteinPurpose;
    }

    public void setUser_proteinPurpose(String user_proteinPurpose) {
        this.user_proteinPurpose = user_proteinPurpose;
    }

    public String getUser_trainingPurpose() {
        return user_trainingPurpose;
    }

    public void setUser_trainingPurpose(String user_trainingPurpose) {
        this.user_trainingPurpose = user_trainingPurpose;
    }

    public String getUser_trainingCnt() {
        return user_trainingCnt;
    }

    public void setUser_trainingCnt(String user_trainingCnt) {
        this.user_trainingCnt = user_trainingCnt;
    }

    public String getUser_trainingTime() {
        return user_trainingTime;
    }

    public void setUser_trainingTime(String user_trainingTime) {
        this.user_trainingTime = user_trainingTime;
    }

    public List<String> getUser_dietCnt() {
        return user_dietCnt;
    }

    public void setUser_dietCnt(List<String> user_dietCnt) {
        this.user_dietCnt = user_dietCnt;
    }

    public List<String> getUser_allergy() {
        return user_allergy;
    }

    public void setUser_allergy(List<String> user_allergy) {
        this.user_allergy = user_allergy;
    }

    public String getUser_snackYn() {
        return user_snackYn;
    }

    public void setUser_snackYn(String user_snackYn) {
        this.user_snackYn = user_snackYn;
    }

    public List<Integer> getUser_proPre() {
        return user_proPre;
    }

    public void setUser_proPre(List<Integer> user_proPre) {
        this.user_proPre = user_proPre;
    }

    public List<Integer> getUser_flaPre() {
        return user_flaPre;
    }

    public void setUser_flaPre(List<Integer> user_flaPre) {
        this.user_flaPre = user_flaPre;
    }

    public Integer getUser_proteinAmount() {
        return user_proteinAmount;
    }

    public void setUser_proteinAmount(Integer user_proteinAmount) {
        this.user_proteinAmount = user_proteinAmount;
    }
}