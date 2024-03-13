package com.grupo16.usuarioservice.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grupo16.usuarioservice.domain.Usuario;
import com.grupo16.usuarioservice.gateway.UsuarioRepositoryGateway;
import com.grupo16.usuarioservice.usecase.exception.UsuarioJaExisteException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class CriarUsuarioUseCase {
	
	private UsuarioRepositoryGateway usuarioRepositoryGateway;

	public Long salvar(Usuario usuario) {
		
		Optional<Usuario> usuarioOp = usuarioRepositoryGateway.obterPorLogin(usuario);
		
		if(usuarioOp.isPresent()) {
			log.warn("Usuário ja existe com login informado. {}", usuario.getLogin());
			throw new UsuarioJaExisteException();
		}
		
		return usuarioRepositoryGateway.salvar(usuario);
		
	}

}
