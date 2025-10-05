package com.tct.schoolManage.controller;

import com.tct.schoolManage.dto.SubjectDTO;
import com.tct.schoolManage.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final StudentService subjectService;
    public SubjectController (StudentService subjectService){
        this.subjectService = subjectService;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'STUDENT')")
    @GetMapping("/list")
    public List<SubjectDTO> listSubjects() {
        return subjectService.listSubjects();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<SubjectDTO> addSubject(@RequestBody SubjectDTO subjectDTO) {
        SubjectDTO createdSubject = subjectService.addSubject(subjectDTO);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<SubjectDTO> updateSubject(@PathVariable Integer id, @RequestBody SubjectDTO subjectDTO) {
        Optional<SubjectDTO> updatedSubject = subjectService.updateSubject(id, subjectDTO);
        return updatedSubject.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Integer id) {
        if (subjectService.deleteSubject(id)) {
            return ResponseEntity.ok().build();   //if the subject is deleted successfully
        } else {
            return ResponseEntity.notFound().build();   //if the subject doesn't exist already
        }
    }
}