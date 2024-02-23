package com.grupo16.usuarioservice.gateway.repository.jpa.entity;

import com.grupo16.usuarioservice.domain.UserRole;
import com.grupo16.usuarioservice.domain.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Usuario")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String password;
	private int perfil;
	
	public UsuarioEntity(Usuario usuario) {
		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.password = usuario.getPassword();
		this.perfil = usuario.getRole().ordinal();
	}
	
	public Usuario mapperToDomain() {
		return Usuario.builder()
				.id(id)
				.login(login)
				.password(password)
				.role(UserRole.getByOrdinal(perfil))
				.build();
	}

}
