package com.victoroliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victoroliveira.catalogo.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
