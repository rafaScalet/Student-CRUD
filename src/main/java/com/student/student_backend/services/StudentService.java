package com.student.student_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student_backend.dtos.StudentRequest;
import com.student.student_backend.dtos.StudentResponse;
import com.student.student_backend.entities.Student;
import com.student.student_backend.mappers.StudentMapper;
import com.student.student_backend.repositories.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<StudentResponse> getStudents () {
		return repository.findAll().stream().map(item -> StudentMapper.toDTO(item)).toList();
	}

	public StudentResponse getStudentById (int id) {
		return StudentMapper.toDTO(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found")));
	}

	public StudentResponse saveStudent (StudentRequest dtoStudentRequest) {
		return StudentMapper.toDTO(repository.save(StudentMapper.toEntity(dtoStudentRequest)));
	}

	public void deleteStudent (int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return;
		}

		throw new EntityNotFoundException("Student not found");
	}

	public void updateStudent (int id, StudentRequest dtoStudentRequest) {
		Student temp = repository.getReferenceById(id);

		temp.setName(dtoStudentRequest.name());
		temp.setPeriod(dtoStudentRequest.period());
		temp.setActive(dtoStudentRequest.active());

		repository.save(temp);
	}

}
