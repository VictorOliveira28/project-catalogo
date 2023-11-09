package com.victoroliveira.catalogo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victoroliveira.catalogo.dto.CategoryDTO;
import com.victoroliveira.catalogo.entities.Category;
import com.victoroliveira.catalogo.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){		
		List<Category> list = repository.findAll();
		List<CategoryDTO> dto = list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		
		return dto;
	}

}