package com.tm.util.assembler.impl;

import java.sql.Timestamp;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

@Dto
public class TestDTO {

	@DtoField
	private String testField1;
	
	@DtoField
	private int testField2;
	
	@DtoField
	private Timestamp testField3;
	
	@DtoField
	private boolean testField4;

	public String getTestField1() {
		return testField1;
	}
	public void setTestField1(String testField1) {
		this.testField1 = testField1;
	}
	public int getTestField2() {
		return testField2;
	}
	public void setTestField2(int testField2) {
		this.testField2 = testField2;
	}
	public Timestamp getTestField3() {
		return testField3;
	}
	public void setTestField3(Timestamp testField3) {
		this.testField3 = testField3;
	}
	public boolean isTestField4() {
		return testField4;
	}
	public void setTestField4(boolean testField4) {
		this.testField4 = testField4;
	}
}
