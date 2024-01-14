package com.victoroliveira.catalogo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.victoroliveira.catalogo.dto.ProductDTO;
import com.victoroliveira.catalogo.tests.TokenUtil;
import com.victoroliveira.catalogo.tests.factory.Factory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductControllerIT {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	private ProductDTO productDTO;	
	private Long existingId;
	private Long nonExistingId;
	private Long countTotalProducts;	
	
	private String username, password, bearerToken;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalProducts = 26L;
		
		username = "maria@gmail.com";
		password = "123456";
		
		bearerToken = tokenUtil.obtainAccessToken(mockMvc, username, password);
		
		productDTO = Factory.createProductDTO();
	}
	
	@Test
	public void findAllShouldReturnSortedPageWhenSortByName() throws Exception{
		
		mockMvc.perform(get("/products?page=0&size=12&sort=name,asc")				
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.totalElements").value(countTotalProducts))
				.andExpect(jsonPath("$.content").exists())
				.andExpect(jsonPath("$.content[0].name").value("Macbook Pro"))
				.andExpect(jsonPath("$.content[1].name").value("O Senhor dos Anéis"))
				.andExpect(jsonPath("$.content[2].name").value("PC Gamer"));
	}
	
	@Test
	public void updateShouldReturnProductDTOWhenExistingId() throws Exception {
		
		String jsonBody = objectMapper.writeValueAsString(productDTO);
		
		String expectedName = productDTO.getName();
		String expectedDescription = productDTO.getDescription();
		
		mockMvc.perform(put("/products/{id}", existingId)
				.header("Authorization", "Bearer " + bearerToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(existingId))
				.andExpect(jsonPath("$.name").value(expectedName))
				.andExpect(jsonPath("$.description").value(expectedDescription));		
	}
	
	@Test
	public void updateShouldReturnNotFoundWhenNonExistingId() throws Exception   {
		
		String jsonBody = objectMapper.writeValueAsString(productDTO);
		
		mockMvc.perform(put("/products/{id}", nonExistingId)
				.header("Authorization", "Bearer " + bearerToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
}
