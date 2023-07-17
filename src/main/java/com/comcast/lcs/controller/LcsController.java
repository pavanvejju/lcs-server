package com.comcast.lcs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.comcast.lcs.dto.LcsRequestDto;
import com.comcast.lcs.dto.LcsResponseDto;
import com.comcast.lcs.service.LcsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author pavan vejju
 * @version 1.0
 * @description 
 * The LcsController is a REST controller that handles front-end requests
 * It provides an API endpoint to retrieve a the Information from bussiness layer
 *
 * @see LcsService
 */
 

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LcsController {
	
	private static final Logger logger = LoggerFactory.getLogger(LcsController.class);
	
	 /**
     * The LcsService to interact with the underlying business logic
     */
	
	@Autowired
	private LcsService lcsService;
	


	/**
     * calculate Longest Common Substring with the provided details.
     *
     * This method validates the user data and saves the user in the database
     * if it meets the required criteria.
     *
     * @param requestDto The LcsRequestDto object containing set Of Strings.
     * @return The LcsResponseDto object representing the commonSubstring value ( set of strings)
     */
	@RequestMapping(value = "lcs", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation("Create new something")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "New something successfully created"),
	        @ApiResponse(code = 400, message = "Bad request, adjust before retrying"),
	        @ApiResponse(code = 500, message = "Internal Server Error" ),
	        @ApiResponse(code = 0, message = "Processing completed successfully." ),
	        @ApiResponse(code = 1000, message = "Failure" ),
	        @ApiResponse(code = 1001, message = "Invalid Request" ),
	        @ApiResponse(code = 1002, message = "The format of the request was not acceptable. Please provide a non-empty set of strings." ),
	        @ApiResponse(code = 1003, message = "The format of the request was not acceptable." ),
	        @ApiResponse(code = 1004, message = "The \"setOfStrings\" must be a Set" ),
	        @ApiResponse(code = 1005, message = "\"setOfStrings\" must be a Set, and all strings should be unique." )
	})
	public LcsResponseDto calculateLcs(@RequestBody LcsRequestDto requestDto) {
		logger.debug("calculateLcs()  started");
		LcsResponseDto lcsResponseDto	=	new LcsResponseDto();
		try {
			lcsResponseDto = lcsService.calculateLcs(requestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Executed the calculateLcs Method");
		return lcsResponseDto;
	}

}
