package com.gizlo.ms.usuario.service.command.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gizlo.ms.usuario.utils.logicaComun.exception.BusinessException;
import com.gizlo.ms.usuario.utils.patronCommand.ICommand;
import com.gizlo.ms.usuario.utils.patronCommand.IParameter;

@Component
public class ConsultarUsuariosPorTipoCommand implements ICommand {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarUsuariosPorTipoCommand.class);

	@Value("${uri.es-usuarioExterno}")
	private String hostUsuarioInterno;

	@Value("${uri.es-usuarioExterno}")
	private String hostUsuarioExterno;

	@Override
	public Object execute(IParameter parameter) throws BusinessException {

		return null;
	}

	@Override
	public void undo() {
		throw new UnsupportedOperationException();
	}

}
