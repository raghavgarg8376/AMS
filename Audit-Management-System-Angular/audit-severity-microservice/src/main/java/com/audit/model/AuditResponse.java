package com.audit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Data
@Entity
@Table(name="audit_response")
@AllArgsConstructor
@NoArgsConstructor
public class AuditResponse {
	
	@Id
	@GeneratedValue
	private int auditId;
	@NotEmpty
	private String managerName;
	@NotEmpty
	private String projectName;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;
	
	
	@NotEmpty
	private String projectExecutionStatus;
	@NotEmpty
	private String remedialActionDuration;
	
	public void setCreationDateTime(Date creationDateTime2) {
		this.creationDateTime = creationDateTime2;
	}
	
}
