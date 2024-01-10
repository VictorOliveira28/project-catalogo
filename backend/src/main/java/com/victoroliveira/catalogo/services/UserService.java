package com.victoroliveira.catalogo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.victoroliveira.catalogo.dto.RoleDTO;
import com.victoroliveira.catalogo.dto.UserDTO;
import com.victoroliveira.catalogo.dto.UserInsertDTO;
import com.victoroliveira.catalogo.dto.UserUpdateDTO;
import com.victoroliveira.catalogo.entities.Role;
import com.victoroliveira.catalogo.entities.User;
import com.victoroliveira.catalogo.repositories.RoleRepository;
import com.victoroliveira.catalogo.repositories.UserRepository;
import com.victoroliveira.catalogo.services.exceptions.DatabaseException;
import com.victoroliveira.catalogo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
		
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable){		
		Page<User> list = repository.findAll(pageable);		
		return list.map(x -> new UserDTO(x));
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		User entity =  repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity = repository.save(entity);
		return new UserDTO(entity);
	}	

	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
		User entity = repository.getReferenceById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
		} 
		catch(EntityNotFoundException e) {
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
		}
	    	catch (DataIntegrityViolationException e) {
	        	throw new DatabaseException("Referential Integrity Failure");
	   	}
	}
	
	private void copyDtoToEntity(UserDTO dto, User entity) {

		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());		
		
		entity.getRoles().clear();
		for(RoleDTO roleDTO : dto.getRoles()) {
			Role role = roleRepository.getReferenceById(roleDTO.getId());
			entity.getRoles().add(role);
		}
	}
}