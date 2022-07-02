package com.audit;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.audit.model.AuditBenchmark;
import com.audit.model.AuditDetail;
import com.audit.model.AuditQuestion;
import com.audit.model.AuditRequest;
import com.audit.model.AuditResponse;
import com.audit.model.AuditType;
import com.audit.model.AuthenticationResponse;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class AuditSeverityMicroserviceApplicationTests {	
	
	@Autowired
	AuditSeverityMicroserviceApplication auditSeverityApplication;
	
	@Test
	public void contextLoads(){
		assertNotNull(auditSeverityApplication);
	}

	@Test
	void main()
	{
		AuditSeverityMicroserviceApplication.main(new String[] {});
	}
	
	@Test
	void testAuditBenchmark()
	{
		EqualsVerifier.simple().forClass(AuditBenchmark.class).verify();
	}
	
	@Test
	void testAuditDetail()
	{
		EqualsVerifier.simple().forClass(AuditDetail.class).verify();
	}
	
	@Test
	void testAuditQuestion()
	{
		EqualsVerifier.simple().forClass(AuditQuestion.class).verify();
	}
	
	@Test
	void testAuditRequest()
	{
		EqualsVerifier.simple().forClass(AuditRequest.class).verify();
	}

	@Test
	void testAuditType()
	{
		EqualsVerifier.simple().forClass(AuditType.class).verify();
	}
	
	@Test
	void testAuthenticationResponse()
	{
		EqualsVerifier.simple().forClass(AuthenticationResponse.class).verify();
	}
	
	@Test
	void testSetterAuditBenchmark()
	{
		AuditBenchmark auditBenchmark=new AuditBenchmark();
		auditBenchmark.setAuditType("Internal");
		auditBenchmark.setBenchmarkId(5);
		auditBenchmark.setBenchmarkNoAnswers(2);
		assertThat(assertThat(auditBenchmark).isNotNull());
	}
	
	@Test
	void testSetterAuditDetail()
	{
		AuditDetail auditDetail = new AuditDetail();
		auditDetail.setAuditDate(new Date());
		auditDetail.setAuditType("Internal");
		auditDetail.setAuditQuestions(null);
		assertThat(assertThat(auditDetail).isNotNull());
	}
	
	@Test
	void testSetterAuditQuestion()
	{
		AuditQuestion auditQuestion = new AuditQuestion();
		auditQuestion.setAuditType("Internal");
		auditQuestion.setQuestion("Question Test");
		auditQuestion.setQuestionId(3);
		auditQuestion.setResponse("response");
		assertThat(assertThat(auditQuestion).isNotNull());
	}
	
	@Test
	void testSetterAuditRequest()
	{
		AuditRequest auditRequest=new AuditRequest();
		auditRequest.setAuditDetail(null);
		auditRequest.setManagerName("Name Test");
		auditRequest.setProjectName("project Test");
		assertThat(assertThat(auditRequest).isNotNull());
	}
	
	@Test
	void testSetterAuditResponse()
	{
		AuditResponse auditResponse=new AuditResponse();
		auditResponse.setAuditId(5);
		auditResponse.setManagerName("Name Test");
		auditResponse.setProjectName("project Test");
		auditResponse.setProjectExecutionStatus("Execution status test");
		auditResponse.setRemedialActionDuration("Action test");
		assertThat(assertThat(auditResponse).isNotNull());
	}
	
	@Test
	void testSetterAuthenticationResponse()
	{
		AuthenticationResponse authenticationResponse =new AuthenticationResponse();
		authenticationResponse.setName("name");
		authenticationResponse.setProjectName("project");
		authenticationResponse.setValid(false);
		assertThat(assertThat(authenticationResponse).isNotNull());
	}
}
