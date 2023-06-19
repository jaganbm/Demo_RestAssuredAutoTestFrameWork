package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_02_GetSingleUserDetails extends TestBase {
	
	public class TC01_GetUser_Test extends TestBase {
		
		@BeforeClass
		public void getSelectedUser() throws InterruptedException {
			
			logger.info("*******Started get Selecte dUser********");
			
			RestAssured.baseURI="https://reqres.in/api";
			httpRequest=RestAssured.given();
			response = httpRequest.request(Method.GET,"/users/2");
				
		}
		
		@AfterClass
		
		void tearDown() {
			
			logger.info("******TC01_GetUsers_Test Execution Completed ******");
		}
		
		@Test
		public void testResponseBody() {
			
			logger.info("**checking response body****");
			String responseBody=response.getBody().asString();
			Assert.assertEquals(responseBody.contains(first_name),true);
		}
		
		@Test
		public void testStatusCode() {
			
			logger.info("**checking test Status Code****");
			
			int statusCode=response.getStatusCode();
			logger.info("Status Code is :"+statusCode);
			Assert.assertEquals(statusCode, 200);
		}
		
		@Test(enabled = false)
		public void testResponseTime() {
			
			logger.info("**checking test Response Time****");
			
			long responseTime=response.getTime();
			logger.info("Response Time is :"+responseTime);
			
			if (responseTime>2000) {
				logger.warn("Response Time is greater than 2000");
				Assert.assertTrue(responseTime<2000);
			}
		}
		
		@Test
		public void testStatusLine() {
			
			logger.info("**checking test Status Line****");
			
			String statusline= response.getStatusLine();
			logger.info("Status Line is :"+statusline);
			Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		}
		
		@Test
		public void testContentType() {
			
			logger.info("**checking Content Type****");
			
			String contentType= response.header("Content-Type");
			Assert.assertEquals(contentType, "application/json; charset=utf-8");
		}
		
		@Test
		public void testServerType() {
			
			logger.info("**checking ServerType****");
			
			String serverType= response.header("Server");
			Assert.assertEquals(serverType, serType);
		}

	}


}
