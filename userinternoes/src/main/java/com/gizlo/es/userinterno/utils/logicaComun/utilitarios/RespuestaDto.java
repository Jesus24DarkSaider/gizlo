package com.gizlo.es.userinterno.utils.logicaComun.utilitarios;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO DEL TIPO DE RESPUESTA")
public class RespuestaDto {

	private String codigoRespuesta;

	private String descripcion;

	public RespuestaDto codigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
		return this;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public RespuestaDto descripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RespuestaDto respuestaType = (RespuestaDto) o;
		return Objects.equals(this.codigoRespuesta, respuestaType.codigoRespuesta)
				&& Objects.equals(this.descripcion, respuestaType.descripcion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoRespuesta, descripcion);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RespuestaType {\n");

		sb.append("    codigoRespuesta: ").append(toIndentedString(codigoRespuesta)).append("\n");
		sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
