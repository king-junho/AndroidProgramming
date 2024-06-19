package hansung.ac.kr.src.fg_calendar.data_class;

public class ProteinAmountDataClass {

    private int targetAmount;
    private int currentAmount;

    public ProteinAmountDataClass(int targetAmount, int currentAmount) {
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
    }

    public int getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(int targetAmount) {
        this.targetAmount = targetAmount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }
}