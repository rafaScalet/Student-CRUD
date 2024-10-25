package com.student.student_backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StudentRequest(
	@NotBlank(message = "Name can't be blank")
	@Size(min = 2, message = "Name should have more then 2 characters")
	String name,

	@NotNull(message = "active can't be blank")
	Boolean active,

	@NotBlank(message = "period can't be blank")
	@Size(min = 3, message = "Period should have more then 2 characters")
	String period
) { }