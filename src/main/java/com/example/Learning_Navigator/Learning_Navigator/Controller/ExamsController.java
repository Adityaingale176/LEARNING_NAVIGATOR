package com.example.Learning_Navigator.Learning_Navigator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.example.Learning_Navigator.Learning_Navigator.Entity.Exams;
import com.example.Learning_Navigator.Learning_Navigator.Service.NavigatorService;

@RestController
@RequestMapping("/exams")
public class ExamsController {

    @Autowired
    private NavigatorService navigatorService;

    @PostMapping
    public ResponseEntity<Exams> createExam(@RequestBody Exams exams) {
        Exams createdExams =  navigatorService.createExam(exams);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExams);
    } 

    @GetMapping
    public ResponseEntity<List<Exams>> getAllExam() {
        List<Exams> allExams =  navigatorService.getExams();
        return ResponseEntity.status(HttpStatus.OK).body(allExams);
    }  
}
