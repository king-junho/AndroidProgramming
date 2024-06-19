package hansung.ac.kr.src.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;


public final class DietInfo {
    private String[][] calendar;

    public DietInfo(){
        calendar = new String[31][6];
        for(int i=0; i<31; i++){
            for(int j=0; j<6; j++){
                calendar[i][j]="0";
            }
        }
    }
    public String[][] getCalendar(){
        return calendar;
    }
    public void setCalendar(String[][] calendar){
        this.calendar=calendar;
    }
}
