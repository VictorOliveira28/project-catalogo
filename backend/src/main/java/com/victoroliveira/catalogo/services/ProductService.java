package com.victoroliveira.catalogo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.victoroliveira.catalogo.dto.CategoryDTO;
import com.victoroliveira.catalogo.dto.ProductDTO;
import com.victoroliveira.catalogo.entities.Category;
import com.victoroliveira.catalogo.entities.Product;
import com.victoroliveira.catalogo.projections.ProductProjection;
import com.victoroliveira.catalogo.repositories.CategoryRepository;
import com.victoroliveira.catalogo.repositories.ProductRepository;
import com.victoroliveira.catalogo.services.exceptions.DatabaseException;
import com.victoroliveira.catalogo.services.exceptions.ResourceNotFoundException;
import com.victoroliveira.catalogo.util.Utils;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(Pageable pageable) {
		Page<Product> list = repository.findAll(pageable);
		return list.map(x -> new ProductDTO(x));
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product category = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ProductDTO(category, category.getCategories());
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		try {
			Product entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ProductDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Referential Integrity Failure");
		}
	}

	private void copyDtoToEntity(ProductDTO dto, Product entity) {

		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setDate(dto.getDate());
		entity.setImgUrl(dto.getImgUrl());
		entity.setPrice(dto.getPrice());

		entity.getCategories().clear();
		for (CategoryDTO catDTO : dto.getCategories()) {
			Category category = categoryRepository.getReferenceById(catDTO.getId());
			entity.getCategories().add(category);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(String name, String categoryId, Pageable pageable) {

		List<Long> categoryIds = Arrays.asList();

		if (!"0".equals(categoryId)) {
			categoryIds = Arrays.asList(categoryId.split(",")).stream().map(x -> Long.parseLong(x)).toList();
		}

		Page<ProductProjection> page = repository.searchProducts(categoryIds, name.trim(), pageable);
		List<Long> productIds = page.map(x -> x.getId()).toList();

		List<Product> entities = repository.searchProductsWithCategories(productIds);
		entities = (List<Product>) Utils.replace(page.getContent(), entities);
		
		List<ProductDTO> dtos = entities.stream().map(x -> new ProductDTO(x, x.getCategories())).toList();
		
		Page<ProductDTO> pageDTO = new PageImpl<>(dtos, page.getPageable(), page.getTotalElements());
		
		return pageDTO;		

	}
}