package com.lorin.deadlineschmedline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lorin.deadlineschmedline.R;
import com.lorin.deadlineschmedline.models.Course;

import java.util.Date;

public class AddCourseActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseUser mCurrentUser;
    private EditText courseName;
    private Button buttonSave;
    private final Long DEFAULT_DATE = (new Date()).getTime();   // Today's Date

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        //Set up the button and text inputs for the course
        courseName = (EditText) findViewById(R.id.course_name);
       // courseType = (EditText) findViewById(R.id.course_type);
        buttonSave = (Button) findViewById(R.id.button_save);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Course course = new Course(courseName.getText().toString(),
                                            new Date().getTime(),
                                            DEFAULT_DATE,
                                            0.0);

                mDatabase.child("users")
                            .child(mCurrentUser.getUid())
                            .child("courses")
                            .child(courseName.getText().toString())
                            .setValue(course);

                startActivity(new Intent(AddCourseActivity.this, MainActivity.class));
            }
        });
    }
}
