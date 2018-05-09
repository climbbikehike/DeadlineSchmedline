package com.lorin.deadlineschmedline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lorin.deadlineschmedline.R;
import com.lorin.deadlineschmedline.models.Course;

import java.util.Date;

public class AddCourseActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText courseName;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Set up the button and text inputs for the course
        courseName = (EditText) findViewById(R.id.course_name);
       // courseType = (EditText) findViewById(R.id.course_type);
        buttonSave = (Button) findViewById(R.id.button_save);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Course course = new Course(courseName.toString(), new Date(), new Date(1577836800), 0.0);
                mDatabase.setValue(course);

                //TODO make sure that the database is saving on a per user basis and saving Course objects

                startActivity(new Intent(AddCourseActivity.this, MainActivity.class));
            }
        });
    }
}
