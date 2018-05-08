package com.lorin.deadlineschmedline.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.lorin.deadlineschmedline.R;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO replace with a menu for type of thing to add
                showPopup(view);

            }
        });
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


    // Main activity is to display a list of courses created

    //TODO Provide functionality for floating action button - generates new acitivity?
    //TODO Generate a list of courses for the User - need DB persistence for this
}
