package com.gizlo.ms.usuario.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gizlo.ms.usuario.utils.logicaComun.constantes.MensajeDelSistema;
import com.gizlo.ms.usuario.utils.logicaComun.utilitarios.RespuestaDto;

public class UsuarioMsValidator {

	public static final ResponseEntity<Object> validarResultado(Object resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(new RespuestaDto().codigoRespuesta("204").descripcion("NO HAY CONTENIDO"),
					HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(resultado, HttpStatus.OK);
	}

	public static final ResponseEntity<Object> validarResultadoRecursoCreado(Object resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new RespuestaDto().codigoRespuesta("500").descripcion(MensajeDelSistema.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(
				new RespuestaDto().codigoRespuesta("201").descripcion(MensajeDelSistema.RECURSO_CREADO),
				HttpStatus.CREATED);
	}

}
