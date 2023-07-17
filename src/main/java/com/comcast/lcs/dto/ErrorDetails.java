package com.comcast.lcs.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ErrorDetails{

	private Integer errorCode;

	private String errorDescription;
}
