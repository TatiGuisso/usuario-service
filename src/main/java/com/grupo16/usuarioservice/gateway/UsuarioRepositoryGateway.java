package com.grupo16.usuarioservice.gateway;

import java.util.Optional;

import com.grupo16.usuarioservice.domain.Usuario;

public interface UsuarioRepositoryGateway {

	String getToken(Usuario usuario);

	Optional<Usuario> get(Usuario usuario);

}
