package reqresspecificationusingbuilderpattern;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestResponseBuilderSpecification {
	
	static String accessToken;
	
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
	            .header("Authorization", "Bearer 0000000")
	            .when()
	            .get("/public/v2/users")
	            .then()
	            .assertThat()
	            .spec(get_res_spec_401_AuthFail());
	}
	
	public static RequestSpecification oAuth2ReqSpec() {
	    RequestSpecification requestOAuth2Spec = new RequestSpecBuilder()
	            .setBaseUri("https://test.api.amadeus.com")
	            .setContentType(ContentType.URLENC)
	            .addFormParam("grant_type", "client_credentials")
	            .addFormParam("client_id", "88888888888888888888")
	            .addFormParam("client_secret", "888888888888888888888")
	            .build();
	    return requestOAuth2Spec;
	}

	@BeforeMethod
	public void getAccessToken() {
	    Response response = given()
	            .spec(oAuth2ReqSpec())
	            .when()
	            .post("/v1/security/oauth2/token");
	    response.prettyPrint();
	    accessToken = response.jsonPath().getString("access_token");
	}

	public static RequestSpecification user_req_spec() {
	    RequestSpecification requestSpec = new RequestSpecBuilder()
	            .setBaseUri("https://gorest.co.in")
	            .setContentType(ContentType.JSON)
	            .addHeader("Authorization", "Bearer 888888888888888888888888888888888888")
	            .build();
	    return requestSpec;
	}

}
