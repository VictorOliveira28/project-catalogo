package com.victoroliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victoroliveira.catalogo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
