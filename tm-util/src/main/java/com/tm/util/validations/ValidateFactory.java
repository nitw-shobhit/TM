package com.tm.util.validations;

import com.tm.util.validations.validators.RequiredValidator;

public class ValidateFactory {
	
	
	private ValidateFactory() {
	}
	
	private static class ValidateFactoryHelper {
		
		private static final RequiredValidator requiredValidator = new RequiredValidator();
	}
	
	public static Object generateValidator(ValidateType vType) {
		if(vType.equals(ValidateType.REQUIRED)) {
			return ValidateFactoryHelper.requiredValidator;
		} else {
			return null;
		}
	}
}
