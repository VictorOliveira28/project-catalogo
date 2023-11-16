package com.victoroliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victoroliveira.catalogo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
