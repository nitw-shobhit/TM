package com.tm.util.string;

import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;

public class StringUtils {

	public static String stringSubstitutor(String inputString, Map<String, String> params) {
    	if(params == null) {
    		return inputString;
    	}
    	StrSubstitutor sub = new StrSubstitutor(params);
    	return sub.replace(inputString);
	}
}
