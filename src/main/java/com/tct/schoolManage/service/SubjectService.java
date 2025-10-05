package com.tct.schoolManage.service;

import com.tct.schoolManage.dto.SubjectDTO;
import com.tct.schoolManage.entity.Subject;
import com.tct.schoolManage.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    public SubjectService(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    // Convert Entity to DTO
    SubjectDTO convertToDTO(Subject subject) {
        return new SubjectDTO(subject.getId(), subject.getName(), subject.getGrade());
    }
    // Convert DTO to Entity
    Subject convertToEntity(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setId(subjectDTO.getId());
        subject.setName(subjectDTO.getName());
        subject.setGrade(subjectDTO.getGrade());
        return subject;
    }


    // All subjects get listed
    public List<SubjectDTO> listSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    // Admin can create a new subject to the list
    public SubjectDTO addSubject(SubjectDTO subjectDTO) {
        Subject subject = convertToEntity(subjectDTO);
        Subject savedSubject = subjectRepository.save(subject);
        return convertToDTO(savedSubject);
    }


    // Admin can update an existing subject
    public Optional<SubjectDTO> updateSubject(Integer id, SubjectDTO subjectDTO) {
        if (subjectRepository.existsById(id)) {
            Subject subject = convertToEntity(subjectDTO);
            subject.setId(id);
            Subject updatedSubject = subjectRepository.save(subject);
            return Optional.of(convertToDTO(updatedSubject));
        }
        return Optional.empty();
    }

    // Admin can delete a subject from the list by using its id
    public boolean deleteSubject(Integer id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}