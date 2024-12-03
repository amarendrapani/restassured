package postApiWithCreateUser;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.User;

public class UpdateUserWithPojo {
	
	public String getrandomMailid() {
		return  "AutomationApi"+ System.currentTimeMillis()+"@gmail.com";
	}
	
	// Create a user
	//Update the user
	
	//1.postcall : creeate a user
	@Test 
	public void updateTheUserWith_Pojoclass() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		User user = new User("Amarendra",getrandomMailid(), "male", "active");
		
		Response userresponse = given().log().all()
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
		.body(user)
		.when().log().all()
		.post("/public/v2/users");
		
		 userresponse.prettyPrint();
		 JsonPath js = userresponse.jsonPath();
		 Integer userId  = js.get("id");
		 System.out.println("userid : " + userId);
		 
		 
		 System.out.println("==========================================================================================");
		 
		 //update : put : update a user
		 user.setName("Amarendra pani");
		 user.setStatus("inactive");
		 
		 given()
		 .contentType(ContentType.JSON)
			.header("Authorization", "Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
			.body(user)
			.when()
			.put("/public/v2/users/"+ userId)
			.then()
			.assertThat()
			.statusCode(200)
			.and()
			.body("id", equalTo(userId))
			.and()
			.body("name", equalTo(user.getName()))
			.and()
			.body("status", equalTo(user.getStatus()));
		 
	}
		

}
