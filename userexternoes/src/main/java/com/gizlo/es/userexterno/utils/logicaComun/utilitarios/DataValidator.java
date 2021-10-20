package com.gizlo.es.userexterno.utils.logicaComun.utilitarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.gizlo.es.userexterno.utils.logicaComun.exception.BusinessException;

public final class DataValidator {

	public static ResponseEntity<Object> validarResultadoObj(Object exe) {
		ResponseEntity<Object> respuesta;
		BusinessException ex = (BusinessException) exe;
		switch (ex.getError()) {
		case NO_ENCONTRADO:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoRespuesta("404").descripcion(ex.getMessage()),
					HttpStatus.NOT_FOUND);
			break;
		case SOLICITUD_INVALIDA:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoRespuesta("400").descripcion(ex.getMessage()),
					HttpStatus.BAD_REQUEST);
			break;
		case SERVICIO_INACCESIBLE:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoRespuesta("502").descripcion(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		case FUENTE_DE_DATOS:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoRespuesta("503").descripcion(ex.getMessage()),
					HttpStatus.SERVICE_UNAVAILABLE);
			break;
		case LOGICA_NEGOCIO:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoRespuesta("0004").descripcion(ex.getMessage()),
					HttpStatus.BAD_REQUEST);
			break;
		default:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoRespuesta("500").descripcion(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		}

		return respuesta;
	}
}
