package com.audit.model;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
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
public class AuditBenchmark {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int benchmarkId;
	@NotEmpty
	private String auditType;
	@NotNull
	private int benchmarkNoAnswers;
	
}
