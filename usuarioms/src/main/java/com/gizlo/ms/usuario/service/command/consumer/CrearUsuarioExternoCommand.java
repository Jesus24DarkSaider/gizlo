package com.gizlo.ms.usuario.service.command.consumer;

import org.springframework.stereotype.Component;

import com.gizlo.ms.usuario.utils.logicaComun.exception.BusinessException;
import com.gizlo.ms.usuario.utils.patronCommand.ICommand;
import com.gizlo.ms.usuario.utils.patronCommand.IParameter;

@Component
public class CrearUsuarioExternoCommand implements ICommand {

	@Override
	public Object execute(IParameter parameter) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
		throw new UnsupportedOperationException();
	}

}
