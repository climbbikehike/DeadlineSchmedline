package com.lorin.deadlineschmedline.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.lorin.deadlineschmedline.R;
import com.lorin.deadlineschmedline.models.Course;

import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CourseDetailActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private FirebaseUser mCurrentUser;
    private Course course;

    private final Long DEFAULT_DATE = (new Date()).getTime();   // Today's Date
    private static final String TAG = "Course Detail Activity";

    @BindView(R.id.course_name)
    TextView courseName;

    @BindView(R.id.title_hours_worked)
    TextView titleHoursWorked;

    @BindView(R.id.number_hours_worked)
    TextView numberHoursWorked;

    @BindView(R.id.btn_time_stamp)
    Button btnTimeStamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        ButterKnife.bind(this);

        db = FirebaseFirestore.getInstance();
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        course = (Course) getIntent().getExtras().getSerializable("Course");
        setupCourseDetailViews();
    }

    private void setupCourseDetailViews() {
        courseName.setText(course.getName());
        titleHoursWorked.setText(R.string.title_hours_worked);
        numberHoursWorked.setText(String.format(Locale.US,"%.2f", course.getHoursWorked()));

        if (course.getTimeStampStarted()) {
            btnTimeStamp.setText(R.string.btn_end_time_stamp);
            btnTimeStamp.setBackgroundColor(getResources().getColor(R.color.btn_end_time_stamp));
        } else {
            btnTimeStamp.setText(R.string.btn_start_time_stamp);
            btnTimeStamp.setBackgroundColor(getResources().getColor(R.color.btn_start_time_stamp));
        }

        btnTimeStamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (course.getTimeStampStarted()) {
                    course.setEndTime((new Date()).getTime());
                    course.updateHourWorked();
                    numberHoursWorked.setText(String.format(Locale.US,"%.2f", course.getHoursWorked()));
                    course.setTimeStampStarted(false);
                } else {
                    course.setStartTime((new Date()).getTime());
                    course.setTimeStampStarted(true);
                }

                Intent intent = getIntent();
                intent.putExtra("Course", course);
                finish();
                startActivity(intent);
            }
        });


    }
}
