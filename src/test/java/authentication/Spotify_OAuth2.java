package authentication;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Spotify_OAuth2 {
	
private String accessToken;
	
	@BeforeMethod
	public void getAccessToken() {
		RestAssured.baseURI = "https://accounts.spotify.com";
		
		Response response = RestAssured.given()
		.contentType(ContentType.URLENC)
		.formParam("grant_type", "client_credentials")
		.formParam("client_id", "*****")
		.formParam("client_secret", "*******")
		.when()
		.post("/api/token");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
		
		accessToken = response.jsonPath().getString("access_token");
	}
	
	@Test
	public void getflightDetailsTest_1() {
		Response response = RestAssured.given()
				.header("Authorization", "Bearer "+ accessToken)
				.when()
				.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uq7FjRGTy");

		
			Assert.assertEquals(response.getStatusCode(), 200);
			response.prettyPrint();
			
	}

}
