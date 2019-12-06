package com.example.assignment2.Model;



import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;

import java.util.ArrayList;

public class Student extends PersistentObject{
    protected String mFirstname;
    protected String mLastname;
    protected int mcwid;

    protected ArrayList<com.example.assignment2.Model.Course> mCourseid;
    protected ArrayList<com.example.assignment2.Model.Vehicle> mvehicle;

    public Student(){

    }

    public Student(String fname,String lname, int id){
        mFirstname = fname;
        mLastname = lname;
        mcwid = id;
    }

    public String getFirstname(){
        return mFirstname;
    }

    public String getLastname(){
        return mLastname;
    }

    public int getCwid(){
        return mcwid;
    }


    public void Setfirstname(String fname){
        mFirstname=fname;
    }

    public void Setlastname(String lname){
        mLastname=lname;
    }

    public void SetCwid(int cid){
        mcwid=cid;
    }


    public void setVehicleid(ArrayList<Vehicle>  veh){ mvehicle = veh;
    }

    public ArrayList<Vehicle> getVehicleid(){
        return mvehicle;
    }

    @Override
    public void insert(SQLiteDatabase db) {
        //
        ContentValues vals = new ContentValues();
        vals.put("FirstName", mFirstname);
        vals.put("LastName", mLastname);
        vals.put("CWID", mcwid);



        db.insert("Student", null, vals);

        // Insert the vehicle objects
        for (int i=0; i<mvehicle.size(); i++) {
            mvehicle.get(i).insert(db);
        }
    }


    @Override
    public void initFrom(Cursor c, SQLiteDatabase db) {
        mFirstname = c.getString(c.getColumnIndex("FirstName"));
        mLastname = c.getString(c.getColumnIndex("LastName"));
        mcwid = c.getInt(c.getColumnIndex("CWID"));

        // retrieve the owned vehicle objects
        mvehicle = new ArrayList<Vehicle>();
        Cursor cursor = db.query("VEHICLE", null, "CWID=?", new String[]{new Integer(mcwid).toString()},null,null,null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Vehicle vObj = new Vehicle();
                vObj.initFrom(cursor, db);
                mvehicle.add(vObj);
            }
        }
    }




}
