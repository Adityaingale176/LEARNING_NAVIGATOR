package com.example.Learning_Navigator.Learning_Navigator.Exception;

public class SubjectNotFoundException extends RuntimeException{

    public SubjectNotFoundException(int id){
        super("Subject with id " + id + " not found");
    }

}
