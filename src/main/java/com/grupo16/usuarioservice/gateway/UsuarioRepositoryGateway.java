package com.grupo16.usuarioservice.gateway;

import com.grupo16.usuarioservice.domain.Usuario;

public interface UsuarioRepositoryGateway {

	String getToken(Usuario usuario);

}
