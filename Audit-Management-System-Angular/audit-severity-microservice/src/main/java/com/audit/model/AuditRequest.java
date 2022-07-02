package com.audit.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditRequest {
	
	@NotEmpty
	private String projectName;
	@NotEmpty
	private String managerName;
	
	private AuditDetail auditDetail;
	
}
