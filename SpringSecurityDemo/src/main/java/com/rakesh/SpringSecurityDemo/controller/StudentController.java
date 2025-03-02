package com.rakesh.SpringSecurityDemo.controller;

import com.rakesh.SpringSecurityDemo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
            new Student(101,"Rakesh","Java"),
            new Student(102,"Diptisha","CyberSecurity")

    ));

    @GetMapping("/csrf-token")
    public CsrfToken getCsrf(HttpServletRequest req)
    {
        return (CsrfToken) req.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student s)
    {
        students.add(s);
    }
}
