package com.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.api.TodoEntity;
import com.todo.api.TodoServiceImpl;

@RestController
@RequestMapping("todos")
public class TodoController {

	@Autowired
	private TodoServiceImpl service;
	@PostMapping
	public ResponseEntity<TodoEntity> save(@RequestBody TodoEntity todo){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(todo));
	}
	@GetMapping
	public ResponseEntity<List<TodoEntity>> getData(){
		
		return ResponseEntity.status(HttpStatus.OK).body(service.getTodo());
	}
	
	@GetMapping("student/{id}")
	public ResponseEntity<TodoEntity> getDataById(@PathVariable Integer id){
		
		return service.getById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Boolean> update(@PathVariable Integer id, @RequestBody TodoEntity todo){
		todo.setId(id);
		Boolean te= service.update(todo);
		if(te==true) {
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}else {
		return ResponseEntity.status(HttpStatus.OK).body(te);
		}
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Boolean> updateByPatch(@PathVariable Integer id, @RequestBody TodoEntity todo){
		todo.setId(id);
		Boolean te= service.updateByPatch(todo);
		if(te==true) {
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}else {
		return ResponseEntity.status(HttpStatus.OK).body(te);
		}
	}
}
