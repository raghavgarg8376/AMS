package com.audit.service;


public interface AuthorizationService {
	
	public boolean validateJwt(String jwt);
}
