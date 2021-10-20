package com.gizlo.ms.usuario.controller.dto;

public enum USERTYPE {

	USUARIO_INTERNO("USUARIO_INTERNO"), USUARIO_EXTERNO("USUARIO_EXTERNO");

	private String value;

	USERTYPE(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static USERTYPE fromValue(String value) {
		for (USERTYPE x : USERTYPE.values()) {
			if (x.value.equals(value)) {
				return x;
			}
		}
		throw new IllegalArgumentException(" VALOR NO PRESENTE EN EL ENUM '" + value + "'");
	}

}
