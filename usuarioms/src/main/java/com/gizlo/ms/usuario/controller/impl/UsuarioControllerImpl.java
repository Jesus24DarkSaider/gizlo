package com.gizlo.ms.usuario.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.gizlo.ms.usuario.controller.contract.IUsuarioController;
import com.gizlo.ms.usuario.controller.dto.USERTYPE;
import com.gizlo.ms.usuario.controller.dto.UsuarioExternoDto;
import com.gizlo.ms.usuario.controller.dto.UsuarioInternoDto;
import com.gizlo.ms.usuario.service.contract.IUsuarioSvc;

public class UsuarioControllerImpl implements IUsuarioController {

	@Autowired
	IUsuarioSvc usuarioServicio;

	@Override
	public ResponseEntity<Object> consultarUsuariosPorTipo(USERTYPE tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> crearUsuarioExterno(@Valid UsuarioExternoDto usuarioExternoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> crearUsuarioExterno(@Valid UsuarioInternoDto userInternoDtof) {
		// TODO Auto-generated method stub
		return null;
	}

}
