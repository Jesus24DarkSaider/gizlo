package com.gizlo.ms.usuario.controller.dto;

import java.util.HashMap;
import java.util.Map;

import com.gizlo.ms.usuario.utils.patronCommand.IParameter;

// MAP QUE VOY A USAR A LO LARGO DE LA IMPLEMENTACION DEL SERVICE
public class MapParam implements IParameter {

	private Map<String, String> values = new HashMap<String, String>();

	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}

	public MapParam addValue(String key, String values) {
		this.values.put(key, values);
		return this;
	}

}
