package com.tm.util.validations;

import java.util.Map.Entry;
import java.util.Properties;

import com.tm.util.validations.beans.Errors;


public class Validate {

	public static Errors validate(Properties properties, Object beanToValidate) {
		Errors errors = new Errors();
		for(Entry<Object, Object> entry : properties.entrySet()) {
			
		}
		
		return errors;
	}
}
