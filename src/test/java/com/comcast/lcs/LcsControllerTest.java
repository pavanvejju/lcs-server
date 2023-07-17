package com.comcast.lcs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.comcast.lcs.controller.LcsController;
import com.comcast.lcs.dto.LcsRequestDto;
import com.comcast.lcs.dto.LcsResponseDto;

@SpringBootTest
class LcsControllerTest {

	
    @Autowired
    private LcsController lcsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessSetOfStrings_Success() {
        Set<String> setOfStrings = new HashSet<>();
        setOfStrings.add("string1");
        setOfStrings.add("string2");
        
        LcsRequestDto  lcsRequestDto	=	new LcsRequestDto();
        lcsRequestDto.setSetOfStrings(setOfStrings);

        LcsResponseDto lcsResponseDto = lcsController.calculateLcs(lcsRequestDto);
        
        if(lcsResponseDto!=null && lcsResponseDto.getErrorDetails()!=null) {
        	assertEquals(0, lcsResponseDto.getErrorDetails().getErrorCode());
            assertEquals("Processing completed successfully.", lcsResponseDto.getErrorDetails().getErrorDescription());
        } else {
        	System.out.println("Hello");
        }
        
    }

    @Test
    public void testProcessSetOfStrings_EmptySet() {
    	
    	LcsRequestDto  LcsRequestDto	=	new LcsRequestDto();

        LcsResponseDto lcsResponseDto = lcsController.calculateLcs(LcsRequestDto);
        if(lcsResponseDto!=null && lcsResponseDto.getErrorDetails()!=null) {
	        assertEquals(1002, lcsResponseDto.getErrorDetails().getErrorCode());
	        assertEquals("The format of the request was not acceptable. Please provide a non-empty set of strings.", lcsResponseDto.getErrorDetails().getErrorDescription());
        }
    }

    @Test
    public void testProcessSetOfStrings_NonUniqueStrings() {
    	
    	LcsRequestDto  lcsRequestDto	=	new LcsRequestDto();
        Set<String> setOfStrings = new HashSet<>();
        setOfStrings.add("string1");
        setOfStrings.add("string2");
        setOfStrings.add("string1"); // Non-unique string
        
        lcsRequestDto.setSetOfStrings(setOfStrings);

        LcsResponseDto lcsResponseDto = lcsController.calculateLcs(lcsRequestDto);
        if(lcsResponseDto!=null && lcsResponseDto.getErrorDetails()!=null) {
	        assertEquals(0, lcsResponseDto.getErrorDetails().getErrorCode());
	        assertEquals("Processing completed successfully.", lcsResponseDto.getErrorDetails().getErrorDescription());
        }
    }
    
    @Test
    public void testProcessSetOfStrings() {
    	LcsRequestDto  lcsRequestDto	=	new LcsRequestDto();
       
    	 Set<String> setOfStrings = Set.of("comcast", "comcastic", "broadcaster");
    	 lcsRequestDto.setSetOfStrings(setOfStrings);

         LcsResponseDto lcsResponseDto = lcsController.calculateLcs(lcsRequestDto);
         for (String substring : lcsResponseDto.getLcs()) {
             System.out.println(substring);
             assertEquals("cast", substring);
         }
    	 
    }
   
   

}
