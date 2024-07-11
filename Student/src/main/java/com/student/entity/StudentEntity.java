package com.student.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
public class StudentEntity {
	
	
	private String first_name;
	@NonNull
	private String last_name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stud_id;
	@Column(unique = true)
	private int roll_number;
	private String course;
	@Column(unique = true)
	private String email;
	@Column(length = 10)
	private long phone_number;
	
	private Date dob;

	@Transient
	private TodoEntity todo;

	public StudentEntity(String first_name, @NonNull String last_name, int roll_number, String course, String email,
			long phone_number, Date dob, TodoEntity todo) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.roll_number = roll_number;
		this.course = course;
		this.email = email;
		this.phone_number = phone_number;
		this.dob = dob;
		this.todo = todo;
	}
	
	
	

	
	
	
}
