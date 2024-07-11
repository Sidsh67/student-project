package com.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.api.TodoEntity;

public interface TodoRepo extends JpaRepository<TodoEntity, Integer>{
	
	TodoEntity findByStdId(int stdId);
}
