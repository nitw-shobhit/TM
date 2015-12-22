package com.tm.util.file;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.tm.util.exceptions.FileLoadException;

public class PropertyUtilsTest {

	private String testFileName;
	private String input;
	private String output;
	
	@Before
	public void setUp() {
		testFileName = "test.properties";
		input = "test.property";
		output = "The name is bond.. James Bond.";
	}

	@Test
	public void loadPropertiesTest() throws FileLoadException {
		Properties temp = PropertyUtils.loadProperties(testFileName);
		assertNotNull(temp);
		assertEquals(output, temp.getProperty(input));
	}
}
