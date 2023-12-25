package com.jsp.bootdemowithdatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.bootdemowithdatabase.dto.Student;

public interface StudentRepository  extends JpaRepository<Student,Integer>  {
	
	

	List<Student> findByName(String name);

	List<Student> findByAge(int age);
	List<Student> findByageLessThan(int age);
	
	List<Student> findByageGreaterThan(int age);

	

	

}
