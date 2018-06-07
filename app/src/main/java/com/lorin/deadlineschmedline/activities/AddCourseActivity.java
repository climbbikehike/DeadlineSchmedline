package com.lorin.deadlineschmedline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.lorin.deadlineschmedline.R;
import com.lorin.deadlineschmedline.models.Course;

import java.util.Date;

public class AddCourseActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private FirebaseUser mCurrentUser;
    private EditText courseName;
    private Button buttonSave;
    private final Long DEFAULT_DATE = (new Date()).getTime();   // Today's Date
    private static final String TAG = "Add Course Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        db = FirebaseFirestore.getInstance();
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

                db.collection("courses")
                        .add(course)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                            }
                        })

                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });

                startActivity(new Intent(AddCourseActivity.this, MainActivity.class));
            }
        });
    }
}
