package com.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

//	@Query(value = "select first_name from student ORDER BY first_name")
//	List<StudentEntity> findByFirst_name(String first_name);

}