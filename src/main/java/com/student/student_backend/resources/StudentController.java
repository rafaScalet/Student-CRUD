package com.student.student_backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.student.student_backend.entities.Student;
import com.student.student_backend.services.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("students")
	public List<Student> getStudents () {
		return service.getStudents();
	}

	@GetMapping("students/{id}")
	public Student getStudentById (@PathVariable int id) {
		return service.getStudentById(id);
	}

	@PostMapping("student")
	public Student saveStudent (@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@DeleteMapping("student/{id}")
	public void deleteStudent (@PathVariable int id) {
		service.deleteStudent(id);
	}
}
