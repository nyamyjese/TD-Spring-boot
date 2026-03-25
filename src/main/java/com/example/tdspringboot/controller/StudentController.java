package com.example.tdspringboot.controller;

import com.example.tdspringboot.exception.BadRequestException;
import com.example.tdspringboot.model.Student;
import com.example.tdspringboot.service.StudentService;
import com.example.tdspringboot.validator.StudentValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;
    private final StudentValidator studentValidator;

    public StudentController(StudentService studentService, StudentValidator studentValidator) {
        this.studentService = studentService;
        this.studentValidator = studentValidator;
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody List<Student> newStudents) {
        try{
            for(Student newStudent : newStudents){
                studentValidator.validate(newStudent);
            }
            studentService.saveAll(newStudents);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type" , "application/json")
                    .body(studentService.getAll());
        }
        catch (BadRequestException e ){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type" , "application/json")
                    .body(e.getMessage());
        }
    }
}