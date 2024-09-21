package com.student.student_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student_backend.entities.Student;
import com.student.student_backend.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<Student> getStudents () {
		return repository.findAll();
	}

}
