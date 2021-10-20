package com.gizlo.es.userinterno.utils.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gizlo.es.userinterno.controller.dto.UserInternoDto;
import com.gizlo.es.userinterno.repository.model.UserInterno;

public class UserInternoConvert {

	private static Logger LOGGER = LoggerFactory.getLogger(UserInternoConvert.class);

	private static ObjectMapper mapperJson = new ObjectMapper();

	public static UserInternoDto convertModelToType(UserInterno usuario) {
		LOGGER.info("USUARIO INTERNO CONVERTIDO A DTO");
		try {
			mapperJson.configure(SerializationFeature.INDENT_OUTPUT, true);
			LOGGER.info(mapperJson.writeValueAsString(usuario));
		} catch (JsonProcessingException e) {
			LOGGER.error(e.toString());
		}
		return new ModelMapper().map(usuario, UserInternoDto.class);
	}

	public static UserInterno convertTypeToModel(UserInternoDto usuario) {
		LOGGER.info("USUARIO INTERNO CONVERTIDO A MODELO");
		try {
			mapperJson.configure(SerializationFeature.INDENT_OUTPUT, true);
			LOGGER.info(mapperJson.writeValueAsString(usuario));
		} catch (JsonProcessingException e) {
			LOGGER.error(e.toString());
		}
		return new ModelMapper().map(usuario, UserInterno.class);
	}

	public static List<UserInternoDto> convertlistModelToDto(List<UserInterno> listado) {
		return listado.stream().map(usuarios -> (convertModelToType(usuarios))).collect(Collectors.toList());
	}

}
