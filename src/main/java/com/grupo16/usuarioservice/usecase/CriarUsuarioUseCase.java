package com.grupo16.usuarioservice.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grupo16.usuarioservice.domain.Usuario;
import com.grupo16.usuarioservice.gateway.UsuarioRepositoryGateway;
import com.grupo16.usuarioservice.usecase.exception.UsuarioJaExisteException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CriarUsuarioUseCase {
	
	private UsuarioRepositoryGateway usuarioRepositoryGateway;

	public Long salvar(Usuario usuario) {
		
		Optional<Usuario> usuarioOp = usuarioRepositoryGateway.obterPorLogin(usuario);
		
		if(usuarioOp.isPresent()) {
			throw new UsuarioJaExisteException();
		}
		
		return usuarioRepositoryGateway.salvar(usuario);
		
	}

}
