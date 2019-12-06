package com.example.assignment2.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class StudentDB {

    private Context context;
    private SQLiteDatabase mSQLiteDatabase;
    private ArrayList<Student> mStudent;
    private Student student;
    public Integer c1;

    public StudentDB(Context c) {
        context = c;
        File dbFile = c.getDatabasePath("StudentDB.db");
        mSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(dbFile, null);
        createSQLTables();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(c);
        if (!prefs.getBoolean("firstTime", false)) {
            // <---- run your one time code here
            createStudentobject();
            // mark first time has ran.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }


    }
   /* private static final StudentDB myinstance = new StudentDB();



   static public StudentDB getInstance(){
       return myinstance;
  }*/



    private StudentDB(){

    }

    public ArrayList<Student> getstudentList() {
        return mStudent;
    }

    public void setstudentist(ArrayList<Student> StudentList) {
        mStudent  = StudentList;
    }

    public void addstudentist(Student StudentList) {
        StudentList.insert(mSQLiteDatabase);
    }

    public ArrayList<Student> retrieveStudentObjects() {
        ArrayList<Student> studentList = new ArrayList<Student>();

        Cursor cursor = mSQLiteDatabase.query("STUDENT", null, null, null, null, null,null );
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Student pObj = new Student();
                pObj.initFrom(cursor, mSQLiteDatabase);
                studentList.add(pObj);
            }
        }
        mStudent=studentList;

        return studentList;
    }



    protected void createSQLTables() {
        String sql = "CREATE TABLE IF NOT EXISTS STUDENT (FirstName Text, LastName Text, CWID INTEGER)";
        mSQLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE IF NOT EXISTS VEHICLE (Make Text, Model Text, Year INTEGER, CWID INTEGER)";
        mSQLiteDatabase.execSQL(sql);
    }
    public void createStudentobject(){




            student = new Student("Santosh", "Mandava", 893233296);
            ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>();
            vehicle.add(new Vehicle("Toyota", "Camry", 2012, 893233296));
            vehicle.add(new Vehicle("Ford", "Mustang", 2018, 893233296));
            student.setVehicleid(vehicle);
            mStudent = new ArrayList<Student>();
            student.insert(mSQLiteDatabase);
            mStudent.add(student);

            student = new Student("Vinay", "Manikyam", 888933213);
            ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
            vehicles.add(new Vehicle("Honda", "Civic", 2012, 888933213));
            vehicles.add(new Vehicle("Tesla", "Model3", 2018, 888933213));
            student.setVehicleid(vehicles);
            student.insert(mSQLiteDatabase);

            mStudent.add(student);
            final int c1=0;




    }


}
