package com.victoroliveira.catalogo.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.victoroliveira.catalogo.dto.CategoryDTO;
import com.victoroliveira.catalogo.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;	
	
	@GetMapping
	public ResponseEntity<Page<CategoryDTO>> findAll(Pageable pageable) {		
		Page<CategoryDTO> list = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
		CategoryDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', ROLE_OPERATOR)")
	@PostMapping
	public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(dto.getId()).toUri();		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', ROLE_OPERATOR)")
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto){
		dto = service.update(id, dto);			
		return ResponseEntity.ok().body(dto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', ROLE_OPERATOR)")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);			
		return ResponseEntity.noContent().build();
	}

}