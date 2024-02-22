package com.grupo16.usuarioservice.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.usuarioservice.domain.Usuario;
import com.grupo16.usuarioservice.gateway.controller.json.UsuarioJson;
import com.grupo16.usuarioservice.usecase.LoginUseCase;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("usuarios")
@AllArgsConstructor
public class UsuarioController {
	
	private LoginUseCase loginUseCase;
	
	@PostMapping("login")
	public String login(
			@Valid
			@RequestBody UsuarioJson usuarioJson) {
		log.trace("Start usuarioJson={}", usuarioJson);
		
		Usuario usuario = usuarioJson.mapperToDomain();
		
		String token = loginUseCase.getToken(usuario);
		
		log.trace("End token={}", token);
		return token;
	}

}
