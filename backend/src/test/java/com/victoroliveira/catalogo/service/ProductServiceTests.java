package com.victoroliveira.catalogo.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.victoroliveira.catalogo.dto.ProductDTO;
import com.victoroliveira.catalogo.entities.Category;
import com.victoroliveira.catalogo.entities.Product;
import com.victoroliveira.catalogo.repositories.CategoryRepository;
import com.victoroliveira.catalogo.repositories.ProductRepository;
import com.victoroliveira.catalogo.services.ProductService;
import com.victoroliveira.catalogo.services.exceptions.DatabaseException;
import com.victoroliveira.catalogo.services.exceptions.ResourceNotFoundException;
import com.victoroliveira.catalogo.tests.factory.Factory;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

	@InjectMocks
	private ProductService service;

	@Mock
	private ProductRepository repository;
	
	@Mock
	private CategoryRepository catRepository;

	private long existingId;
	private long nonExistingId;
	private long dependentId;
	private PageImpl<Product> page;
	private Product product;
	private Category category;
	private ProductDTO dto;
	
	

	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 2L;
		dependentId = 3L;
		product = Factory.createProduct();		
		page = new PageImpl<>(List.of(product));
		category = Factory.createCategory();
		dto = Factory.createProductDTO();
		
		
		
		Mockito.when(repository.findAll((Pageable)ArgumentMatchers.any())).thenReturn(page);
		
		Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(product);	
		
		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(product));		
		Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
		
		Mockito.when(repository.getReferenceById(existingId)).thenReturn(product);
		Mockito.when(repository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);
		
		Mockito.when(catRepository.getReferenceById(existingId)).thenReturn(category);
		Mockito.when(catRepository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);

		Mockito.doThrow(DatabaseException.class).when(repository).deleteById(dependentId);
		
		Mockito.when(repository.existsById(existingId)).thenReturn(true);
		Mockito.when(repository.existsById(nonExistingId)).thenReturn(false);
		Mockito.when(repository.existsById(dependentId)).thenReturn(true);		
	}
	
	@Test
	public void updateShouldThrowResourceNotFoundExceptionWhenNonExistingId() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.update(nonExistingId, dto);
			
		});			
	}
	
	@Test
	public void updateShouldReturnProductDTOWhenExistingId() {
				
		ProductDTO result = service.update(existingId, dto);
		Assertions.assertNotNull(result);
		
		Mockito.verify(repository, Mockito.times(1)).save(product);
	}
	
	@Test
	public void findByIdShouldThrowResourceNotFoundExceptionWhenNonExistingId() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findById(nonExistingId);
		});	
		Mockito.verify(repository, Mockito.times(1)).findById(nonExistingId);
	}
	
	@Test
	public void findByIdShouldReturnProductDTOWhenExistingId() {
		
		ProductDTO dto = service.findById(existingId);		
		Assertions.assertNotNull(dto);
		Mockito.verify(repository, Mockito.times(1)).findById(existingId);
	}
	
	@Test
	public void findAllPagedShouldReturnPage() {
		Pageable pageable = PageRequest.of(0, 10);
		
		Page<ProductDTO> result = service.findAllPaged(pageable);
		
		Assertions.assertNotNull(result);
		Mockito.verify(repository, Mockito.times(1)).findAll(pageable);
	}

	@Test
	public void deleteShouldDoNothingWhenIdExists() {
		
		Assertions.assertDoesNotThrow(() -> {
			service.delete(existingId);
		});
		
		Mockito.verify(repository, Mockito.times(1)).deleteById(existingId);
	}
	
	@Test
	public void deleteShouldThrowResourceNotFoundExceptionWhenIdNonExists() {
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.delete(nonExistingId);
		});		
	
	}
	
	@Test
	public void  WhenDependentId() {
		Assertions.assertThrows(DatabaseException.class, () -> {
			service.delete(dependentId);
		});	
	}
}