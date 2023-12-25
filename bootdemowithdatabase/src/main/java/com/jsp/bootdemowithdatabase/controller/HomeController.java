package com.jsp.bootdemowithdatabase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.jsp.bootdemowithdatabase.dto.Student;
import com.jsp.bootdemowithdatabase.exception.StudentNotFoundException;
import com.jsp.bootdemowithdatabase.helper.ResponseStructure;
import com.jsp.bootdemowithdatabase.repository.StudentRepository;

@RestController
public class HomeController {
	
	
	@Autowired
	StudentRepository repository;
	
	
    
    
	@PostMapping("/bye")
	public String m1() {
		return "hello world";
	}

	
		@GetMapping("/bye")
		public String m2() {
			return "Welcome";
		}
		
		@PostMapping("/save")
		public String saveStudent(@RequestBody Student student) {
			
			repository.save(student);
			return "datasaved";
			
		}
		@GetMapping("/get")
		public Student fetchStudent(@RequestBody Student student) {
			repository.findById(2);
			return student;
			
		}
		
		@GetMapping("/fetchstudentdetails")
		public  ResponseStructure<Student> fetchStudent (@RequestParam ("id")int id) {
			Optional <Student> option=repository.findById(id);
			
			if(option.isPresent()) {
			Student student =option.get();
			ResponseStructure<Student> response=new ResponseStructure<Student>();
			response.setStatuscode(HttpStatus.FOUND.value());
			response.setMessage("data found successfully");
			response.setData(student);
			return response;
			}
			else {
				throw new StudentNotFoundException("student not found");
			}
			
		}
		
		
		
		@GetMapping ("/fetchstudentbyname")
		public List<Student> fetchStudentByName(@RequestParam("name")String name)
		{
			return repository.findByName(name);
		}
		
		
		@GetMapping ("/fetchstudentbyage")
		public List<Student>fetchStudentByAge(@RequestParam("age")int age)
		{
			
			return repository.findByAge(age);
		}
		
		
		@GetMapping("/fetchstudentbyagelessthan")
		public List<Student> fetchByageLessThan(@RequestParam("age")int age)
		{
			return repository.findByageLessThan(age);
		}
		
		@GetMapping("/fetchstudentbyagegreaterthan")
		
		public List<Student> fetchByageGreaterThan(@RequestParam("age")int age)
		{
			return repository.findByageGreaterThan(age);
		}
}
		
	
