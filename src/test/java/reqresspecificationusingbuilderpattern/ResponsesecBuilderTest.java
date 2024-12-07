package reqresspecificationusingbuilderpattern;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class ResponsesecBuilderTest {
	
	
	public static ResponseSpecification get_res_spec_200OK() {
	    ResponseSpecification responseSpec = new ResponseSpecBuilder()
	            .expectContentType(ContentType.JSON)
	            .expectStatusCode(200)
	            .expectHeader("Server", "cloudflare")
	            .build();
	    return responseSpec;
	}

	public static ResponseSpecification get_res_spec_401_AuthFail() {
	    ResponseSpecification responseSpec = new ResponseSpecBuilder()
	            .expectStatusCode(401)
	            .expectHeader("Server", "cloudflare")
	            .build();
	    return responseSpec;
	}

	@Test
	public void getUsersTest() {
	    RestAssured.baseURI = "https://gorest.co.in";
	    given()
	            .header("Authorization", "Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
	            .when()
	            .get("/public/v2/users")
	            .then()
	            .assertThat()
	            .spec(get_res_spec_200OK());
	}

	@Test
	public void getUsers_WithInvalidToken_Test() {
	    RestAssured.baseURI = "https://gorest.co.in";
	    given()
	            .header("Authorization", "Bearer 000000")
	            .when()
	            .get("/public/v2/users")
	            .then()
	            .assertThat()
	            .spec(get_res_spec_401_AuthFail());
	}

}
