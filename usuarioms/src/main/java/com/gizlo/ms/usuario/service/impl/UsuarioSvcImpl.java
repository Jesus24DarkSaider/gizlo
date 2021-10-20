package com.gizlo.ms.usuario.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gizlo.ms.usuario.controller.dto.MapParam;
import com.gizlo.ms.usuario.controller.dto.USERTYPE;
import com.gizlo.ms.usuario.controller.dto.UsuarioExternoDto;
import com.gizlo.ms.usuario.controller.dto.UsuarioInternoDto;
import com.gizlo.ms.usuario.service.command.consumer.ConsultarUsuarioExternoCommand;
import com.gizlo.ms.usuario.service.command.consumer.ConsultarUsuarioInternoCommand;
import com.gizlo.ms.usuario.service.command.consumer.CrearUsuarioExternoCommand;
import com.gizlo.ms.usuario.service.command.consumer.CrearUsuarioInternoCommand;
import com.gizlo.ms.usuario.service.contract.IUsuarioSvc;
import com.gizlo.ms.usuario.utils.logicaComun.exception.BusinessException;
import com.gizlo.ms.usuario.utils.logicaComun.exception.TipoError;
import com.gizlo.ms.usuario.utils.logicaComun.utilitarios.RespuestaDto;

@Service
public class UsuarioSvcImpl implements IUsuarioSvc {

	@Autowired
	ConsultarUsuarioExternoCommand consultarUsuarioExternoCommand;

	@Autowired
	ConsultarUsuarioInternoCommand consultarUsuarioInternoCommand;

	@Autowired
	CrearUsuarioExternoCommand crearUsuarioExternoCommand;

	@Autowired
	CrearUsuarioInternoCommand crearUsuarioInternoCommand;

	@Override
	public Object consultarUsuariosPorTipo(USERTYPE tipo) throws BusinessException {
		Object respuesta = null;

		MapParam param;

		if (tipo.equals(USERTYPE.USUARIO_EXTERNO)) {
			param = new MapParam().addValue("tipo", tipo.toString());
			respuesta = consultarUsuarioExternoCommand.execute(param);
			return respuesta;
		}

		if (tipo.equals(USERTYPE.USUARIO_INTERNO)) {
			param = new MapParam().addValue("tipo", tipo.toString());
			respuesta = consultarUsuarioInternoCommand.execute(param);
			return respuesta;
		}

		throw new BusinessException("SELECCIONE EL TIPO DE USUARIO A CONSULTAR", TipoError.SOLICITUD_INVALIDA);
	}

	@Override
	public RespuestaDto crearUsuarioExterno(@Valid UsuarioExternoDto usuarioExternoDTO) throws BusinessException {
		RespuestaDto respuesta;
		respuesta = (RespuestaDto) crearUsuarioExternoCommand.execute(usuarioExternoDTO);
		return respuesta;
	}

	@Override
	public RespuestaDto crearUsuarioInterno(@Valid UsuarioInternoDto userInternoDto) throws BusinessException {
		RespuestaDto respuesta;
		respuesta = (RespuestaDto) crearUsuarioInternoCommand.execute(userInternoDto);
		return respuesta;
	}

}
