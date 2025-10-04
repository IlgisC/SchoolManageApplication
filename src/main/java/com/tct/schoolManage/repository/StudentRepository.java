package com.tct.schoolManage.repository;

import com.tct.schoolManage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}