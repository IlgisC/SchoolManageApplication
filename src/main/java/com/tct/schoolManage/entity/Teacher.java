package com.tct.schoolManage.entity;

import jakarta.persistence.*;

@Entity
public class Teacher {

    @Id
    private Integer id;
    private String name;
    @OneToOne
    private Subject subject;

    public Teacher() {
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