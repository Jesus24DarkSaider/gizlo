package com.gizlo.ms.usuario.service.command.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.gizlo.ms.usuario.controller.dto.UsuarioExternoDto;
import com.gizlo.ms.usuario.utils.convert.UsuarioConvert;
import com.gizlo.ms.usuario.utils.logicaComun.constantes.MsUsuarioConstans;
import com.gizlo.ms.usuario.utils.logicaComun.exception.BusinessException;
import com.gizlo.ms.usuario.utils.logicaComun.exception.TipoError;
import com.gizlo.ms.usuario.utils.logicaComun.utilitarios.RespuestaDto;
import com.gizlo.ms.usuario.utils.patronCommand.ICommand;
import com.gizlo.ms.usuario.utils.patronCommand.IParameter;

@Component
public class CrearUsuarioExternoCommand implements ICommand {

	private static final Logger LOGGER = LoggerFactory.getLogger(CrearUsuarioExternoCommand.class);

	@Value("${uri.usuarioexternoes}")
	private String hostService;

	@Override
	public Object execute(IParameter parametro) throws BusinessException {
		
		ResponseEntity<RespuestaDto> response = null;

		try {
			LOGGER.info("INICIA COMANDO CREAR USUARIO EXTERNO");
			HttpHeaders header = new HttpHeaders();
			header.set("Content-Type", "application/json");
			UsuarioExternoDto usuarioExterno = (UsuarioExternoDto) parametro;
			HttpEntity<UsuarioExternoDto> request = new HttpEntity<>(usuarioExterno, header);
			RestTemplate clienteRest = new RestTemplate();

			response = clienteRest.exchange(hostService.concat(MsUsuarioConstans.POST_USUARIO_EXTERNO),
					HttpMethod.POST, request, RespuestaDto.class);

			LOGGER.info("SERVICIO RETORNA CODIGO HTTP: " + response.getStatusCodeValue());
			LOGGER.info("BODY RETORNADO :" +  UsuarioConvert.convertirObjetoAString(response.getBody()));

		} catch (HttpStatusCodeException e) {
			throw new BusinessException("ERROR AL CREAR USUARIO EXTERNO",TipoError.FUENTE_DE_DATOS);
		}
		LOGGER.info("FINALIZA COMANDO CREAR USUARIO EXTERNO");
		return response.getBody();
	}

	@Override
	public void undo() {
		throw new UnsupportedOperationException();
	}

}
