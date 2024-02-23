package com.grupo16.usuarioservice.gateway.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.grupo16.usuarioservice.domain.Usuario;
import com.grupo16.usuarioservice.gateway.UsuarioRepositoryGateway;
import com.grupo16.usuarioservice.gateway.repository.jpa.UsuarioRepository;
import com.grupo16.usuarioservice.gateway.repository.jpa.entity.UsuarioEntity;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UsuarioRepositoryGatewayImpl implements UsuarioRepositoryGateway {

	private UsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> get(Usuario usuario) {
		Optional<Usuario> usuarioOp = Optional.empty();		
		
		Optional<UsuarioEntity> usuarioEntityOp = usuarioRepository.findByLogin(usuario.getLogin());
		
		if(usuarioEntityOp.isPresent()) {
			Usuario usuarioFound = usuarioEntityOp.get().mapperToDomain();
			usuarioOp = Optional.of(usuarioFound);
		}
		
		return usuarioOp;
	}

}
