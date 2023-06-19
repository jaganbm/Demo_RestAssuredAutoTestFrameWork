package com.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String uname() {
		
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		return ("Sam"+generatedString);
		
	}
	
public static String ujob() {
		
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		return ("Manager"+generatedString);
		
	}

}
