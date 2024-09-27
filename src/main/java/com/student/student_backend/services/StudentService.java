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

	public Student saveStudent (Student student) {
		return repository.save(student);
	}

	public void deleteStudent (int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return;
		}

		throw new EntityNotFoundException("Student not found");
	}

	public void updateStudent (int id, Student student) {
		Student temp = repository.getReferenceById(id);

		temp.setName(student.getName());
		temp.setPeriod(student.getPeriod());
		temp.setActive(student.getActive());

		repository.save(temp);
	}

}
