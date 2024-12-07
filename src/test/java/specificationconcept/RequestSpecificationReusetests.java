package specificationconcept;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;




public class RequestSpecificationReusetests {
	
	 RequestSpecification requestSpec;

	    @BeforeTest
	    public void setup() {
	        requestSpec = given().log().all()
	                .baseUri("https://gorest.co.in")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821");
	    }

	    @Test
	    public void getUserTest() {
	        requestSpec.when()
	                .get("/public/v2/users")
	                .then()
	                .statusCode(200);
	    }

	    @Test
	    public void getAUserTest() {
	        requestSpec.when()
	                .get("/public/v2/users/6352365")
	                .then()
	                .statusCode(200);
	    }

	    @Test
	    public void getWrongUserTest() {
	        requestSpec.when()
	                .get("/public/v2/users/1")
	                .then()
	                .statusCode(404);
	    }

}
