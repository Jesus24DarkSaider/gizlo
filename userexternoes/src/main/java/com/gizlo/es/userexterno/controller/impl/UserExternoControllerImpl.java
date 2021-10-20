package com.gizlo.es.userexterno.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.gizlo.es.userexterno.controller.contract.IUserExternoController;
import com.gizlo.es.userexterno.controller.dto.UserExternoDto;
import com.gizlo.es.userexterno.service.contract.IUserExternoSvc;
import com.gizlo.es.userexterno.utils.logicaComun.constantes.MensajeDelSistema;
import com.gizlo.es.userexterno.utils.logicaComun.exception.BusinessException;
import com.gizlo.es.userexterno.utils.logicaComun.utilitarios.DataValidator;
import com.gizlo.es.userexterno.utils.logicaComun.utilitarios.RespuestaDto;
import com.gizlo.es.userexterno.utils.validator.EntityServiceValidator;

@RestController
public class UserExternoControllerImpl implements IUserExternoController {

	private static final Logger LOG = LoggerFactory.getLogger(UserExternoControllerImpl.class);

	private static final String separador = "=========================================================="
			+ "=======================================================================================";

	@Autowired
	IUserExternoSvc serviceUserExterno;

	@Override
	public ResponseEntity<Object> crearUsuarioExterno(@Valid UserExternoDto usuarioExternoDTO) {
		LOG.info(separador);
		ResponseEntity<Object> respuesta;
		try {
			LOG.info("INICIA CAPACIDAD DE CREAR USUARIO EXTERNO");
			UserExternoDto usuario;
			usuario = serviceUserExterno.crearUsuarioExterno(usuarioExternoDTO);
			respuesta = EntityServiceValidator.validarResultado(usuario);
		} catch (BusinessException ex) {
			LOG.info("ERROR DE NEGOCIO", ex.getMessage());
			respuesta = DataValidator.validarResultado(ex);
		} catch (Exception e) {
			LOG.info("EXCEPCION " + e.getMessage());
			respuesta = new ResponseEntity<>(
					new RespuestaDto().codigoRespuesta("500").descripcion(MensajeDelSistema.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOG.info("FINALIZA CAPACIDAD DE CREAR USUARIO");
		LOG.info(separador);
		return respuesta;
	}

	@Override
	public ResponseEntity<Object> consultarUsuariosExternos() {
		LOG.info(separador);
		ResponseEntity<Object> respuesta;
		try {
			LOG.info("INICIA CAPACIDAD DE CONSULTAR USUARIOS EXTERNOS");
			List<UserExternoDto> usuario;
			usuario = serviceUserExterno.listarUsuariosExternos();
			respuesta = EntityServiceValidator.validarResultado(usuario);
		} catch (BusinessException ex) {
			LOG.info("ERROR DE NEGOCIO", ex.getMessage());
			respuesta = DataValidator.validarResultado(ex);
		} catch (Exception e) {
			LOG.info("EXCEPCION " + e.getMessage());
			respuesta = new ResponseEntity<>(
					new RespuestaDto().codigoRespuesta("500").descripcion(MensajeDelSistema.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOG.info("FINALIZA CAPACIDAD DE CONSULTAR USUARIOS EXTERNOS");
		LOG.info(separador);
		return respuesta;
	}

}
