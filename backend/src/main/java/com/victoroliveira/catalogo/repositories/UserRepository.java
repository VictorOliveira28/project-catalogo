package com.victoroliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victoroliveira.catalogo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
