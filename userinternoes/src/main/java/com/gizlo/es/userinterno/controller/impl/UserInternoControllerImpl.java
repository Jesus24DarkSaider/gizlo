package com.gizlo.es.userinterno.controller.impl;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.gizlo.es.userinterno.controller.contract.IUserInternoController;
import com.gizlo.es.userinterno.controller.dto.UserInternoDto;

@RestController
public class UserInternoControllerImpl implements IUserInternoController {

	@Override
	public ResponseEntity<Object> crearUsuarioExterno(@Valid UserInternoDto userInternoDtof) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> consultarUsuariosInternos() {
		// TODO Auto-generated method stub
		return null;
	}

}
