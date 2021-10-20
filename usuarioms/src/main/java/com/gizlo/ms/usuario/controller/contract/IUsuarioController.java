package com.gizlo.ms.usuario.controller.contract;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gizlo.ms.usuario.controller.dto.USERTYPE;
import com.gizlo.ms.usuario.controller.dto.UsuarioExternoDto;
import com.gizlo.ms.usuario.controller.dto.UsuarioInternoDto;
import com.gizlo.ms.usuario.utils.logicaComun.utilitarios.RespuestaDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface IUsuarioController {

	@Operation(method = "consultarUsuariosPorTipo", operationId = "consultarUsuariosPorTipo", description = "consultarUsuariosPorTipo", tags = "UsuarioMSV1", summary = "consultarUsuariosPorTipo")
	@ApiResponses(value = {

			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Object.class)))),

			@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "404", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDto.class)))

	})
	@GetMapping(value = "/api/ms/users/tipo/v1/{tipoUsuario}", produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> consultarUsuariosPorTipo(
			@Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("tipoUsuario") USERTYPE tipo);

	@Operation(method = "crearUsuarioExterno", operationId = "crearUsuarioExterno", description = "Capacidad que se encarga de crear el usuario externo", tags = "UsuarioMSV1", summary = "crearUsuarioExteno")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "OK", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDto.class))) })
	@PostMapping(value = "/api/ms/users/externo/v1", produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "UsuarioType", required = true, content = @Content(schema = @Schema(implementation = UsuarioExternoDto.class)))
	public ResponseEntity<Object> crearUsuarioExterno(
			@Valid @org.springframework.web.bind.annotation.RequestBody(required = true) UsuarioExternoDto usuarioExternoDTO);

	// CAPACIDAD QUE SIRVE PARA CREAR EL USUARIO EXTERNO MEDIANTE UN POST
	@Operation(method = "crearUsuarioInterno", operationId = "crearUsuarioInterno", description = "Capacidad que se encarga de crear el usuario interno", tags = "UsuarioMSV1", summary = "crearUsuarioInterno")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "OK", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDto.class))) })
	@PostMapping(value = "/api/ms/users/interno/v1", produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Modelo Canonico de Usuario Interno", required = true, content = @Content(schema = @Schema(implementation = UsuarioInternoDto.class)))
	public ResponseEntity<Object> crearUsuarioInterno(
			@Valid @org.springframework.web.bind.annotation.RequestBody(required = true) UsuarioInternoDto userInternoDtof);

}
