package com.example.Learning_Navigator.Learning_Navigator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Learning_Navigator.Learning_Navigator.Entity.Students;
import com.example.Learning_Navigator.Learning_Navigator.Service.NavigatorService;
import com.example.Learning_Navigator.Learning_Navigator.Service.ThirdPartyService;

import jakarta.persistence.Id;

@RestController 
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private NavigatorService navigatorService;

    @Autowired
    private ThirdPartyService thirdPartyService;

    @PostMapping()
    public ResponseEntity<Students> registerStudent(@RequestBody Students student) {
        Students createdStudent = navigatorService.registerStudent(student);
        return new ResponseEntity<Students>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Students> updateStudent(@PathVariable int id, @RequestBody Students student) {
        Students updatedStudent = navigatorService.updateStudent(id, student);
        return new ResponseEntity<Students>(updatedStudent, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudent(@PathVariable int id) {
        Students createdStudent = navigatorService.getStudent(id);
        return new ResponseEntity<Students>(createdStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudents(@PathVariable int id) {
        navigatorService.deleteStudents(id);
        return new ResponseEntity<>("Student with id " + id + "deleted",HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Students>> getStudents() {
        List<Students> listOfStudents = navigatorService.getStudents();
        return new ResponseEntity<List<Students>>(listOfStudents, HttpStatus.OK);
    }
    
    //Enroll in a subject
    @PutMapping("enroll/{studentId}/{subjectId}")
    public ResponseEntity enrollInSubject(@PathVariable int studentId, @PathVariable int subjectId){
        Students student =  navigatorService.enrollInSubject(studentId, subjectId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PutMapping("register/{studentId}/{examId}")
    public ResponseEntity registerForExam(@PathVariable int studentId , @PathVariable int examId){
        Students student =  navigatorService.registerForExam(studentId, examId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/hidden-feature/{numbers}")
    public ResponseEntity<String> easterEggFeature(@PathVariable int numbers){

        return thirdPartyService.thirdPartyCall(numbers);
    } 
}
