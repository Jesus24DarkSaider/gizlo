package com.gizlo.ms.usuario.utils.patronCommand;

import com.gizlo.ms.usuario.utils.logicaComun.exception.BusinessException;

public interface ICommand {

	Object execute(IParameter parameter) throws BusinessException;

	void undo();

}
