package authentication;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class OAuth2ApiTest {
	
	private String accessToken;
	
	@BeforeMethod
	public void getAccessToken() {
		Response response = RestAssured.given()
		.contentType(ContentType.URLENC)
		.formParam("grant_type", "client_credentials")
		.formParam("client_id", "*****")
		.formParam("client_secret", "*******")
		.when()
		.post();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
		
		accessToken = response.jsonPath().getString("access_token");
	}
	
	@Test
	public void getflightDetailsTest_1() {
		Response response = RestAssured.given()
				.header("Authorization", "Bearer "+accessToken)
				.when()
				.get("https://test.api.amadeus.com/v1/shopping/flight-destinations?origin=PAR&maxprice=200");

		
			Assert.assertEquals(response.getStatusCode(), 200);
			response.prettyPrint();
			
	}
	
	
	@Test
	public void getflightDetailsTest_2() {
		Response response = RestAssured.given()
				.auth().oauth2(accessToken)
				.when()
				.get("https://test.api.amadeus.com/v1/shopping/flight-destinations?origin=PAR&maxprice=200");

		
			Assert.assertEquals(response.getStatusCode(), 200);
			response.prettyPrint();
			
	}
	
	
	
	
	

}
