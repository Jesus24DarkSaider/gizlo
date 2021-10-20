package com.gizlo.es.userinterno.controller.contract;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gizlo.es.userinterno.controller.dto.UserInternoDto;
import com.gizlo.es.userinterno.utils.logicaComun.utilitarios.RespuestaDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface IUserInternoController {

	// CAPACIDAD QUE SIRVE PARA CREAR EL USUARIO EXTERNO MEDIANTE UN POST
	@Operation(method = "crearUsuarioInterno", operationId = "crearUsuarioInterno", description = "Capacidad que se encarga de crear el usuario interno", tags = "UsuarioInternoEntityServiceV1", summary = "crearUsuarioInterno")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "OK", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDto.class))) })
	@PostMapping(value = "/api/es/users/interno/v1", produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Modelo Canonico de Usuario Interno", required = true, content = @Content(schema = @Schema(implementation = UserInternoDto.class)))
	public ResponseEntity<Object> crearUsuarioInterno(
			@Valid @org.springframework.web.bind.annotation.RequestBody(required = true) UserInternoDto userInternoDtof);

	// CAPACIDAD QUE SIRVE PARA LISTAR USUARIOS INTERNOS
	@Operation(method = "consultarUsuariosInternos", operationId = "consultarUsuariosInternos", description = "consultarUsuariosInternos", tags = "UsuarioInternoEntityServiceV1", summary = "consultarUsuariosInternos")
	@ApiResponses(value = {

			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserInternoDto.class)))),

			@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "404", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDto.class)))

	})
	@GetMapping(value = "/api/es/users/interno/v1", produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> consultarUsuariosInternos();

}
