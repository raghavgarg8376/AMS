package com.audit.model;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;


import lombok.Getter;
import lombok.Setter;


@Component
@Getter
@Setter
public class AuthenticationRequest {
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
}
