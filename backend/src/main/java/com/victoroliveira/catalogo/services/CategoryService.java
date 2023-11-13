package com.victoroliveira.catalogo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victoroliveira.catalogo.dto.CategoryDTO;
import com.victoroliveira.catalogo.entities.Category;
import com.victoroliveira.catalogo.repositories.CategoryRepository;
import com.victoroliveira.catalogo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){		
		List<Category> list = repository.findAll();
		List<CategoryDTO> dto = list.stream().map(x -> new CategoryDTO(x))
				.collect(Collectors.toList());
		
		return dto;
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Category category =  repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new CategoryDTO(category);
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
		try {
		Category entity = repository.getReferenceById(id);
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
		} 
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

}