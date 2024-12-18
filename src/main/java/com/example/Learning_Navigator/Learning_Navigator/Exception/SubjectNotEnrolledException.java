package com.example.Learning_Navigator.Learning_Navigator.Exception;

import com.example.Learning_Navigator.Learning_Navigator.Entity.Subjects;

public class SubjectNotEnrolledException extends RuntimeException{

    public SubjectNotEnrolledException(int studentId , Subjects subject){
        super("Student with id " + studentId + "is not enrolled for subject " + subject.getSubjectName());
    }

}
