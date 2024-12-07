package authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuth1 {
	
	// for handling the outh1 you need the consumer key, consumer token, access key, access token
	// then only you can able to handle OAuth1.
	
	
	//you need to add extra dependency to handle Outh1.0, in your pom.xml file 
	//name : scribejava-core
	//version: old version: 2.5.3
	
	public void flickApiTest() {
		 RestAssured.baseURI = "https://www.flickr.com";
		
		 Response response = RestAssured.given()
		.auth()
		.oauth("need to pass consumer key", "consumer token", "access key ", "access token")
		.queryParam("nojsoncallback", 1)
		.queryParam("format", "json")
		.queryParam("method", "licker.test.login")
			.when()
			.get("/services/rest")
			.then()
			.assertThat()
			.statusCode(200)
			.extract()
			.response();
		
		response.prettyPrint();
	
	}
	
}
