package com.grupo16.usuarioservice.gateway;

import java.util.Optional;

import com.grupo16.usuarioservice.domain.Usuario;

public interface UsuarioRepositoryGateway {

	Optional<Usuario> obterPorLogin(Usuario usuario);

	Long salvar(Usuario usuario);

}
