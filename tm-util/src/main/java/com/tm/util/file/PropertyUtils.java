package com.tm.util.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.tm.util.exceptions.FileLoadException;

public class PropertyUtils {

	public static Properties loadProperties(String fileName) throws FileLoadException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
			InputStream resourceStream = loader.getResourceAsStream(fileName);
			try {
				properties.load(resourceStream);
			} catch (IOException e) {
				throw new FileLoadException("File '"+fileName+"' could not be loaded", e);
			}
		
		return properties;
	}
}
