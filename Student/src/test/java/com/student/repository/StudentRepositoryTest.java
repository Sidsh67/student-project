package com.student.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;
import com.student.repo.StudentRepo;
@DataJpaTest
public class StudentRepositoryTest {
	@Autowired
	private StudentRepo repo;
	
	private StudentEntity studentEntity;
//	@BeforeEach
//	public void setup() {
//		StudentDto dto=new StudentDto("Arsh", "Sharma", 1, 056, "Java", "arsh.sharma_24@gmail.com", 87569125, null);
//		studentEntity=new StudentEntity(dto.getFirst_name(), dto.getLast_name(), dto.getRoll_number(), 
//				dto.getCourse(), dto.getEmail(), dto.getPhone_number(), dto.getDob());
//		
//		repo.save(studentEntity);
//	}
//	@AfterEach
//	public void tearDown() {
//		studentEntity=null;
//		repo.deleteAll();
//	}
//	@Test
//	public void testFindByStudentName() {
//		Optional<StudentEntity> studentlist=repo.findById(1);
//		
//		assertThat(studentlist.get().getRoll_number()
//				).isEqualTo(studentEntity.getStud_id());
//	}
	@Test
	void findById() {
		StudentDto dto=new StudentDto("Arsh", "Sharma", 1, 056, "Java", "arsh.sharma_24@gmail.com", 87569125, null,null);
		studentEntity=new StudentEntity(dto.getFirst_name(), dto.getLast_name(), dto.getRoll_number(), 
				dto.getCourse(), dto.getEmail(), dto.getPhone_number(), dto.getDob(),dto.getTodo());
		repo.save(studentEntity);
		StudentEntity se=repo.findById(studentEntity.getStud_id()).get();
		assertEquals(studentEntity.getStud_id(), se.getStud_id());
	
		
	}
}
