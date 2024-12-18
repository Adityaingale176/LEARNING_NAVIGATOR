package com.example.Learning_Navigator.Learning_Navigator.Entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Students {

    @Id
    @GeneratedValue
    private int id;

    private String studentName;

    @ManyToMany
    @JoinTable(
        name = "students_subjects",
        joinColumns = @JoinColumn(name = "student_Id"),  
        inverseJoinColumns = @JoinColumn(name = "subject_Id")  
    )
    private List<Subjects> enrolledSubjects = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "students_exams",
        joinColumns = @JoinColumn(name = "studen_Id"),
        inverseJoinColumns = @JoinColumn(name = "exam_Id")
    )
    private List<Exams> registeredExams = new ArrayList<>();
}