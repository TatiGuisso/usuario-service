package com.grupo16.usuarioservice.gateway;

import com.grupo16.usuarioservice.domain.Usuario;

public interface TokenGateway {
	
	String getToken(Usuario usuario);

}
