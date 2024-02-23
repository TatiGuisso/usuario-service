package com.grupo16.usuarioservice.gateway.repository.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo16.usuarioservice.gateway.repository.jpa.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

	Optional<UsuarioEntity> findByLogin(String login);

}
