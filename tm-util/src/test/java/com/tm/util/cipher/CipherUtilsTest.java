package com.tm.util.cipher;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNotSame;

import org.junit.Before;
import org.junit.Test;

import com.tm.util.exceptions.CipherException;
import com.tm.util.exceptions.FileLoadException;

public class CipherUtilsTest {
	
	private String input;
	
	@Before
	public void setUp() {
		input = "Test String To Encrypt";
	}
	
	@Test
	public void encryptAndDecryptTest() throws FileLoadException, CipherException {
		
		String temp1 = CipherUtils.encrypt(input);
		assertNotNull(temp1);
		assertNotSame(input, temp1);
		
		String temp2 = CipherUtils.decrypt(temp1);
		assertNotNull(temp2);
		assertEquals(input, temp2);
	}
}
