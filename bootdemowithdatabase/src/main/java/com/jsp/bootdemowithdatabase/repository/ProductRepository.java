package com.jsp.bootdemowithdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.bootdemowithdatabase.dto.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
