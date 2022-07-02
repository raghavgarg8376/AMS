package com.audit.model;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@EqualsAndHashCode
public class AuthenticationResponse {
	private String name;
	private String projectName;
	private boolean isValid;
}