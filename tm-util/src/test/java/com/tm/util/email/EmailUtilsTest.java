package com.tm.util.email;

import static junit.framework.TestCase.assertEquals;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import com.tm.util.exceptions.EmailServiceFailureException;
import com.tm.util.exceptions.FileLoadException;


public class EmailUtilsTest {

	private String testTo;
	private String testSubject;
	
	@Before
	public void setUp() {
		testTo = "s.tyagi@ost.orcid.org";
		testSubject = "test";
	}
	
	@Test
	public void sendEmailTest() throws EmailServiceFailureException, FileLoadException, URISyntaxException {
		int response = EmailUtils.sendEmail(testTo, testSubject);
		assertEquals(200, response);
	}
}
