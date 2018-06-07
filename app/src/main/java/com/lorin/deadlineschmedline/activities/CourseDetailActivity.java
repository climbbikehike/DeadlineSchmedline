package com.lorin.deadlineschmedline.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.lorin.deadlineschmedline.R;

import java.util.Date;

public class CourseDetailActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private FirebaseUser mCurrentUser;
    private EditText courseName;
    private Button buttonSave;
    private final Long DEFAULT_DATE = (new Date()).getTime();   // Today's Date
    private static final String TAG = "Course Detail Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        db = FirebaseFirestore.getInstance();
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        // TODO figure out how to access the course that got you here!
    }
}
