package restassuredPratice;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GetApiWithBDDFormat {
	
	//BDD Style Test -- Given, When, Then
	
	
		@Test
		 public void getProductsTest_1() {
			 
			 RestAssured.baseURI = "https://fakestoreapi.com";
			 
			 given().log().all()
			 	.get("/products")
			 		.then().log().all()
			 			.assertThat()
			 				.statusCode(200);
			
		 }
		
		
		@Test 
		 public void getProductTest_2() {
			 
			 RestAssured.baseURI = "https://fakestoreapi.com";
			 
			 given().log().all()
			 	.when().log().all()
			 		.get("/products")
			 			.then().log().all()
			 				.assertThat()
			 					.statusCode(200)
			 						.and()
			 							.body("$.size()",equalTo(20));
			  
		 }
	
	
	
	

}
