package com.example.Learning_Navigator.Learning_Navigator.Service;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Learning_Navigator.Learning_Navigator.Entity.Exams;
import com.example.Learning_Navigator.Learning_Navigator.Entity.Students;
import com.example.Learning_Navigator.Learning_Navigator.Entity.Subjects;
import com.example.Learning_Navigator.Learning_Navigator.Exception.ExamNotFoundException;
import com.example.Learning_Navigator.Learning_Navigator.Exception.StudentNotFoundException;
import com.example.Learning_Navigator.Learning_Navigator.Exception.SubjectNotEnrolledException;
import com.example.Learning_Navigator.Learning_Navigator.Exception.SubjectNotFoundException;
import com.example.Learning_Navigator.Learning_Navigator.Repository.ExamsRepository;
import com.example.Learning_Navigator.Learning_Navigator.Repository.StudentRepository;
import com.example.Learning_Navigator.Learning_Navigator.Repository.SubjectsRepository;

@Service
public class NavigatorService implements iService{  

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ExamsRepository examsRepository;
    @Autowired
    private SubjectsRepository subjectsRepository;

    @Override
    public Students registerStudent(Students students) {
        return studentRepository.save(students);
    }

    @Override
    public Students updateStudent(int id, Students student) {

        Students fetchedStudent = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
        fetchedStudent.setStudentName(student.getStudentName());
        fetchedStudent.setEnrolledSubjects(student.getEnrolledSubjects());
        fetchedStudent.setRegisteredExams(student.getRegisteredExams());

        return studentRepository.save(fetchedStudent);
    }

    @Override
    public Students getStudent(int id) {
            return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
    }

    @Override
    public void deleteStudents(int id) {
        if (!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public List<Students> getStudents() {
        return studentRepository.findAll();
    }

    //Enroll in a subject
    public Students enrollInSubject(int studentId, int subjectId){
        Students fetchedStudent = studentRepository.findById(studentId).orElseThrow(()-> new StudentNotFoundException(studentId));
        Subjects subject = subjectsRepository.findById(subjectId).orElseThrow(()-> new SubjectNotFoundException(subjectId));
        fetchedStudent.getEnrolledSubjects().add(subject);
        return studentRepository.save(fetchedStudent);
    }   

    //Register for a exam (After subject Enrollment)
    public Students registerForExam(int studentId , int examId){
        Students fetchedStudent = studentRepository.findById(studentId).orElseThrow(()-> new StudentNotFoundException(studentId));
        Exams exam = examsRepository.findById(examId).orElseThrow(()-> new ExamNotFoundException(examId));
        if(fetchedStudent.getEnrolledSubjects().contains(exam.getSubject())){
            fetchedStudent.getRegisteredExams().add(exam);
        }
        else {
            throw new SubjectNotEnrolledException(studentId , exam.getSubject());
        }
        
        return studentRepository.save(fetchedStudent);
    }
    
    //-------------------------- Exams Service Methods--------------------------

    @Override
   public Exams createExam(Exams exam){
    return examsRepository.save(exam);
   }

    @Override
    public List<Exams> getExams() {
        return examsRepository.findAll();   
    }
    //-------------------------- Subjects Service Methods--------------------------

    public Subjects createSubjects(Subjects subject){
        return subjectsRepository.save(subject);
    }

    public Subjects getSubjects(int id){
        return subjectsRepository.findById(id).orElseThrow(()-> new SubjectNotFoundException(id));
    }

    public List<Subjects> getAllSubjects() {
      return subjectsRepository.findAll();
    }
}
