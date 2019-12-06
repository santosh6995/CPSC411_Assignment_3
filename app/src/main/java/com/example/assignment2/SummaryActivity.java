package com.example.assignment2;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ListView;

import com.example.assignment2.Adapter.Summaryadapter;
import com.example.assignment2.Model.Course;
import com.example.assignment2.Model.Student;
import com.example.assignment2.Model.StudentDB;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {
    protected ListView mSummaryView;
    protected final String TAG = "Summary Screen";
    protected Summaryadapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_list_lv);
        mSummaryView = findViewById(R.id.summary_list_id);
        new StudentDB(this).retrieveStudentObjects();
        ad = new Summaryadapter(this);
        mSummaryView.setAdapter(ad);

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called");

        ad.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume() called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause() called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }
}


