package com.tct.schoolManage.dto;

import java.util.List;

public class StudentDTO {
    private Integer id;
    private String name;
    private List<SubjectDTO> subjectDTOList;

    public StudentDTO(Integer id, String name, List<SubjectDTO> subjectDTOList) {
        this.id = id;
        this.name = name;
        this.subjectDTOList = subjectDTOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjectDTOList() {
        return subjectDTOList;
    }

    public void setSubjectDTOList(List<SubjectDTO> subjectDTOList) {
        this.subjectDTOList = subjectDTOList;
    }
}
