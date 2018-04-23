package com.lorin.deadlineschmedline.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.lorin.deadlineschmedline.R;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Deadline Schmedline");
        setContentView(R.layout.activity_dashboard);
    }
}
