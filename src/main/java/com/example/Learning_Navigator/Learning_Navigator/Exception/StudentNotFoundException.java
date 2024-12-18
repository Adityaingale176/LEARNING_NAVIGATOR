package com.example.Learning_Navigator.Learning_Navigator.Exception;

import java.lang.management.RuntimeMXBean;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(int id){

        super("Student with id " + id + " not found");
    }

}
