package com.gizlo.es.userinterno.utils.validator;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.gizlo.es.userinterno.controller.dto.UserInternoDto;
import com.gizlo.es.userinterno.utils.logicaComun.constantes.MensajeDelSistema;
import com.gizlo.es.userinterno.utils.logicaComun.utilitarios.RespuestaDto;

public class EntityServiceValidator {

	public static final ResponseEntity<Object> validarResultado(UserInternoDto resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new RespuestaDto().codigoRespuesta("500").descripcion(MensajeDelSistema.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new RespuestaDto().codigoRespuesta("201")
				.descripcion(String.format("RECURSO CREADO CON ID [%s]", resultado.getId())), HttpStatus.CREATED);
	}

	public static final ResponseEntity<Object> validarResultado(List<UserInternoDto> resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new RespuestaDto().codigoRespuesta("204").descripcion(MensajeDelSistema.ERROR_INTERNO),
					HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(resultado, HttpStatus.OK);
	}

}
