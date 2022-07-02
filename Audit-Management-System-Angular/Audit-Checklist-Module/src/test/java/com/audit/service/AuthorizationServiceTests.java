package com.audit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.audit.feign.AuthorizationFeign;
import com.audit.model.AuditType;
import com.audit.model.AuthenticationResponse;
import com.audit.model.Question;

import nl.jqno.equalsverifier.EqualsVerifier;




@SpringBootTest
class AuthorizationServiceTests {
	
	@Mock
	AuthorizationFeign authClient;
	
	@InjectMocks
	AuthorizationServiceImpl authorizationServiceImpl;
	
	@Test
	public void contextLoads() throws Exception {
		assertNotNull(authorizationServiceImpl);
	}
	@Test
	public void testValidateJwt() {
		AuthenticationResponse authenticationResponse = new AuthenticationResponse("null","null",true);
		ResponseEntity<AuthenticationResponse> response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
		when(authClient.validate("jwt")).thenReturn(response);
		assertTrue(authorizationServiceImpl.validateJwt("jwt"));
	}
	@Test
	void testNoArgsAuditType()
	{
		assertThat(new AuditType()).isNotNull();
	}
	@Test
	void testAllArgsAuditType()
	{
		AuditType auditType = new AuditType("Internal");
		assertThat(assertThat(auditType).isNotNull());
	}
	@Test
	void testSetterAuditType()
	{
		AuditType a= new AuditType();
		a.setAuditType("Internal");
		assertThat(assertThat(a).isNotNull());
	}
	@Test
	void testAuditType() {
		EqualsVerifier.simple().forClass(AuditType.class).verify();
	}
	
	@Test
	void testNoArgsAuthenticationResponse()
	{
		assertThat(new AuthenticationResponse()).isNotNull();
	}
	void testAllArgsAuthenticationResponse()
	{
		AuthenticationResponse authenticationResponse = new AuthenticationResponse("raghav","raghav1",true);
		assertThat(assertThat(authenticationResponse).isNotNull());
	}
	@Test
	void testSetterAuthenticationResponse()
	{
		AuthenticationResponse a= new AuthenticationResponse();
		a.setName("vidya");
		a.setProjectName("sagar");
		a.setValid(true);
		assertThat(assertThat(a).isNotNull());
	}
	@Test
	void testAuthenticationResponse() {
		EqualsVerifier.simple().forClass(AuthenticationResponse.class).verify();
	}
	@Test
	void testNoArgsQuestion()
	{
		assertThat(new Question()).isNotNull();
	}
	@Test
	void testAllArgsQuestion()
	{
		Question question = new Question(1,"raghav","raghav1","yes");
		assertThat(assertThat(question).isNotNull());
	}
	@Test
	void testSetterQuestion()
	{
		Question q= new Question();
		q.setQuestionId(1);
		q.setQuestion("hello");
		q.setAuditType("Internal");
		q.setResponse("yes");
		assertThat(assertThat(q).isNotNull());
	}
	/*@Test
	void testQuestion() {
		EqualsVerifier.simple().forClass(Question.class).verify();
	}*/
}
