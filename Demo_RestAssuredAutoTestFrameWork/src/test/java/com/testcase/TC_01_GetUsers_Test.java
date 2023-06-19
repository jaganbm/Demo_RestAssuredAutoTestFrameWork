package com.testcase;

import org.apache.xmlbeans.impl.repackage.Repackage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_01_GetUsers_Test extends TestBase {
	
	@BeforeClass
	public void getAllUsers() throws InterruptedException {
		
		logger.info("*******Started TC01_GetUsers_Test********");
		
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest=RestAssured.given();
		response = httpRequest.request(Method.GET,"/users");
			
	}
	
	@AfterClass
	
	void tearDown() {
		
		logger.info("******TC01_GetUsers_Test Execution Completed ******");
	}
	
	@Test
	public void testResponseBody() {
		
		logger.info("**checking response body****");
		String responseBody=response.getBody().asString();
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	public void testStatusCode() {
		
		logger.info("**checking test Status Code****");
		
		int statusCode=response.getStatusCode();
		logger.info("Status Code is :"+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void testResponseTime() {
		
		logger.info("**checking test Response Time****");
		
		long responseTime=response.getTime();
		logger.info("Response Time is :"+responseTime);
		
		if (responseTime>1000) {
			logger.warn("Response Time is greater than 2000");
			Assert.assertTrue(responseTime<1000);
		}
	}
	
	@Test
	public void testStatusLine() {
		
		logger.info("**checking test Status Line****");
		
		String statusline= response.getStatusLine();
		logger.info("Status Line is :"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}

}
