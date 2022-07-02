package com.audit.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class AuditType {
	
	@NotEmpty
	private String auditType;
}
