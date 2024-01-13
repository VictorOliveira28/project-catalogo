package com.victoroliveira.catalogo.projections;

public interface UserDetailsProjection {
	
	String getUsername();
	
	String getPassword();

	Long getRoleId();

	String getAuthority();	

}
