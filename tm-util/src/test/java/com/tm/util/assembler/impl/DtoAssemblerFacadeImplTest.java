package com.tm.util.assembler.impl;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.tm.util.exceptions.DtoConversionException;

public class DtoAssemblerFacadeImplTest extends DtoAssemblerFacadeImpl<TestEntity, TestDTO>   {
	
	private TestEntity testEntity;
	
	private TestDTO testDTO;
	
	@Before
	public void setUp() throws Exception {
		testEntity = new TestEntity();
		testEntity.setTestField1("Test Entity 1");
		testEntity.setTestField2(1);
		testEntity.setTestField3(new Timestamp(new Date().getTime()));
		testEntity.setTestField4(true);

		testDTO = new TestDTO();
		
		testDTO.setTestField1("Test DTO 1");
		testDTO.setTestField2(2);
		testDTO.setTestField3(new Timestamp(new Date().getTime()));
		testDTO.setTestField4(false);
	}
	
	@Test
	public void toBeanTest() throws DtoConversionException {
		TestDTO temp = toBean(testEntity);
		
		assertNotNull(temp);
		assertEquals(testEntity.getTestField1(), temp.getTestField1());
		assertEquals(testEntity.getTestField2(), temp.getTestField2());
		assertEquals(testEntity.getTestField3(), temp.getTestField3());
		assertEquals(testEntity.isTestField4(), temp.isTestField4());
	}
	
	@Test
	public void toEntityTest() throws DtoConversionException {
		TestEntity temp = toEntity(testDTO);
		
		assertNotNull(temp);
		assertEquals(testDTO.getTestField1(), temp.getTestField1());
		assertEquals(testDTO.getTestField2(), temp.getTestField2());
		assertEquals(testDTO.getTestField3(), temp.getTestField3());
		assertEquals(testDTO.isTestField4(), temp.isTestField4());
	}
}
