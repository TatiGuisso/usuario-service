package com.grupo16.usuarioservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Usuario {
	
	private Long id;
	private String login;
	private String password;
	private UserRole role;

}
