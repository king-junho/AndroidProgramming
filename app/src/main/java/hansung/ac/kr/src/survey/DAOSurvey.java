package hansung.ac.kr.src.survey;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOSurvey {
    private DatabaseReference databaseReference;

    public DAOSurvey() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Survey.class.getSimpleName());
    }

    // 등록
    public Task<Void> add(Survey survey) {
        return databaseReference.push().setValue(survey);
    }

    public DatabaseReference get() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference myRef = db.getReference();
        return myRef;
    }
}