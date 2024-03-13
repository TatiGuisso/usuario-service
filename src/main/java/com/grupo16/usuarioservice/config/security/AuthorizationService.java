package com.grupo16.usuarioservice.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.grupo16.usuarioservice.gateway.repository.jpa.UsuarioRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthorizationService implements UserDetailsService {

	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepository.findByLogin(username).orElse(null);
	}

}
