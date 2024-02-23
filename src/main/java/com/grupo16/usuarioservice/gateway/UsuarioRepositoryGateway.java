package com.grupo16.usuarioservice.gateway;

import java.util.Optional;

import com.grupo16.usuarioservice.domain.Usuario;

public interface UsuarioRepositoryGateway {

	Optional<Usuario> get(Usuario usuario);

}
