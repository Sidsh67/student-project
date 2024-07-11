package com.student.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.student.entity.TodoEntity;



@FeignClient(name = "STUDENT-TODO",url = "localhost:8082",path="todos")
public interface TodoService {

	@PostMapping
	public ResponseEntity<TodoEntity> save(@RequestBody TodoEntity todo);
	
	@GetMapping("student/{id}")
	public ResponseEntity<TodoEntity> getDataById(@PathVariable Integer id);
	
}
