package com.gizlo.ms.usuario.controller.impl;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.gizlo.ms.usuario.controller.contract.IUsuarioController;
import com.gizlo.ms.usuario.controller.dto.USERTYPE;
import com.gizlo.ms.usuario.controller.dto.UsuarioExternoDto;
import com.gizlo.ms.usuario.controller.dto.UsuarioInternoDto;
import com.gizlo.ms.usuario.service.contract.IUsuarioSvc;
import com.gizlo.ms.usuario.utils.UsuarioMsValidator;
import com.gizlo.ms.usuario.utils.logicaComun.constantes.MensajeDelSistema;
import com.gizlo.ms.usuario.utils.logicaComun.exception.BusinessException;
import com.gizlo.ms.usuario.utils.logicaComun.utilitarios.DataValidator;
import com.gizlo.ms.usuario.utils.logicaComun.utilitarios.RespuestaDto;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioControllerImpl implements IUsuarioController {

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioControllerImpl.class);

	@Autowired
	IUsuarioSvc usuarioServicio;

	@Override
	public ResponseEntity<Object> consultarUsuariosPorTipo(USERTYPE tipo) {
		ResponseEntity<Object> respuesta = null;
		LOG.info(" INICIA CAPACIDAD DE CONSULTAR USUARIOS POR TIPO");
		try {
			Object listadoUsuarios;
			listadoUsuarios = usuarioServicio.consultarUsuariosPorTipo(tipo);
			respuesta = UsuarioMsValidator.validarResultado(listadoUsuarios);
		} catch (BusinessException ex) {
			LOG.error("EXCEPCION DE NEGOCIO {}", ex.fillInStackTrace());
			respuesta = DataValidator.validarResultadoObj(ex);
		} catch (Exception e) {
			LOG.error("EXCEPCION EN CAPACIDAD DE LOGUEAR USUARIO {}", e.getMessage());
			respuesta = new ResponseEntity<Object>(
					new RespuestaDto().codigoRespuesta("204").descripcion("NO HAY CONTENIDO"), HttpStatus.NO_CONTENT);
		}
		LOG.info(" TERMINA CAPACIDAD DE CONSULTAR USUARIOS POR TIPO");
		return respuesta;
	}

	@Override
	public ResponseEntity<Object> crearUsuarioExterno(@Valid UsuarioExternoDto usuarioExternoDTO) {
		ResponseEntity<Object> respuesta = null;
		LOG.info(" INICIA CAPACIDAD DE CREAR USUARIOS EXTERNO");
		try {
			Object response;
			response = usuarioServicio.crearUsuarioExterno(usuarioExternoDTO);
			respuesta = UsuarioMsValidator.validarResultadoRecursoCreado(response);
		} catch (BusinessException ex) {
			LOG.error("EXCEPCION DE NEGOCIO {}", ex.fillInStackTrace());
			respuesta = DataValidator.validarResultadoObj(ex);
		} catch (Exception e) {
			LOG.error("EXCEPCION EN CAPACIDAD DE LOGUEAR USUARIO {}", e.getMessage());
			respuesta = new ResponseEntity<Object>(
					new RespuestaDto().codigoRespuesta("500").descripcion(MensajeDelSistema.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOG.info(" FINALIZA CAPACIDAD DE CREAR USUARIOS EXTERNO");
		return respuesta;
	}

	@Override
	public ResponseEntity<Object> crearUsuarioInterno(@Valid UsuarioInternoDto userInternoDto) {
		ResponseEntity<Object> respuesta = null;
		LOG.info(" INICIA CAPACIDAD DE CREAR USUARIOS EXTERNO");
		try {
			Object response;
			response = usuarioServicio.crearUsuarioInterno(userInternoDto);
			respuesta = UsuarioMsValidator.validarResultadoRecursoCreado(response);
		} catch (BusinessException ex) {
			LOG.error("EXCEPCION DE NEGOCIO {}", ex.fillInStackTrace());
			respuesta = DataValidator.validarResultadoObj(ex);
		} catch (Exception e) {
			LOG.error("EXCEPCION EN CAPACIDAD DE LOGUEAR USUARIO {}", e.getMessage());
			respuesta = new ResponseEntity<Object>(
					new RespuestaDto().codigoRespuesta("500").descripcion(MensajeDelSistema.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOG.info(" FINALIZA CAPACIDAD DE CREAR USUARIOS EXTERNO");
		return respuesta;
	}

}
