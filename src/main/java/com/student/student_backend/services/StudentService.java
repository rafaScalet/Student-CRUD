package com.student.student_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student_backend.entities.Student;
import com.student.student_backend.repositories.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<Student> getStudents () {
		return repository.findAll();
	}

	public Student getStudentById (int id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));
	}

}
