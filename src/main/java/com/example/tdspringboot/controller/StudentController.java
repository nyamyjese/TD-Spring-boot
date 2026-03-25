package com.example.tdspringboot.controller;

import com.example.tdspringboot.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> studentsInMemory = new ArrayList<>();

    @PostMapping("/students")
    public ResponseEntity<?> createStudents(
            @RequestBody List<Student> newStudents) {
        for (Student newStudent : newStudents) {
            if (newStudent.getReference() == null || newStudent.getReference().isBlank()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("Content-Type", "text/plain")
                        .body("NewStudent.reference cannot be null");
            }
            if (newStudent.getFirstName() == null || newStudent.getFirstName().isBlank()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("Content-Type", "text/plain")
                        .body("NewStudent.firstname cannot be null");
            }
            if (newStudent.getLastName() == null || newStudent.getLastName().isBlank()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("Content-Type", "text/plain")
                        .body("NewStudent.name cannot be null");
            }
        }

        studentsInMemory.addAll(newStudents);

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(studentsInMemory);
    }
}