package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Raina"),
            new Student(2, "Jaddu"),
            new Student(3, "Bravo")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findAny().orElseThrow(()->new IllegalStateException("student "+studentId+" does not exists"));
    }
}
