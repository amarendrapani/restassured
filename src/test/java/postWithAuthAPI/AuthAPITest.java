package postWithAuthAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojo.Credential;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthAPITest {
	
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
	
	//WIP
	@Test
	public void getAuthTokenTest_With_PojoClass() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Credential cred = new Credential("admin", "password123");
		
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
