package com.comcast.lcs.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.comcast.lcs.controller.LcsController;
import com.comcast.lcs.dto.ErrorDetails;
import com.comcast.lcs.dto.LcsRequestDto;
import com.comcast.lcs.dto.LcsResponseDto;
import com.comcast.lcs.util.CommonUtils;

/**
 * @author pavan vejju
 * @version 1.0
 * @description 
 * The LcsService class provides operations related to calculate Longest Common Substring
 * It acts as an intermediary between the data access and the presentation layer (e.g., LcsController).
 *
 * @see LcsController
 */
 

@Service
public class LcsService {
	
	
	@Autowired
	private Environment env;
	private static final Logger logger = LoggerFactory.getLogger(LcsService.class);
	
	
	/**
     * calculate Longest Common Substring with the provided details.
     *
     * This method validates the user data and saves the user in the database
     * if it meets the required criteria.
     *
     * @param requestDto The LcsRequestDto object containing set Of Strings.
     * @return The LcsResponseDto object representing the commonSubstring value ( set of strings)
     */
	
	public LcsResponseDto calculateLcs(LcsRequestDto requestDto) throws Exception {
		
		LcsResponseDto	responseDto	=	new LcsResponseDto();
		ErrorDetails errorDetails	=	new ErrorDetails();
		try {
		
		Set<String> setOfStrings	=	requestDto.getSetOfStrings();
		
		// Check if the request body is empty or not in the correct format
        if (setOfStrings == null || setOfStrings.isEmpty()) {
        	errorDetails.setErrorCode(1002);
        	errorDetails.setErrorDescription(env.getProperty("1002"));
        	responseDto.setErrorDetails(errorDetails);
            return responseDto;
        }
        // Check if the setOfStrings is not a set (i.e., all strings are not unique)
        if (setOfStrings.size() != new HashSet<String>(setOfStrings).size()) {
            errorDetails.setErrorCode(1005);
        	errorDetails.setErrorDescription(env.getProperty("1005"));
        	responseDto.setErrorDetails(errorDetails);
            return responseDto;
        }
        
		
		Set<String> setOfStringsResponse	=	CommonUtils.findLongestCommonSubstrings(setOfStrings);
		
		if(setOfStringsResponse==null) {
			errorDetails.setErrorCode(1002);
			errorDetails.setErrorDescription(env.getProperty("1002"));
		}
		logger.info("setOfStringsResponse:::::"+setOfStringsResponse);
		responseDto.setLcs(setOfStringsResponse);
		errorDetails.setErrorCode(0);
		errorDetails.setErrorDescription(env.getProperty("0"));
		
		responseDto.setErrorDetails(errorDetails);

		} catch (Exception e) {
			errorDetails.setErrorCode(1000);
			errorDetails.setErrorDescription(env.getProperty("1000"));
			e.printStackTrace();
		}
		return responseDto;
	}

}
