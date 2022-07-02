package com.audit.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.audit.model.AuditBenchmark;
import com.audit.model.AuthenticationResponse;

import com.audit.repository.AuditBenchmarkRepo;
import com.audit.service.AuditBenchmarkServiceImpl;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class AuditBenchmarkServiceTests {
	
	@Mock
	AuditBenchmarkRepo auditBenchmarkRepo;
	
	@InjectMocks
	AuditBenchmarkServiceImpl auditBenchmarkServiceImpl;
	
	@Test
	public void contextLoads() throws Exception {
		assertNotNull(auditBenchmarkServiceImpl);
	}
	
	@Test
	public void testGetAuditBenchmarkList() {
		List<AuditBenchmark> auditBenchmarkList = new ArrayList<>();
		auditBenchmarkList.add(new AuditBenchmark(1,"Internal",3));
		auditBenchmarkList.add(new AuditBenchmark(2,"SOX",1));
		
		when(auditBenchmarkRepo.findAll()).thenReturn(auditBenchmarkList);
		
		assertEquals(auditBenchmarkList, auditBenchmarkServiceImpl.getAuditBenchmarkList());
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
		a.setName("raghav");
		a.setProjectName("audit");
		a.setValid(true);
		assertThat(assertThat(a).isNotNull());
	}
	@Test
	void testNoArgsAuditBenchmark()
	{
		assertThat(new AuditBenchmark()).isNotNull();
	}
	@Test
	void testAllArgsAuditBenchmark()
	{
		AuditBenchmark auditBenchmark = new AuditBenchmark(1,"raghav1",1);
		assertThat(assertThat(auditBenchmark).isNotNull());
	}
	@Test
	void testSetterAuditBenchmark()
	{
		AuditBenchmark a= new AuditBenchmark();
		a.setBenchmarkId(1);
		a.setAuditType("Internal");
		a.setBenchmarkNoAnswers(1);
		assertThat(assertThat(a).isNotNull());
	}
	/*@Test
	void AuditBenchmark() {
		EqualsVerifier.simple().forClass(AuditBenchmark.class).verify();
	}*/
	
	
}
