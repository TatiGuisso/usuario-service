package com.grupo16.usuarioservice.usecase.exception;

import com.grupo16.usuarioservice.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class UsuarioJaExisteException extends SystemBaseException {
	private static final long serialVersionUID = -4002723974207088422L;
	
	private final String code = "usuario.usuarioJaExiste";
	private final String message = "Usuário já existe.";
	private final Integer httpStatus = 422;

}
