package restassuredPratice;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetApiRequestQueryParameter {
	
	@Test
	public void getApiRequestUsungQueryParameter() {
		 RestAssured.baseURI = "https://gorest.co.in";
		 RequestSpecification request = RestAssured.given();
		 request.queryParam("name", "naveen");
		 request.queryParam("status", "active");
		 
		 request.header("header","Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821");
		 Response response = request.get("/public/v2/users");
		 
		 
		 int statuscode = response.statusCode();
		 System.out.println("Status Code : "+ statuscode);
		 Assert.assertEquals(statuscode, 200);
		 
		 String statusmessage = response.statusLine();
		 System.out.println("Status Message : " + statusmessage);
		 Assert.assertEquals(statusmessage, "HTTP/1.1 200 OK");
		 
		 response.prettyPrint();
		 
	}


	@Test
	public void getApiRequestQueryparameterusingHashMap(){
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given();
		
		
		Map<String, String>queryparameters = new HashMap<String, String>();
		queryparameters.put("nmae", "naveen");
		queryparameters.put("status", "active");
		
		request.queryParams(queryparameters);
		
		request.header("header","Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821");
		 Response response = request.get("/public/v2/users");
		 
		 
		 int statuscode = response.statusCode();
		 System.out.println("Status Code : "+ statuscode);
		 Assert.assertEquals(statuscode, 200);
		 
		 String statusmessage = response.statusLine();
		 System.out.println("Status Message : " + statusmessage);
		 Assert.assertEquals(statusmessage, "HTTP/1.1 200 OK");
		 
		 response.prettyPrint();
		
	}
	
}
