package com.audit.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class AuditQuestion {
	
	@NotNull
	private int questionId;
	@NotEmpty
	private String question;
	@NotEmpty
	private String auditType;
	@NotEmpty
	private String response;
	
}
