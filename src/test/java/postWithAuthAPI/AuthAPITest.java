package postWithAuthAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojo.Credential;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthAPITest {
	
	
	// This approach is not recommended , but for praticing am explaing this for better understanding .
	@Test
	public void getAuthTokenTest() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		String tokenId = given().log().all()
		.contentType(ContentType.JSON)
		.body("{\n"
				+ "    \"username\" : \"admin\",\n"
				+ "    \"password\" : \"password123\"\n"
				+ "}")
		.when().log().all()
		.post("/auth")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.extract()
		.path("token");
		
		System.out.print("Token id ==>"  + tokenId);
		Assert.assertNotNull(tokenId);
			
	}
	
	
	
	// this approach we can use only when we have fixed json payload not dynamic payload
	@Test
	public void getAuthTokenTest_With_jsonFile() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		String tokenId = given().log().all()
		.contentType(ContentType.JSON)
		.body(new File("./src/test/resources/pojo/auth.json"))
		.when().log().all()
		.post("/auth")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.extract()
		.path("token");
		
		System.out.print("Token id ==>"  + tokenId);
		Assert.assertNotNull(tokenId);
			
	}
	
	// if we have dynamic payload then we can use this process.
	//pojo to json === serialization.
	//json to pojo === de serialization.
	// jackson-databind library required for it. 
	@Test
	public void getAuthTokenTest_With_PojoClass() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Credential cred = new Credential("admin","password123");
		
		String tokenId = given().log().all()
		.contentType(ContentType.JSON)
		.body(cred)// pojo to json : serialization : Object Mapper
		.when().log().all()
		.post("/auth")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.extract()
		.path("token");
		
		System.out.print("Token id ==>"  + tokenId);
		Assert.assertNotNull(tokenId);
		
		//json -->pojo : Deserialization
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
