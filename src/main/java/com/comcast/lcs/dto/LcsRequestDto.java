package com.comcast.lcs.dto;

import java.io.Serializable;
import java.util.Set;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author pavan vejju
 * @version 1.0
 * @description 
 * LcsRequestDto DTO (Data Transfer Object) classes is to transfer data between front-end and back-end, or between different microservices in a distributed architecture 
 * DTOs are designed to carry data and are typically simple classes containing fields and getters/setters.
 * This class is used for get data as a request from front-end
 * *   
 *    sample input request: {
		"setOfStrings": [
		{"value": "comcast"},
		{"value": "communicate"},
		{"value": "commutation"}
		]
		}
 **/

@Component
@Data
public class LcsRequestDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<String> setOfStrings;

}
