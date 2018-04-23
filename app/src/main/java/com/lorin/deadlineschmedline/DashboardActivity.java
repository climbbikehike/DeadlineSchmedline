package com.lorin.deadlineschmedline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Deadline Schmedline");
        setContentView(R.layout.activity_dashboard);
    }
}
