package com.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;
import com.student.entity.TodoEntity;
import com.student.external.service.TodoService;
import com.student.repo.StudentRepo;
import com.student.service.StudentService;

@Component
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private TodoService service;
	@Autowired
	private RestTemplate template;
	
	public ResponseEntity<StudentEntity> saveCreateStudentData(StudentDto studentDto) {
		
		StudentEntity student=new StudentEntity(studentDto.getFirst_name(), studentDto.getLast_name(), studentDto.getRoll_number(), studentDto.getCourse(), studentDto.getEmail(), studentDto.getPhone_number(), studentDto.getDob(), studentDto.getTodo());
		
		TodoEntity td=student.getTodo();
		
		
		System.out.println("to do testing "+student);
		
		
		StudentEntity st= studentRepo.save(student);
		td.setStdId(student.getStud_id());
		TodoEntity todo=service.save(td).getBody();
		todo.setId(td.getId());
		System.out.println(student.getStud_id()+" student");
		
	
		return ResponseEntity.status(HttpStatus.CREATED).body(st);
	}
	
	public ResponseEntity<List<StudentEntity>> getStudent(){
		
		List<StudentEntity> list=studentRepo.findAll();
		List<StudentEntity> finalList=new ArrayList<>();
		for(StudentEntity student: list) {
			TodoEntity todo = service.getDataById(student.getStud_id()).getBody();
			student.setTodo(todo);
			finalList.add(student);
		}
		return ResponseEntity.status(HttpStatus.OK).body(finalList);
		
	}
	
	
	public StudentEntity fetchById(Integer id) {
		
		return studentRepo.findById(id).get();
	}

	public boolean updateStudent(StudentDto dto) {
		StudentEntity studentEntity=studentRepo.findById(dto.getStud_id()).get();
//		System.out.println(dto+" service entity");
		try {
			studentEntity.setCourse(dto.getCourse());
			studentEntity.setEmail(dto.getEmail());
			studentEntity.setFirst_name(dto.getFirst_name());
			studentEntity.setLast_name(dto.getLast_name());
			studentEntity.setDob(dto.getDob());
			studentEntity.setPhone_number(dto.getPhone_number());
			studentEntity.setRoll_number(dto.getRoll_number());
//			 System.out.println(studentEntity+" old service entity");
			
			StudentEntity entity= studentRepo.save(studentEntity);
			 System.out.println(entity+" new service entity");
			return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean removeStudent(Integer id) {
		studentRepo.deleteById(id);
		return true;
	}

	
	

}
