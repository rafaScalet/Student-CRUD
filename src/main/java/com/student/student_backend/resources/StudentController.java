package com.student.student_backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.student.student_backend.entities.Student;
import com.student.student_backend.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("students")
	public List<Student> getStudents () {
		return service.getStudents();
	}

}
