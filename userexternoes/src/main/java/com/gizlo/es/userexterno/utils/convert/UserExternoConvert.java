package com.gizlo.es.userexterno.utils.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gizlo.es.userexterno.controller.dto.UserExternoDto;
import com.gizlo.es.userexterno.repository.model.UserExterno;

public class UserExternoConvert {

	private static Logger LOGGER = LoggerFactory.getLogger(UserExternoConvert.class);

	private static ObjectMapper mapperJson = new ObjectMapper();

	public static UserExternoDto convertModelToType(UserExterno usuario) {
		LOGGER.info("CONVERTIDO A DTO");
		try {
			mapperJson.configure(SerializationFeature.INDENT_OUTPUT, true);
			LOGGER.info(mapperJson.writeValueAsString(usuario));
		} catch (JsonProcessingException e) {
			LOGGER.error(e.toString());
		}
		return new ModelMapper().map(usuario, UserExternoDto.class);
	}

	public static UserExterno convertTypeToModel(UserExternoDto usuario) {
		LOGGER.info("CONVERTIDO A MODELO");
		try {
			mapperJson.configure(SerializationFeature.INDENT_OUTPUT, true);
			LOGGER.info(mapperJson.writeValueAsString(usuario));
		} catch (JsonProcessingException e) {
			LOGGER.error(e.toString());
		}
		return new ModelMapper().map(usuario, UserExterno.class);
	}

	public static List<UserExternoDto> convertlistModelToDto(List<UserExterno> listado) {
		return listado.stream().map(usuarios -> 
		(convertModelToType(usuarios))).collect(Collectors.toList());
	}

}
