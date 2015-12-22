package com.tm.util.spring;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Before;
import org.junit.Test;

public class JsonUtilsTest {
	
	private String testJson;
	private TestBean testBean;
	
	@Before
	public void setUp() {
		testJson = "{\"testField1\":\"testValue1\",\"testField2\":\"testValue2\",\"testField3\":\"testValue3\",\"testField4\":\"testValue4\",\"testField5\":\"testValue5\"}";
		
		testBean = new TestBean();
		testBean.setTestField1("testValue1");
		testBean.setTestField2("testValue2");
		testBean.setTestField3("testValue3");
		testBean.setTestField4("testValue4");
		testBean.setTestField5("testValue5");
	}
	
	@Test
	public void toJsonTest() {
		String temp = JsonUtils.toJson(testBean);
		assertNotNull(temp);
		assertEquals(testJson, temp);
	}
	
	@Test
	public void toPojoTest() throws JsonParseException, JsonMappingException, IOException {
		TestBean temp = (TestBean) JsonUtils.toPojo(testJson, TestBean.class);
		assertNotNull(temp);
		assertEquals(testBean.getTestField1(), temp.getTestField1());
		assertEquals(testBean.getTestField2(), temp.getTestField2());
		assertEquals(testBean.getTestField3(), temp.getTestField3());
		assertEquals(testBean.getTestField4(), temp.getTestField4());
		assertEquals(testBean.getTestField5(), temp.getTestField5());
	}
}