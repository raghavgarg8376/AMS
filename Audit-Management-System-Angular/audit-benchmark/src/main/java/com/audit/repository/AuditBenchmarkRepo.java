package com.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.audit.model.AuditBenchmark;

public interface AuditBenchmarkRepo extends JpaRepository<AuditBenchmark, Integer> {
	
}
