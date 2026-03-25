package com.example.tdspringboot.validator;

import com.example.tdspringboot.exception.BadRequestException;
import com.example.tdspringboot.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator {
    public void validate (Student student) {
        if(student.getReference() == null || student.getReference().isBlank()) {
            throw new BadRequestException("NewStudent.reference cannot be null");
        }

        if(student.getFirstName() == null || student.getFirstName().isBlank()) {
            throw new BadRequestException("NewStudent.firstname cannot be null");
        }

        if(student.getLastName() == null || student.getLastName().isBlank()) {
            throw new BadRequestException("NewStudent.lastname cannot be null");
        }
    }
}
