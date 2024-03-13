package com.grupo16.usuarioservice.config.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.grupo16.usuarioservice.gateway.repository.jpa.UsuarioRepository;
import com.grupo16.usuarioservice.gateway.repository.jpa.entity.UsuarioEntity;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class AuthorizationService implements UserDetailsService {

	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UsuarioEntity> userEntityOp = usuarioRepository.findByLogin(username);
		
		if(userEntityOp.isPresent()) {
			return userEntityOp.get();
		}
		log.warn("Usuário não encontrado: {}", username);
		throw new UsernameNotFoundException(username);
	}

}
