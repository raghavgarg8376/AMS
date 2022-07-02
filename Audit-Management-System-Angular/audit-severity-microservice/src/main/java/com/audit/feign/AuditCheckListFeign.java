package com.audit.feign;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.audit.model.AuditType;
import com.audit.model.AuditQuestion;

@FeignClient(url = "${ms.checklist}", name="auditChecklist")
public interface AuditCheckListFeign {
	
	@PostMapping(value = "/AuditCheckListQuestions")
	public List<AuditQuestion> auditCheckListQuestions(@RequestHeader("Authorization") String jwt, @RequestBody AuditType auditType);
	
}
