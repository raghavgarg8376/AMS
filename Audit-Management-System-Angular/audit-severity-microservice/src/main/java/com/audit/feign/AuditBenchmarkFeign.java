package com.audit.feign;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.audit.model.AuditBenchmark;

@FeignClient(value = "auditbenchmark", url = "${ms.benchmark}")
public interface AuditBenchmarkFeign {
	
	@GetMapping("/AuditBenchmark")
	public List<AuditBenchmark> getAuditBenchmark(@RequestHeader("Authorization") String jwt); 
	
}
