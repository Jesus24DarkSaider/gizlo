package com.gizlo.es.userexterno.service.contract;

import java.util.List;

import javax.validation.Valid;

import com.gizlo.es.userexterno.controller.dto.UserExternoDto;
import com.gizlo.es.userexterno.utils.logicaComun.exception.BusinessException;

public interface IUserExternoSvc {

	public UserExternoDto crearUsuarioExterno(@Valid UserExternoDto usuarioExternoDTO) throws BusinessException;

	public List<UserExternoDto> listarUsuariosExternos()
			throws BusinessException;
}
