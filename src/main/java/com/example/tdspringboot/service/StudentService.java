package com.example.tdspringboot.service;

import com.example.tdspringboot.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> studentsInMemory = new ArrayList<>();

    public void saveAll (List<Student> students) {
        studentsInMemory.addAll(students);
    }

    public List<Student> getAll() {
        return studentsInMemory;
    }
}
