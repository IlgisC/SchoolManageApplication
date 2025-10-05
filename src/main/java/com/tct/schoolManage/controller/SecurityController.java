package com.tct.schoolManage.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hello, Admin!";
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/teacher")
    public String teacherEndpoint() {
        return "Hello, Teacher!";
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/student")
    public String studentEndpoint() {
        return "Hello, Student!";
    }

    @GetMapping("/")
    public String publicEndpoint() {
        return "Welcome to Hogwarts!";
    }
}