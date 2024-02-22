package com.grupo16.usuarioservice.gateway.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupo16.usuarioservice.domain.UserRole;
import com.grupo16.usuarioservice.domain.Usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@JsonInclude(Include.NON_NULL)
public class UsuarioJson {
	
	private Long id;
	@NotBlank
	private String login;
	@NotBlank
	private String password;
	private String role;
	
	public Usuario mapperToDomain() {
		return Usuario.builder()
				.id(id)
				.login(login)
				.password(password)
//				.role(UserRole.valueOf(role))
				.build();
	}

}
