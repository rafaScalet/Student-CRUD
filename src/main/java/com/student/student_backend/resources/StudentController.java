package com.student.student_backend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.student.student_backend.entities.Student;
import com.student.student_backend.services.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("students")
	public ResponseEntity<List<Student>> getStudents () {
		return ResponseEntity.ok(service.getStudents());
	}

	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudentById (@PathVariable int id) {
		return ResponseEntity.ok(service.getStudentById(id));
	}

	@PostMapping("student")
	public ResponseEntity<Student> saveStudent (@RequestBody Student student) {
		Student createdStudent = service.saveStudent(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdStudent.getId()).toUri();

		return ResponseEntity.created(location).body(createdStudent);
	}

	@DeleteMapping("student/{id}")
	public ResponseEntity<Void> deleteStudent (@PathVariable int id) {
		service.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("student/{id}")
	public ResponseEntity<Void> updateStudent (@PathVariable int id, @RequestBody Student student) {
		service.updateStudent(id, student);
		return ResponseEntity.ok().build();
	}
}
