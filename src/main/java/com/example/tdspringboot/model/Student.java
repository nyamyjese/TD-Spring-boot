package com.example.tdspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Student {
    private String reference;
    private String firstName;
    private String lastName;
}
