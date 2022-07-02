package com.audit.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthenticationRequestTest {
	
	
	@Test
	public void testPasswordSetter() {
		String pass= "raghav123";
		AuthenticationRequest ar = new AuthenticationRequest();
		ar.setPassword(pass);
		assertEquals(ar.getPassword(),pass);
	}
	
	@Test
	public void testUsernameGetter() {
		AuthenticationRequest ar = new AuthenticationRequest();
		String user ="raghav";
		ar.setUsername(user);
		String username= ar.getUsername();
		assertEquals(user,username);
	}
	
	

}
