package com.tct.schoolManage.service;

import com.tct.schoolManage.dto.TeacherDTO;
import com.tct.schoolManage.entity.Teacher;
import com.tct.schoolManage.repository.SubjectRepository;
import com.tct.schoolManage.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public TeacherService(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    public TeacherDTO convertToDTO(Teacher teacher) {
        return new TeacherDTO(teacher.getId(), teacher.getName(), teacher.getSubject());
    }

    // Convert TeacherDTO to Teacher entity
    public Teacher convertToEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setName(teacherDTO.getName());
        teacher.setSubject(teacherDTO.getSubject());
        return teacher;
    }

    public List<TeacherDTO> listTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get teacher by ID
    public Optional<TeacherDTO> findTeacherById(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.map(this::convertToDTO);
    }

    // Save or update teacher
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = convertToEntity(teacherDTO);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return convertToDTO(savedTeacher);
    }
}