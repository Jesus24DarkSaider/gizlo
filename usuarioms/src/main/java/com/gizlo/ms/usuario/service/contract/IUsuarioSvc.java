/**
 * 
 */
package com.gizlo.ms.usuario.service.contract;

import javax.validation.Valid;

import com.gizlo.ms.usuario.controller.dto.USERTYPE;
import com.gizlo.ms.usuario.controller.dto.UsuarioExternoDto;
import com.gizlo.ms.usuario.controller.dto.UsuarioInternoDto;
import com.gizlo.ms.usuario.utils.logicaComun.exception.BusinessException;
import com.gizlo.ms.usuario.utils.logicaComun.utilitarios.RespuestaDto;

/**
 * @author JESUS
 *
 */
public interface IUsuarioSvc {

	Object consultarUsuariosPorTipo(USERTYPE tipo) throws BusinessException;

	RespuestaDto crearUsuarioExterno(@Valid UsuarioExternoDto usuarioExternoDTO) throws BusinessException;

	RespuestaDto crearUsuarioInterno(@Valid UsuarioInternoDto userInternoDto) throws BusinessException;

}
