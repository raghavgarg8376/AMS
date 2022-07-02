package com.audit.service;

import java.util.List;


import com.audit.model.AuditBenchmark;
import com.audit.model.AuditResponse;
import com.audit.model.AuditQuestion;
import com.audit.model.AuditRequest;

public interface AuditResponseService {
	
	public AuditResponse getAuditResponse(List<AuditBenchmark> benchmarkList, String auditType,List<AuditQuestion> questionResponses);

	public AuditResponse saveAuditResponse(AuditResponse auditResponse, AuditRequest auditRequest); 
		
}
