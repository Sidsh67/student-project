package com.student.dto;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.student.entity.TodoEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	
private String first_name;
	
	private String last_name;
	
	private int stud_id;
	
	private int roll_number;
	
	private String course;
	
	private String email;
	
	private long phone_number;
	
	private Date dob;
	
	private TodoEntity todo;

}
