package com.victoroliveira.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victoroliveira.catalogo.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByAuthority(String authority);
}
