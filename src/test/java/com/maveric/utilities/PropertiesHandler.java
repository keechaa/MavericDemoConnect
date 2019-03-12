package com.maveric.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

	public static Properties getPropertiesDetails(String fileNamewithpath) throws IOException {

		FileInputStream fileIn = new FileInputStream(fileNamewithpath);

		// Object(memory) creation to load the file//
		Properties prop = new Properties();
		prop.load(fileIn);

		return prop;
	}

	public static String getValueForKey(String fileNamewithpath, String key) throws IOException {
		Properties prop = PropertiesHandler.getPropertiesDetails(fileNamewithpath);
		String value = prop.getProperty(key);
		return value;

		// or

		/*
		 * FileInputStream fileIn = new FileInputStream("fileNamewithpath"); Properties
		 * prop = new Properties(); prop.load(fileIn); Properties prop =
		 * PropertiesTest.getPropertiesDetails("Utilities/data.properties");
		 * 
		 * String value = prop.getProperty(key); return value;
		 */
	}
}
