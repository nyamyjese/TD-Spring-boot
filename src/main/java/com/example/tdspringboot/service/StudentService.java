package com.example.tdspringboot.service;

import com.example.tdspringboot.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> studentsInMemory = new ArrayList<>();

    public void saveAll (List<Student> students) {
        studentsInMemory.addAll(students);
    }

    public List<Student> getAll() {
        return studentsInMemory;
    }
}
