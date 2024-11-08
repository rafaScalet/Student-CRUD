package com.student.student_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.student_backend.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{ }
