package com.acmeFresh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmeFresh.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	

}
