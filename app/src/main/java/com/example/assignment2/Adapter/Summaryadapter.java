package com.example.assignment2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment2.Model.Student;
import com.example.assignment2.Model.StudentDB;
import com.example.assignment2.R;
import com.example.assignment2.StudentDetails;

import java.util.ArrayList;

public class Summaryadapter extends BaseAdapter {

    ArrayList<Student> mstudentList;
    StudentDB mStudentDB;

    public Summaryadapter(Context context) {
        mStudentDB = new StudentDB(context);
        mstudentList = mStudentDB.retrieveStudentObjects();
    }


    @Override
    public int getCount() {
        return mStudentDB.getstudentList().size();
    }

    @Override
    public Object getItem(int i) {
        return mStudentDB.getstudentList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.student_row, viewGroup, false);
        } else row_view = view;

        Student s = mStudentDB.retrieveStudentObjects().get(i);

        ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFirstname());
        ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLastname());
        row_view.setTag(new Integer(i));
        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Page Navigation
                        Intent intent = new Intent(view.getContext(), StudentDetails.class);
                        intent.putExtra("StudentIndex", ((Integer)view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );
        return row_view;
    }
}
