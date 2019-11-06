package com.example.assignment2.Model;

import android.widget.VideoView;

import java.util.ArrayList;

public class StudentDB {

    private static final StudentDB myinstance = new StudentDB();

    private ArrayList<Student> mStudent;

    static public StudentDB getInstance(){
        return myinstance;
    }

    private StudentDB(){
        createStudentobject();
    }

    public ArrayList<Student> getstudentList() {
        return mStudent;
    }

    public void setstudentist(ArrayList<Student> StudentList) {
        mStudent  = StudentList;
    }

    protected void createStudentobject(){



        Student student = new Student("Santosh","Mandava",893233296);
        ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>();
        vehicle.add(new Vehicle("Toyota","Camry",2012));
        vehicle.add(new Vehicle("Ford","Mustang",2018));
        student.setVehicleid(vehicle);
        mStudent = new ArrayList<Student>();

        mStudent.add(student);

        student = new Student("Vinay", "Manikyam",888933213);
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("Honda","Civic",2012));
        vehicles.add(new Vehicle("Tesla","Model3",2018));
        student.setVehicleid(vehicles);
        mStudent.add(student);




    }


}
