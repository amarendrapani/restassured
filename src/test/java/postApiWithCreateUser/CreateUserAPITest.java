package postApiWithCreateUser;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUserAPITest {
	
	@Test
	public void getAuthTokenTest_With_jsonFile() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		Integer userid = given().log().all()
				.header("Authorization", "Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
		.contentType(ContentType.JSON)
		.body(new File("./src/test/resources/pojo/user.json"))
		.when().log().all()
		.post("/public/v2/users")
		.then().log().all()
		.assertThat()
		.statusCode(201)
		.extract()
		.path("id");
		
		System.out.print("user id :"  + userid);
		Assert.assertNotNull(userid);
			
	}

}
