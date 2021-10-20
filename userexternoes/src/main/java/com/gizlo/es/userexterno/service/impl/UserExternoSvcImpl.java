package com.gizlo.es.userexterno.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gizlo.es.userexterno.controller.dto.UserExternoDto;
import com.gizlo.es.userexterno.repository.contract.IUserExternoRepository;
import com.gizlo.es.userexterno.repository.model.UserExterno;
import com.gizlo.es.userexterno.service.contract.IUserExternoSvc;
import com.gizlo.es.userexterno.utils.convert.UserExternoConvert;
import com.gizlo.es.userexterno.utils.logicaComun.exception.BusinessException;

@Service
public class UserExternoSvcImpl implements IUserExternoSvc {

	@Autowired
	IUserExternoRepository userRepository;

	@Override
	public UserExternoDto crearUsuarioExterno(@Valid UserExternoDto usuarioExternoDTO) throws BusinessException {
		UserExterno usuario;
		usuario = UserExternoConvert.convertTypeToModel(usuarioExternoDTO);
		usuario.setId(null);
		return UserExternoConvert.convertModelToType(userRepository.save(usuario));
	}

	@Override
	public List<UserExternoDto> listarUsuariosExternos()
			throws BusinessException {
		List<UserExterno> listadoUsuariosExternos = userRepository.findAll();
		return UserExternoConvert.convertlistModelToDto(listadoUsuariosExternos);
	}

}
