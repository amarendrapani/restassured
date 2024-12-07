package specificationconcept;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.expect;

import static org.hamcrest.Matchers.*;

import io.restassured.specification.ResponseSpecification;



public class ResponseSpecificationTest {
	
	public void reqSpecTest() {
		ResponseSpecification resSpec  = expect()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("userId", equalTo(1));
		
		
		given()
        	.baseUri("https://jsonplaceholder.typicode.com")
        		.when()
        			.get("/posts/1")
        				.then()
        					.spec(resSpec);
	
	
	}

}