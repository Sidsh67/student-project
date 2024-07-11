package com.todo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todo.repo.TodoRepo;

@Service
public class TodoServiceImpl {

	@Autowired
	private TodoRepo repo;
	
	public TodoEntity create(TodoEntity todo) {
		TodoEntity te = repo.save(todo);
		System.out.println("te"+te);
		return te;
	}
	
	public List<TodoEntity> getTodo() {
		List<TodoEntity> list= repo.findAll();
		return list;
	}
	
	public ResponseEntity<TodoEntity> getById(Integer id) {
//		TodoEntity opt =
//		System.out.println("todo====="+opt);
		return ResponseEntity.ok(repo.findByStdId(id));
	}
	
	public boolean update(TodoEntity todo) {
		TodoEntity opt =repo.findById(todo.getId()).get();
		System.out.println(opt+"+++++++++++++");
		if(opt !=null) {
			repo.save(todo);
			return true;
		}
		
		return false;
	}

	public boolean updateByPatch(TodoEntity todo) {
		TodoEntity opt =repo.findById(todo.getId()).get();
		System.out.println(opt+"+++++++++++++");
		if(opt !=null) {
			repo.save(todo);
			return true;
		}
		
		return false;
	}
}
