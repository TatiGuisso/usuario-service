package com.grupo16.usuarioservice.usecase;

import org.springframework.stereotype.Service;

import com.grupo16.usuarioservice.domain.Usuario;
import com.grupo16.usuarioservice.gateway.UsuarioRepositoryGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginUseCase {
	
	private UsuarioRepositoryGateway usuarioRepositoryGateway;
	
	private ObterUsuarioUseCase obterUsuarioUseCase;

	public String getToken(Usuario usuario) {

		Usuario usuarioData = obterUsuarioUseCase.get(usuario);
		
		return  usuarioRepositoryGateway.getToken(usuarioData);
		
	}

}
