package com.grupo16.usuarioservice.usecase;

import org.springframework.stereotype.Service;

import com.grupo16.usuarioservice.domain.Usuario;
import com.grupo16.usuarioservice.gateway.TokenGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ObterTokenUseCase {
	
	private TokenGateway tokenGateway;
	
	public String getToken(Usuario usuario) {

		return  tokenGateway.getToken(usuario);
		
	}

}
