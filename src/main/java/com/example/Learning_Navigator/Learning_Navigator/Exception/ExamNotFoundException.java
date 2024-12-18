package com.example.Learning_Navigator.Learning_Navigator.Exception;

public class ExamNotFoundException extends RuntimeException{

    public ExamNotFoundException(int id){
        super("exam with id " + id + " Not Found");
    }

}
