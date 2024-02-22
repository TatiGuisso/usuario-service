package com.grupo16.usuarioservice.gateway.controller.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UsuarioResponseJson {
	
	private String token;

}
