package com.student.controller;

import static org.mockito.Matchers.startsWith;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentDto studentDto) {
	

		return studentService.saveCreateStudentData(studentDto);
	}
	
	@GetMapping
    public ResponseEntity<List<StudentEntity>> getStudent(){
    	return studentService.getStudent();
    }  
	
	@GetMapping("/{id}")
	public StudentEntity fetchById(@PathVariable Integer id) {
		return studentService.fetchById(id);
	}
	@PutMapping
	public boolean updateStudent(@RequestBody StudentDto entity) {
		boolean b =studentService.updateStudent(entity);
		System.out.println(entity+" entity");
		return b;
	}
	@DeleteMapping("/{id}")
	public boolean removeStudent(@PathVariable Integer id) {
	boolean b = studentService.removeStudent(id);
	return b;
	}

}
