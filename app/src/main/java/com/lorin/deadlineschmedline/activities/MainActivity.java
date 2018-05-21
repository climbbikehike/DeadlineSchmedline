package com.lorin.deadlineschmedline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.lorin.deadlineschmedline.R;
import com.lorin.deadlineschmedline.adapters.CourseAdapter;
import com.lorin.deadlineschmedline.adapters.FirestoreAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements CourseAdapter.OnCourseSelectedListener,
        PopupMenu.OnMenuItemClickListener {

    private FirebaseFirestore mFirestore;
    private Query mQuery;
    private FirebaseUser mCurrentUser;

    private CourseAdapter mAdapter;

    private static final String TAG = "MainActivity";
    private static final int RC_SIGN_IN = 9001;
    private static final int LIMIT = 50;

    @BindView(R.id.rv_course_item_list)
    RecyclerView mCourseRecyvlerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });

        // Enable Firestore logging
        FirebaseFirestore.setLoggingEnabled(true);

        // Firestore
        mFirestore = FirebaseFirestore.getInstance();
        mQuery = mFirestore.collection("courses").orderBy("name").limit(LIMIT);
        mAdapter = new CourseAdapter(mQuery, this) {
            @Override
            protected void onDataChanged() {
                // Show/hide content if the query returns empty.
                if (getItemCount() == 0) {
                    mCourseRecyvlerView.setVisibility(View.VISIBLE);
                    //mEmptyView.setVisibility(View.VISIBLE);
                } else {
                    mCourseRecyvlerView.setVisibility(View.VISIBLE);
                    //mEmptyView.setVisibility(View.GONE);
                }
            }

            @Override
            protected void onError(FirebaseFirestoreException e) {
                // Show a snackbar on errors
                Snackbar.make(findViewById(android.R.id.content),
                        "Error: check logs for info.", Snackbar.LENGTH_LONG).show();
            }
        };

        mCourseRecyvlerView.setLayoutManager(new LinearLayoutManager(this));
        mCourseRecyvlerView.setAdapter(mAdapter);
    }

    private void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.add_component_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
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

    @Override
    public void onCourseSelected(DocumentSnapshot restaurant) {
        // Go to the details page for the selected activity
        Intent intent = new Intent(this, AddCourseActivity.class);
        startActivity(intent);

        //overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

}
