package com.grupo16.usuarioservice.gateway.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.grupo16.usuarioservice.domain.Usuario;
import com.grupo16.usuarioservice.gateway.UsuarioRepositoryGateway;

@Component
public class UsuarioRepositoryGatewayImpl implements UsuarioRepositoryGateway {

	@Override
	public String getToken(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuario> get(Usuario usuario) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
