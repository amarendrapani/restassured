package restassuredPratice;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetApiRequestTest {
	
	@Test
	public void getUserApi(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		 RequestSpecification request = RestAssured.given();
		 request.header("header","Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821");
		 Response response = request.get("/public/v2/users");
		 
		 //Status Code
		 int statusCode = response.statusCode();
		 System.out.println("status code : " + statusCode);
		 
		 //verification point
		 Assert.assertEquals(statusCode, 200);
		 
		 String statusMsj = response.statusLine();
		 System.out.println("status Message : " + statusMsj);
		 Assert.assertEquals(statusMsj, "HTTP/1.1 200 OK");
		 
		 //fetch the body in json format with preety print
		 String body = response.prettyPrint();
		 System.out.println(body);
		 
		 String contentType = response.header("content-Type");
		 System.out.println("The Content-Type is :" + contentType);
		 
		 System.out.println("----------------------------");
		 
		  List<Header> headers = response.headers().asList();
		  System.out.println(headers.size());
		  
		  for(Header h : headers) {
			  System.out.println(h.getName()+":"+h.getValue());
		  }
		 
		 
		 
		
	}

}
