package com.grupo16.usuarioservice.gateway.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.grupo16.usuarioservice.domain.Usuario;
import com.grupo16.usuarioservice.gateway.UsuarioRepositoryGateway;

@Component
public class UsuarioRepositoryGatewayImpl implements UsuarioRepositoryGateway {

	@Override
	public String getToken(Usuario usuario) {
		// TODO: implementar metodo.
		
		return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
	}

	@Override
	public Optional<Usuario> get(Usuario usuario) {
		// TODO: implementar metodo.
		
		return Optional.of(Usuario.builder().id(1L).login("tati@gmail.com").password("123654").build());
	}

}
