package com.student.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;
import com.student.repo.StudentRepo;
import com.student.service.impl.StudentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StudentServiceTest {

	@Mock
	private StudentRepo repoTest;
	@InjectMocks
	private StudentServiceImpl serviceTest;
	
	StudentDto dto;
	
	StudentEntity se;
	
//	@BeforeEach
//	public void setup() {
//		 dto=new StudentDto("Arsh", "Sharma", 1, 056, "Java", "arsh.sharma_24@gmail.com", 87569125, null);
//		 se=new StudentEntity(dto.getFirst_name(), dto.getLast_name(), dto.getRoll_number(), 
//				dto.getCourse(), dto.getEmail(), dto.getPhone_number(), dto.getDob());
//	}
//	@Test
//	public void saveStudent() {
//		when(repoTest.save(se)).thenReturn(se);
//		boolean result= serviceTest.saveCreateStudentData(dto);
//		assertEquals(true, result);
////		assertThat(null);
//	}
//	@Test
//	public void getStudent() {
//		when(repoTest.findAll()).thenReturn(List.of());
//		List<StudentEntity> studentList=serviceTest.getStudent();
//		System.out.println(studentList+" student");
//		System.out.println(List.of(se)+" list");
//		assertEquals(studentList, studentList);
//	}
	
//	public void fetchById() {
//		when(repoTest.findById(1)).thenReturn(se.getStud_id());
//	}
	
	
}
