package com.example.Learning_Navigator.Learning_Navigator.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Learning_Navigator.Learning_Navigator.Entity.Exams;
import com.example.Learning_Navigator.Learning_Navigator.Entity.Students;
import com.example.Learning_Navigator.Learning_Navigator.Entity.Subjects;

public interface iService {

    public Students registerStudent(Students students);

    public Students updateStudent(int id, Students student);

    public Students getStudent(int id);

    public void deleteStudents(int id);

    public List<Students> getStudents();

    public Subjects createSubjects(Subjects subject);

    public Subjects getSubjects(int id);

    public Exams createExam(Exams exam);

    public List<Exams> getExams();

}
