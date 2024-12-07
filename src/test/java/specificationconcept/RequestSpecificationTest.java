package specificationconcept;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;


public class RequestSpecificationTest {
	
	@Test
	public void reqSpecTest() {
		
		
		RequestSpecification requestSpec = given()
		.baseUri("https://jsonplaceholder.typicode.com")
		.header("Content-Type", "application/json");
		
		
		//1.
		requestSpec.
				when()
					.get()
						.then()
							.statusCode(200);
		
		
		//2.
		requestSpec.when().body("{\n"
		        + "  \"title\": \"foo\",\n"
		        + "  \"body\": \"bar\",\n"
		        + "  \"userId\": 1\n"
		        + "}")
		.when()
		.post("/posts")
		.then()
		.statusCode(201);
		
	}
	
	
	@Test
	public void getUserTest() {
	    RequestSpecification requestSpec = given().log().all()
	        .baseUri("https://gorest.co.in")
	        .header("Content-Type", "application/json")
	        .header("Authorization", "Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821");

	    requestSpec.when().log().all()
	        .get("/public/v2/users")
	        .then().log().all()
	        .statusCode(200);

	    requestSpec.when()
	        .get("/public/v2/users/7440218")
	        .then().log().all()
	        .statusCode(200);
	}

	@Test
	public void getUserTest_With_QueryParam() {
	    RequestSpecification requestSpec = given().log().all()
	        .baseUri("https://gorest.co.in")
	        .header("Content-Type", "application/json")
	        .header("Authorization", "Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
	        .queryParam("name", "Amarendra");

	    requestSpec.when()
	        .get("/public/v2/users")
	        .then()
	        .statusCode(200);
	}
	
	
	

}
