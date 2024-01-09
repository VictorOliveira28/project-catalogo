package com.victoroliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victoroliveira.catalogo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
