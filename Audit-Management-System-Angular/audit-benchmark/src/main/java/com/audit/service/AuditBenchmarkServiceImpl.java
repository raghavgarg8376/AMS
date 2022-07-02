package com.audit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.model.AuditBenchmark;
import com.audit.repository.AuditBenchmarkRepo;


@Service
public class AuditBenchmarkServiceImpl implements AuditBenchmarkService {
	
	@Autowired
	AuditBenchmarkRepo auditBenchmarkRepo;

	public List<AuditBenchmark> getAuditBenchmarkList() {
		return auditBenchmarkRepo.findAll();
	}
	
}
