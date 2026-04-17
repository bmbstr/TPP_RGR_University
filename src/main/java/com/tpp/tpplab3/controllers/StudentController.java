package com.tpp.tpplab3.controllers;

import com.tpp.tpplab3.models.Student;
import com.tpp.tpplab3.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/students")
    public List<Student> getStudents() {
        return repository.findAll();
    }
}