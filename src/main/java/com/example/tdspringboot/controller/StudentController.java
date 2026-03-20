package com.example.tdspringboot.controller;

import com.example.tdspringboot.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class StudentController {
    private List<Student> studentList = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name){
        return "Welcome" + name;
    }

    @PostMapping("/students")
    private String addStudent(@RequestBody List<Student> students){
        studentList.addAll(students);
        String nm ="";
        for(Student std:students){
            nm = nm+std.getFirstName()+" ";
        }
        return nm;
    }

    @GetMapping("/students")
    public String getStudents(@RequestHeader("Accept") String acceptHeader){
        if("text/plain".equals(acceptHeader)){
            String students ="";
            for(Student std:studentList){
                students = students + std.getFirstName()+" ";
            }
            return students;
        }
        else {
            return "Format not supported";
        }
    }
}
