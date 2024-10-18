package com.student.student_backend.mappers;

import com.student.student_backend.dtos.StudentRequest;
import com.student.student_backend.dtos.StudentResponse;
import com.student.student_backend.entities.Student;

public class StudentMapper {

  public static Student toEntity(StudentRequest request) {
    Student student = new Student();

    student.setActive(request.active());
    student.setName(request.name());
    student.setPeriod(request.period());

    return student;
  }

  public static StudentResponse toDTO(Student student) {
    StudentResponse response = new StudentResponse(student.getId(), student.getName(), student.getActive(), student.getPeriod());

    return response;
  }

}
