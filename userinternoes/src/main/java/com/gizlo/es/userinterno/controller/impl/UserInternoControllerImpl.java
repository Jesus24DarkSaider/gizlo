package com.gizlo.es.userinterno.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.gizlo.es.userinterno.controller.contract.IUserInternoController;
import com.gizlo.es.userinterno.controller.dto.UserInternoDto;
import com.gizlo.es.userinterno.service.contract.IUserInternoSvc;
import com.gizlo.es.userinterno.utils.logicaComun.constantes.MensajeDelSistema;
import com.gizlo.es.userinterno.utils.logicaComun.utilitarios.RespuestaDto;
import com.gizlo.es.userinterno.utils.validator.EntityServiceValidator;

@RestController
public class UserInternoControllerImpl implements IUserInternoController {

	private static final Logger LOG = LoggerFactory.getLogger(UserInternoControllerImpl.class);

	private static final String separador = "=========================================================="
			+ "=======================================================================================";

	@Autowired
	IUserInternoSvc serviceUserInterno;

	@Override
	public ResponseEntity<Object> crearUsuarioInterno(@Valid UserInternoDto userInternoDto) {
		LOG.info(separador);
		ResponseEntity<Object> respuesta;
		try {
			LOG.info("INICIA CAPACIDAD DE CREAR USUARIO INTERNO");
			UserInternoDto usuarioInternoDto;
			usuarioInternoDto = serviceUserInterno.crearUsuarioInterno(userInternoDto);
			respuesta = EntityServiceValidator.validarResultado(usuarioInternoDto);
		} catch (Exception e) {
			LOG.info("EXCEPCION " + e.getMessage());
			respuesta = new ResponseEntity<>(
					new RespuestaDto().codigoRespuesta("500").descripcion(MensajeDelSistema.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOG.info("FINALIZA CAPACIDAD DE CREAR USUARIO INTERNO");
		LOG.info(separador);
		return respuesta;
	}

	@Override
	public ResponseEntity<Object> consultarUsuariosInternos() {
		LOG.info(separador);
		ResponseEntity<Object> respuesta;
		try {
			LOG.info("INICIA CAPACIDAD DE CONSULTAR USUARIOS INTERNOS");
			List<UserInternoDto> usuario;
			usuario = serviceUserInterno.consultarUsuariosInternos();
			respuesta = EntityServiceValidator.validarResultado(usuario);
		} catch (Exception e) {
			LOG.info("EXCEPCION " + e.getMessage());
			respuesta = new ResponseEntity<>(
					new RespuestaDto().codigoRespuesta("500").descripcion(MensajeDelSistema.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOG.info("FINALIZA CAPACIDAD DE CONSULTAR USUARIOS INTERNOS");
		LOG.info(separador);
		return respuesta;
	}

}
