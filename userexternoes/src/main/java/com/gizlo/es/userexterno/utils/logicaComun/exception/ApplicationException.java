package com.gizlo.es.userexterno.utils.logicaComun.exception;

public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TipoError error;

	public ApplicationException(String mensaje, TipoError error) {
		super(mensaje);
		this.error = error;
	}

	public ApplicationException(String mensaje, TipoError error, Throwable causa) {
		super(mensaje, causa);
		this.error = error;
	}

	public ApplicationException(String mensaje) {
		super(mensaje);
		this.error = TipoError.ERROR_INESPERADO;
	}

	/**
	 * @return the error
	 */
	public TipoError getError() {
		return error;
	}
}
