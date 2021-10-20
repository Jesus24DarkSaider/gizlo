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
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.gizlo.ms.usuario.controller.dto.MapParam;
import com.gizlo.ms.usuario.controller.dto.UsuarioExternoDto;
import com.gizlo.ms.usuario.utils.convert.UsuarioConvert;
import com.gizlo.ms.usuario.utils.logicaComun.constantes.MsUsuarioConstans;
import com.gizlo.ms.usuario.utils.logicaComun.exception.BusinessException;
import com.gizlo.ms.usuario.utils.logicaComun.exception.TipoError;
import com.gizlo.ms.usuario.utils.patronCommand.ICommand;
import com.gizlo.ms.usuario.utils.patronCommand.IParameter;

@Component
public class ConsultarUsuarioExternoCommand implements ICommand {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarUsuarioExternoCommand.class);

	@Value("${uri.usuarioexternoes}")
	private String hostUsuarioExterno;

	@Override
	public Object execute(IParameter parameter) throws BusinessException {
		LOGGER.info("INICIA COMANDO CONSULTAR USUARIO EXTERNOS");

		ResponseEntity<List<UsuarioExternoDto>> listadoUsuarioExterno = null;
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
			listadoUsuarioExterno = clienteRest.exchange(
					hostUsuarioExterno.concat(MsUsuarioConstans.GET_USUARIOS_EXTERNOS), HttpMethod.GET, request,
					new ParameterizedTypeReference<List<UsuarioExternoDto>>() {
					}, parametro.getValues().get("tipoUsuario"));

			LOGGER.info("SERVICIO RETORNA CODIGO HTTP: " + listadoUsuarioExterno.getStatusCodeValue());
			LOGGER.info("BODY RETORNADO :" + UsuarioConvert.convertirObjetoAString(listadoUsuarioExterno.getBody()));

		} catch (HttpStatusCodeException e) {
			throw new BusinessException("ERROR EN EL SERVICIO DE CONSULTA USUARIOS EXTERNOS",
					TipoError.FUENTE_DE_DATOS);
		}
		LOGGER.info("FINALIZA COMANDO CONSULTAR USUARIO EXTERNOS");
		return listadoUsuarioExterno.getBody();
	}

	@Override
	public void undo() {
		throw new UnsupportedOperationException();
	}

}
