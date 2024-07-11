package com.todo.api;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int stdId;
	
	private String fname;
	
	private String lname;
	
	private String address;
	
	private String description;

	
	
	public TodoEntity(String fname, String description) {
		super();
		this.fname = fname;
		this.description = description;
	}
	
	
}
