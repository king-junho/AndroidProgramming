package hansung.ac.kr.src.diet_details.rv;

import java.io.Serializable;

public class DietDetailsDataClass implements Serializable {
    private String month;
    private String day;
    private String breakFast;
    private String lunch;
    private String dinner;
    private String snack_1;
    private String snack_2;

    public DietDetailsDataClass(String month, String day, String breakFast, String lunch, String dinner, String snack_1, String snack_2) {
        this.month = month;
        this.day = day;
        this.breakFast = breakFast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snack_1 = snack_1;
        this.snack_2 = snack_2;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBreakFast() {
        return breakFast;
    }

    public void setBreakFast(String breakFast) {
        this.breakFast = breakFast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getSnack_1() {
        return snack_1;
    }

    public void setSnack_1(String snack_1) {
        this.snack_1 = snack_1;
    }

    public String getSnack_2() {
        return snack_2;
    }

    public void setSnack_2(String snack_2) {
        this.snack_2 = snack_2;
    }
}