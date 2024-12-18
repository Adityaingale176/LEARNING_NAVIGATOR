package com.example.Learning_Navigator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Learning_Navigator.Learning_Navigator.Entity.Exams;
import com.example.Learning_Navigator.Learning_Navigator.Entity.Students;
import com.example.Learning_Navigator.Learning_Navigator.Entity.Subjects;
import com.example.Learning_Navigator.Learning_Navigator.Repository.ExamsRepository;
import com.example.Learning_Navigator.Learning_Navigator.Repository.StudentRepository;
import com.example.Learning_Navigator.Learning_Navigator.Repository.SubjectsRepository;
import com.example.Learning_Navigator.Learning_Navigator.Service.NavigatorService;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private NavigatorService navigatorService;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private SubjectsRepository subjectsRepository;
    @Mock
    private ExamsRepository examsRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterStudent(){
        Students student = new Students();
        student.setStudentName("John Doe");

        when(studentRepository.save(any(Students.class))).thenReturn(student);
        navigatorService.registerStudent(student);

        verify(studentRepository, times(1)).save(student);

    }

    @Test
    public void testEnrollSubject(){
        Students student = new Students();
        student.setId(1);
        Subjects subject = new Subjects();
        subject.setId(1);

        when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));
        when(subjectsRepository.findById(anyInt())).thenReturn(Optional.of(subject));

        navigatorService.enrollInSubject(student.getId(), subject.getId());
        
        verify(studentRepository, times(1)).findById(anyInt());
        verify(subjectsRepository, times(1)).findById(anyInt());
        verify(studentRepository, times(1)).save(student);
    }   

    @Test
    public void registerForExam(){
        
        Subjects subject = new Subjects();
        subject.setId(1);
        subject.setSubjectName("Math");

        Students student = new Students();
        student.setId(1);
        student.setStudentName("John Doe");
        student.getEnrolledSubjects().add(subject);

        Exams exam = new Exams();
        exam.setId(1);
        exam.setSubject(subject);

        when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));
        when(examsRepository.findById(anyInt())).thenReturn(Optional.of(exam));

        Students result = navigatorService.registerForExam(1, 1);

        verify(studentRepository, times(1)).save(student);
    }




}
