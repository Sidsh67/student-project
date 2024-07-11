package com.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {


private int id;
	
	private int stdId;
	
	private String fname;
	
	private String lname;
	
	private String address;
	
	private String description;

}
