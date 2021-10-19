package com.gizlo.es.userexterno.controller.impl;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.gizlo.es.userexterno.controller.contract.IUserExternoController;
import com.gizlo.es.userexterno.controller.dto.UserExternoDto;

@RestController
public class UserExternoControllerImpl implements IUserExternoController {

	@Override
	public ResponseEntity<Object> crearUsuarioExterno(@Valid UserExternoDto usuarioExternoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> consultarIntentosLoginPorCorreo() {
		// TODO Auto-generated method stub
		return null;
	}

}
