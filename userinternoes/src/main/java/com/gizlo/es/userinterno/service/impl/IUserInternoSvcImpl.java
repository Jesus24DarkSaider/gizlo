package com.gizlo.es.userinterno.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gizlo.es.userinterno.controller.dto.UserInternoDto;
import com.gizlo.es.userinterno.repository.contract.IUserInternoRepository;
import com.gizlo.es.userinterno.repository.model.UserInterno;
import com.gizlo.es.userinterno.service.contract.IUserInternoSvc;
import com.gizlo.es.userinterno.utils.convert.UserInternoConvert;

@Service
public class IUserInternoSvcImpl implements IUserInternoSvc {

	@Autowired
	IUserInternoRepository userInternoRepository;

	@Override
	public UserInternoDto crearUsuarioInterno(@Valid UserInternoDto userInternoDto) {
		UserInterno usuarioInterno;
		usuarioInterno = UserInternoConvert.convertTypeToModel(userInternoDto);
		usuarioInterno.setId(null);
		return UserInternoConvert.convertModelToType(userInternoRepository.save(usuarioInterno));
	}

	@Override
	public List<UserInternoDto> consultarUsuariosInternos() {
		List<UserInterno> listadoUsuariosExternos = userInternoRepository.findAll();
		return UserInternoConvert.convertlistModelToDto(listadoUsuariosExternos);
	}

}
