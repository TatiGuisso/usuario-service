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
	public String getToken(Usuario usuario) {
		// TODO: implementar metodo.
		
		return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
	}

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
