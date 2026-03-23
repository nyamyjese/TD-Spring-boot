package com.example.tdspringboot.controller;

import com.example.tdspringboot.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> studentList = new ArrayList<>();

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(name = "name" , required = false) String name){
        if(name == null || name.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
        return ResponseEntity.ok("Welcome " + name);
    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> students){
        try{
            studentList.addAll(students);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(studentList);
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping("/students")
    public ResponseEntity<Object> getStudents(@RequestHeader(value = "Accept" , required = false) String acceptHeader){
        try{
            if(acceptHeader == null){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }
            if(!"text/plain".equals(acceptHeader) && !"application/json".equals(acceptHeader)){
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED)
                        .build();
            }
            return ResponseEntity.ok(studentList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
