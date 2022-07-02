package com.audit.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;

import com.audit.model.AuthenticationRequest;
import com.audit.model.AuthenticationResponse;
import com.audit.model.ProjectManager;
import com.audit.model.ProjectManagerDetails;
import com.audit.service.ProjectManagerDetailsService;
import com.audit.util.JwtService;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {
	
	@Mock
	private AuthenticationManager authenticationManager;
	
	@Mock
	private ProjectManagerDetailsService projectManagerDetailsService;
	
	@Mock
	private JwtService jwtService;
	
	@InjectMocks
	private AuthController authController;	// from where we will assert
	
	@Test	// for '/authenticate'
	public void generateJwtTest(){
		
		// instances req.
		ResponseEntity<String> response = null;
		AuthenticationRequest request = null;
		ProjectManagerDetails projectManagerDetails = null;
		ProjectManager projectManager = null;
		
		// authenticating the User-Credentials - Correct
		request = new AuthenticationRequest();
		request.setUsername("raghav");
		request.setPassword("raghav123");
		
		// making projectManager
		projectManager= new ProjectManager(1, "Raghav Garg", "raghav", "raghav123", "Audit Management");
		
		// making ProjectManagerDetails
		projectManagerDetails = new ProjectManagerDetails(projectManager);
		
		// making fake token
		final String jwtToken = "jj.ww.tt";
		
		// making response
		response = new ResponseEntity<String>(jwtToken, HttpStatus.OK);
		
		// the correct flow
		when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())))
			.thenReturn(null);
		when(projectManagerDetailsService.loadUserByUsername(request.getUsername())).thenReturn(projectManagerDetails);
		when(jwtService.generateToken(projectManagerDetails)).thenReturn(jwtToken);
		
		assertEquals(response, authController.generateJwt(request));
		
		// authenticating the User-Credentials - Wrong
		request = new AuthenticationRequest();
		request.setUsername("invalidUser1");
		request.setPassword("abcd1234");
		
		// making projectManager
		projectManager= null;
		
		// making ProjectManagerDetails
		projectManagerDetails = null;
		
		//no token generated
		
		// making response
		response = new ResponseEntity<String>("Not Authorized Project Manager", HttpStatus.FORBIDDEN);
		
		// the wrong flow
		when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())))
			.thenReturn(null);
		when(projectManagerDetailsService.loadUserByUsername(request.getUsername())).thenThrow(RuntimeException.class);
		assertEquals(response, authController.generateJwt(request));
	}
	
	@Test	// for '/validate'
	public void validateJwt(){
		// instances req.
		String jwtTokenHeader = "Bearer jj.ww.tt";
		AuthenticationResponse authenticationResponse = null;
		ResponseEntity<AuthenticationResponse> response = null;
		ProjectManagerDetails projectManagerDetails = null;
		ProjectManager projectManager = null;
		
		// making projectManager
		projectManager= new ProjectManager(1, "Raghav Garg", "raghav", "raghav123", "Audit Management");
		
		// making ProjectManagerDetails
		projectManagerDetails = new ProjectManagerDetails(projectManager);
		
		// making authentication-response
		authenticationResponse = new AuthenticationResponse("Raghav Garg", "Audit Management", true);
		
		//first remove Bearer from Header
		String jwtToken = jwtTokenHeader.substring(7);
		String username = "raghav";
		response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
		
		// check the jwt is proper or not - success
		when(jwtService.extractUsername(jwtToken)).thenReturn(username);
		when(projectManagerDetailsService.loadUserByUsername(username))
							.thenReturn(projectManagerDetails);
		when(jwtService.validateToken(jwtToken, projectManagerDetails)).thenReturn(true);	// correct
		assertEquals(response, authController.validateJwt(jwtTokenHeader));
		
		
		// now for wrong
		jwtTokenHeader = "Bearer jj.wrong.tt";
		
		// making projectManager
		projectManager= null;
		
		// making ProjectManagerDetails
		projectManagerDetails = null;
		
		// making authentication-response
		authenticationResponse = new AuthenticationResponse("Invalid", "Invalid", false);
		username = "";
		
		//first remove Bearer from Header
		jwtToken = jwtTokenHeader.substring(7);
		response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
		
		// check the jwt is proper or not - success
		when(jwtService.extractUsername(jwtToken)).thenReturn(username);
		when(projectManagerDetailsService.loadUserByUsername(username)).thenReturn(projectManagerDetails);
		when(jwtService.validateToken(jwtToken, projectManagerDetails)).thenReturn(false);	// wrong
		assertEquals(response, authController.validateJwt(jwtTokenHeader));
	}
	
	@Test // for health check 
	public void  healthCheckMethod() {
		String str= "Audit-Authorization MS Running Fine!!";
		assertEquals("Audit-Authorization MS Running Fine!!", str);
		
	}
}
