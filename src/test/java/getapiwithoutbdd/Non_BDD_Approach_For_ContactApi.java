package getapiwithoutbdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Non_BDD_Approach_For_ContactApi {
	
	@Test
	public void getProductsTest_1() {
		
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		 RequestSpecification request = RestAssured.given();
		 request.header("Authorization", "Bearer yhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzQyMTExYzFkNDUzYTAwMTMzNTBjYTQiLCJpYXQiOjE3MzIzOTIxMjV9.dtj2-qns3BdQn3Z0MG2uvWSGp1BSirD2DEGVME3VG5s");
		 Response response = request.get("/contactList");
		 
		 int status = response.statusCode();
		 System.out.println("Status Code : "+ status);
		 Assert.assertEquals(status, 200);
		 
		 String statusline = response.statusLine();
		 System.out.println("Status Line : " + statusline);
		 Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
