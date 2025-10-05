package com.tct.schoolManage.dto;

import com.tct.schoolManage.entity.Subject;

public class TeacherDTO {
    private Integer id;
    private String name;
    private Subject subject;

    public TeacherDTO(Integer id, String name, Subject subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}
