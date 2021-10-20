package com.gizlo.es.userexterno.controller.contract;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gizlo.es.userexterno.controller.dto.UserExternoDto;
import com.gizlo.es.userexterno.utils.logicaComun.utilitarios.RespuestaDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface IUserExternoController {

	// CAPACIDAD QUE SIRVE PARA CREAR EL USUARIO EXTERNO MEDIANTE UN POST
	@Operation(method = "crearUsuarioExterno", operationId = "crearUsuarioExterno", description = "Capacidad que se encarga de crear el usuario externo", tags = "UsuarioExternoEntityServiceV1", summary = "crearUsuarioExteno")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "OK", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDto.class))) })
	@PostMapping(value = "/api/es/users/externo/v1", produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "UsuarioType", required = true, content = @Content(schema = @Schema(implementation = UserExternoDto.class)))
	public ResponseEntity<Object> crearUsuarioExterno(
			@Valid @org.springframework.web.bind.annotation.RequestBody(required = true) UserExternoDto usuarioExternoDTO);

	// CAPACIDAD QUE SIRVE PARA LISTAR USUARIOS EXTERNO
	@Operation(method = "consultarUsuarioExternos", operationId = "consultarUsuariosExternos", description = "consultarUsuariosExternos", tags = "UsuarioExternoEntityServiceV1", summary = "consultarUsuariosExternos")
	@ApiResponses(value = {

			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserExternoDto.class)))),

			@ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "404", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDto.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDto.class)))

	})
	@GetMapping(value = "/api/es/users/externo/v1", produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> consultarUsuariosExternos();

}
