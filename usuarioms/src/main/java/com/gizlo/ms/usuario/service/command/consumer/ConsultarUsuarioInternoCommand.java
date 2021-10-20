package com.gizlo.ms.usuario.service.command.consumer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.gizlo.ms.usuario.controller.dto.MapParam;
import com.gizlo.ms.usuario.controller.dto.UsuarioInternoDto;
import com.gizlo.ms.usuario.utils.convert.UsuarioConvert;
import com.gizlo.ms.usuario.utils.logicaComun.constantes.MsUsuarioConstans;
import com.gizlo.ms.usuario.utils.logicaComun.exception.BusinessException;
import com.gizlo.ms.usuario.utils.logicaComun.exception.TipoError;
import com.gizlo.ms.usuario.utils.patronCommand.ICommand;
import com.gizlo.ms.usuario.utils.patronCommand.IParameter;

public class ConsultarUsuarioInternoCommand implements ICommand {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarUsuarioExternoCommand.class);

	@Value("${uri.usuariointernoes}")
	private String hostUsuarioInterno;

	@Override
	public Object execute(IParameter parameter) throws BusinessException {
		LOGGER.info("INICIA COMANDO CONSULTAR USUARIO INTERNOS");

		ResponseEntity<List<UsuarioInternoDto>> listadoUsuarioInterno = null;
		MapParam parametro = (MapParam) parameter;
		RestTemplate clienteRest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		HttpEntity<Object> request = new HttpEntity<>(headers);

		try {
			/*
			 * REALIZAMOS LA PETICION HTTP GET AL SERVICIO USUARIOES A LA CAPACIDAD
			 * CONSULTAR USUARIO POR EMAIL
			 */
			listadoUsuarioInterno = clienteRest.exchange(
					hostUsuarioInterno.concat(MsUsuarioConstans.GET_USUARIOS_INTERNOS), HttpMethod.GET, request,
					new ParameterizedTypeReference<List<UsuarioInternoDto>>() {
					}, parametro.getValues().get("tipoUsuario"));

			LOGGER.info("SERVICIO RETORNA CODIGO HTTP: " + listadoUsuarioInterno.getStatusCodeValue());
			LOGGER.info("BODY RETORNADO :" + UsuarioConvert.convertirObjetoAString(listadoUsuarioInterno.getBody()));

		} catch (HttpStatusCodeException e) {
			throw new BusinessException("ERROR EN EL SERVICIO DE CONSULTA USUARIOS INTERNO", TipoError.FUENTE_DE_DATOS);
		}
		LOGGER.info("FINALIZA COMANDO CONSULTAR USUARIO INTERNO");
		return listadoUsuarioInterno.getBody();
	}

	@Override
	public void undo() {
		throw new UnsupportedOperationException();
	}

}
