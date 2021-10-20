package com.gizlo.es.userinterno.service.contract;

import java.util.List;

import javax.validation.Valid;

import com.gizlo.es.userinterno.controller.dto.UserInternoDto;

public interface IUserInternoSvc {

	public UserInternoDto crearUsuarioExterno(@Valid UserInternoDto userInternoDto);

	public List<UserInternoDto> consultarUsuariosInternos();

}
