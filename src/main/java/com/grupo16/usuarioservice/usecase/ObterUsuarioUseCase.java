package com.grupo16.usuarioservice.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grupo16.usuarioservice.domain.Usuario;
import com.grupo16.usuarioservice.gateway.UsuarioRepositoryGateway;
import com.grupo16.usuarioservice.gateway.exception.UsuarioNaoEncontradoException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ObterUsuarioUseCase {
	
	private UsuarioRepositoryGateway usuarioRepositoryGateway;

	public Usuario get(Usuario usuario) {
		
		Optional<Usuario> usuarioOp = usuarioRepositoryGateway.get(usuario);
		
		if(usuarioOp.isEmpty()) {
			throw new UsuarioNaoEncontradoException();
		}
			
		return usuarioOp.get();
	}

}
