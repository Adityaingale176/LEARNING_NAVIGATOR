package com.example.Learning_Navigator.Learning_Navigator.Controller;

import java.util.List;

import javax.security.auth.Subject;

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

import com.example.Learning_Navigator.Learning_Navigator.Entity.Subjects;
import com.example.Learning_Navigator.Learning_Navigator.Service.NavigatorService;

@RestController
@RequestMapping("/subjects")
public class SubjectsController {

    @Autowired
    NavigatorService navigatorService;

    @PostMapping
    public ResponseEntity<Subjects> createSubject(@RequestBody Subjects subject) {
        Subjects subjectCreated = navigatorService.createSubjects(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subjects> getSubjects(@PathVariable int id) {
        Subjects subject = navigatorService.getSubjects(id);
        return ResponseEntity.ok(subject);
    }

    @GetMapping
    public ResponseEntity<List<Subjects>> getSubjects() {
        List<Subjects> subject = navigatorService.getAllSubjects();
        return ResponseEntity.status(HttpStatus.OK).body(subject);
    }

}
