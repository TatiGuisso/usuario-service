package com.grupo16.usuarioservice.gateway.repository.jpa.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class UsuarioEntity implements UserDetails {
	private static final long serialVersionUID = 7905839584089658530L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String password;
	private int perfil;
	
	public UsuarioEntity(Usuario usuario, String password) {
		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.password = password;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + UserRole.getByOrdinal(perfil).name()));
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
