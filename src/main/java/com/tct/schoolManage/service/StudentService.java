package com.tct.schoolManage.service;

import com.tct.schoolManage.dto.StudentDTO;
import com.tct.schoolManage.dto.SubjectDTO;
import com.tct.schoolManage.entity.Student;
import com.tct.schoolManage.entity.Subject;
import com.tct.schoolManage.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {


    private final StudentRepository studentRepository;
    private final SubjectService subjectService;  // Assuming you already have a SubjectService

    public StudentService(StudentRepository studentRepository, SubjectService subjectService) {
        this.studentRepository = studentRepository;
        this.subjectService = subjectService;
    }

    // Convert Student Entity to DTO
    private StudentDTO convertToDTO(Student student) {
        List<SubjectDTO> subjectDTOs = student.getSubjectList().stream()
                .map(subjectService::convertToDTO)
                .collect(Collectors.toList());
        return new StudentDTO(student.getId(), student.getName(), subjectDTOs);
    }

    // Convert Student DTO to Entity
    private Student convertToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        List<Subject> subjects = studentDTO.getSubjectDTOList().stream()
                .map(subjectDTO -> subjectService.convertToEntity(subjectDTO))
                .collect(Collectors.toList());
        student.setSubjectList(subjects);
        return student;
    }

    // List all the students
    public List<StudentDTO> listStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get a specific student's details by id
    public Optional<StudentDTO> findStudentById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(this::convertToDTO);
    }

    // Create a new student
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    public List<SubjectDTO> listSubjects() {
        return null;
    }

    public SubjectDTO addSubject(SubjectDTO subjectDTO) {
        SubjectDTO subjectDTO1 = new SubjectDTO();
        return subjectDTO1;
    }

    public Optional<SubjectDTO> updateSubject(Integer id, SubjectDTO subjectDTO) {
        return null;
    }

    public boolean deleteSubject(Integer id) {
        return false;
    }
}