package com.tm.util.string;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class StringUtilsTest {
	
	private String input;
	private String output;
	private Map<String, String> params;

	@Before
	public void setUp() {
		input = "Your mouth is signing ${var1} your body cant ${var2}";
		output = "Your mouth is signing cheques your body cant cash";
		
		params = new HashMap<String, String>();
		params.put("var1", "cheques");
		params.put("var2", "cash");
	}
	
	@Test
	public void stringSubstitutorTest() {
    	String temp = StringUtils.stringSubstitutor(input, params);
    	assertNotNull(temp);
    	assertEquals(output, temp);
	}
}
