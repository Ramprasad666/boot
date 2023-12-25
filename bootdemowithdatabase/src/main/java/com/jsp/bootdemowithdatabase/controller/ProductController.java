package com.jsp.bootdemowithdatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bootdemowithdatabase.dto.Product;
import com.jsp.bootdemowithdatabase.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productrepository;
	
	@PostMapping("/saveproducts")
	public String SaveProduct (@RequestBody Product product) {
		
	productrepository.save(product);
	return "product details are saved";
}
}
