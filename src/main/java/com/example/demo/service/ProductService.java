package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Product;
import com.example.demo.repository.repository;

@Service
public class ProductService {
	
	
	@Autowired
	private repository repo;
	
	public void addprod(Product product) {
		
		repo.save(product);
		
	}
	
	public List<Product> showprod() {
		
		return repo.findAll();
		
	}
	
	public Product getbyid(Long id) {
		return repo.getById(id);
	}

	
	
	
	
	
}
