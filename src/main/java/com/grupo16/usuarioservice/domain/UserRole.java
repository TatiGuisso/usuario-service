package com.grupo16.usuarioservice.domain;

public enum UserRole {
	ADMIN,
	USER;
	
	public static UserRole getByOrdinal(int ordinal) {
		UserRole[] values = values();
		return values[ordinal];
	}
}
