package com.comcast.lcs.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pavan vejju
 * @version 1.0
 * @description 
 * The CommonUtils class is to handle all utility methods
 */
 

public class CommonUtils {
	
	 public static Set<String> findLongestCommonSubstrings(Set<String> strings) {
	        if (strings == null || strings.isEmpty()) {
	            return new HashSet<>();
	        }

	        String firstString = strings.iterator().next();
	        int minLength = firstString.length();

	        for (String str : strings) {
	            minLength = Math.min(minLength, str.length());
	        }

	        int maxLength = 0;
	        Set<String> longestCommonSubstrings = new HashSet<>();

	        for (int i = 0; i < minLength; i++) {
	            for (int j = i + 1; j <= minLength; j++) {
	                String substring = firstString.substring(i, j);
	                if (isCommonSubstring(strings, substring)) {
	                    int length = substring.length();
	                    if (length > maxLength) {
	                        maxLength = length;
	                        longestCommonSubstrings.clear();
	                        longestCommonSubstrings.add(substring);
	                    } else if (length == maxLength) {
	                        longestCommonSubstrings.add(substring);
	                    }
	                }
	            }
	        }

	        return longestCommonSubstrings;
	    }
	 	public static Set<String> findLongestCommonSubstring(Set<String> strings) {
		 
		 Set<String> responseSet	=	new HashSet<>();
	        if (strings == null || strings.isEmpty()) {
	            return null;
	        }

	        String firstString = strings.iterator().next();
	        int maxLength = firstString.length();
	        String longestCommonSubstring = "";

	        for (int i = 0; i < maxLength; i++) {
	            for (int j = i + 1; j <= maxLength; j++) {
	                String substring = firstString.substring(i, j);
	                boolean allMatch = strings.stream().allMatch(str -> str.contains(substring));
	                if (allMatch && substring.length() > longestCommonSubstring.length()) {
	                    longestCommonSubstring = substring;
	                    responseSet.add(longestCommonSubstring);
	                }
	            }
	        }
	        return responseSet;
	    }

	    private static boolean isCommonSubstring(Set<String> strings, String substring) {
	        for (String str : strings) {
	            if (!str.contains(substring)) {
	                return false;
	            }
	        }
	        return true;
	    }

}
