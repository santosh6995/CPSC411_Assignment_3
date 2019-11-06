package com.example.assignment2.Model;
public class Vehicle {
    protected int mYear;
    protected String mMake;
    protected String mModel;

    public Vehicle(String mk, String mdl, int y) {

        mMake = mk;
        mModel = mdl;
        mYear = y;
    }

    public int getyear() {
        return mYear;
    }

    public void setyear(int year) {
        mYear = year;
    }

    public String getMake() {
        return mMake;
    }

    public void setMake(String make) {
        mMake = make;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }
}
