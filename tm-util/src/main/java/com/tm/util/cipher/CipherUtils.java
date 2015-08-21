package com.tm.util.cipher;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.tm.util.exceptions.CipherException;
import com.tm.util.exceptions.FileLoadException;
import com.tm.util.file.PropertyUtils;

@SuppressWarnings("restriction")
public class CipherUtils {
	
	public static final String DEFAULT_ENCODING="UTF-8";
	
	private static BASE64Encoder enc=new BASE64Encoder();
	private static BASE64Decoder dec=new BASE64Decoder();

	public static String encrypt(String strToEncrypt) throws FileLoadException, CipherException {
		String key = PropertyUtils.loadProperties("app-config.properties").getProperty("encryption.key");
		String encrypted = null;
		try {
			strToEncrypt = xorMessage(strToEncrypt, key);
			encrypted = base64encode(strToEncrypt);
		} catch(Exception e) {
			throw new CipherException("Encryption failed", e);
		}
		return encrypted;
	}
	
	public static String decrypt(String strToDecrypt) throws FileLoadException, CipherException {
		String key = PropertyUtils.loadProperties("app-config.properties").getProperty("encryption.key");
		String decrypted = null;
		try {
			strToDecrypt = base64decode(strToDecrypt);
			decrypted = xorMessage(strToDecrypt, key);
		} catch(Exception e) {
			throw new CipherException("Decryption failed", e);
		}
		
		return decrypted;
	}
	
	private static String base64encode(String text) throws UnsupportedEncodingException {
		return enc.encode(text.getBytes(DEFAULT_ENCODING));
	}

	private static String base64decode(String text) throws UnsupportedEncodingException, IOException {
		return new String(dec.decodeBuffer(text), DEFAULT_ENCODING);
	}
	
	private static String xorMessage(String message, String key) {
		if (message == null || key == null)
			return null;
		char[] keys = key.toCharArray();
		char[] mesg = message.toCharArray();
		int ml = mesg.length;
		int kl = keys.length;
		char[] newmsg = new char[ml];
		for (int i = 0; i < ml; i++) {
			newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
		}
		mesg = null;
		keys = null;
		return new String(newmsg);
	}
}
