package com.victoroliveira.catalogo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victoroliveira.catalogo.entities.Category;
import com.victoroliveira.catalogo.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){		
		return repository.findAll();
	}

}
