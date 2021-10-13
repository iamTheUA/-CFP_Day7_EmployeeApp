package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;

public @Data class ResponseDTO {
	
	private String message;
	private Object data;

	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}	
}
