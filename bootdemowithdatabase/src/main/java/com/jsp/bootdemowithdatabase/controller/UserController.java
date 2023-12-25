package com.jsp.bootdemowithdatabase.controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bootdemowithdatabase.dto.User;
import com.jsp.bootdemowithdatabase.exception.UserNotFoundException;
import com.jsp.bootdemowithdatabase.helper.Login;
import com.jsp.bootdemowithdatabase.helper.ResponseStructure;
import com.jsp.bootdemowithdatabase.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	
	@PostMapping("/saveuser")
	public ResponseStructure<User> saveuserdetails(@RequestBody User user){
		
		repository.save(user);
		ResponseStructure<User> response=new ResponseStructure<User>();
		response.setStatuscode(HttpStatus.CREATED.value());
		response.setMessage("user data saved successfully");
		response.setData(user);
		return response;
	}
	
	@GetMapping("/loginvalidation")
	
	public ResponseStructure<User> loginUser(@RequestBody Login login){
		User user=repository.findByEmailAndPassword(login.getEmail(), login.getPassword());
		
		if(user!=null) {
			ResponseStructure<User> response=new ResponseStructure<User>();
			response.setStatuscode(HttpStatus.FOUND.value());
			response.setMessage("data found and logged in");
			response.setData(user);
			return response;
		}
		else {
			throw new  UserNotFoundException("user not found");
		}
		
	}
	
	@DeleteMapping("/deleteuser")
	public ResponseStructure<String> deleteUser(@RequestParam("id")int id){
		repository.deleteById(id);
		ResponseStructure<String> response=new ResponseStructure<String>();
		response.setStatuscode(HttpStatus.OK.value());
		response.setData("user data deleted");
		return response;
	}
	
	@PutMapping("/updateuser")
	public ResponseStructure<User> updateUser(@RequestBody User user){
		repository.save(user);
		ResponseStructure<User> response=new ResponseStructure<User>();
		response.setStatuscode(HttpStatus.ACCEPTED.value());
		response.setMessage("data updated");
		response.setData(user);
		return response;
		
	}
	
	@PatchMapping("/patchreq")
	
	public ResponseStructure<User> patchUser(@RequestParam ("name")String name,@RequestParam("id") int id){
		Optional<User> option=repository.findById(id);
		User user=option.get();
		user.setName(name);
		
		repository.save(user);
		
		ResponseStructure<User> response=new ResponseStructure<User>();
		response.setStatuscode(HttpStatus.ACCEPTED.value());
		response.setMessage("data updated to");
		response.setData(user);
		return response;
		
	}
}

