package com.lorin.deadlineschmedline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lorin.deadlineschmedline.R;
import com.lorin.deadlineschmedline.models.CourseAdapter;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private DatabaseReference mDatabase;
    private FirebaseUser mCurrentUser;
    private RecyclerView mCourseList;
    private CourseAdapter mAdapter;
    private int NUM_COURSE_ITEMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });

        displayListOfCourses();
    }

    private void displayListOfCourses() {

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        mCourseList = (RecyclerView) findViewById(R.id.rv_course_item_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mCourseList.setLayoutManager(layoutManager);
        mCourseList.setHasFixedSize(true);

        mAdapter = new CourseAdapter(NUM_COURSE_ITEMS);
        mCourseList.setAdapter(mAdapter);

    }

    private void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.add_component_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add_course:
                startActivity(new Intent(MainActivity.this, AddCourseActivity.class));
                return true;
            case R.id.add_course_component:
                startActivity(new Intent(MainActivity.this, AddCourseComponentActivity.class));
                return true;
            default:
                return true;
        }
    }

}
