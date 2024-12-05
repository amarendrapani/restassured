package postApiWithCreateUser;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.UserLombok;
import pojo.User;

public class UpdateUserWith_Lombook {
	
	public String getrandomMailid() {
		return  "AutomationApi"+ System.currentTimeMillis()+"@gmail.com";
	}

	
	@Test 
	public void updateTheUserWith_lombook() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		
		
		//User user = new User("Amarendra",getrandomMailid(), "male", "active");
		UserLombok user = new UserLombok("Amarendra",getrandomMailid(), "male", "active");
		
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

}
	
	
	@Test 
	public void updateTheUserWith_lombook_Builder() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		
		
		//User user = new User("Amarendra",getrandomMailid(), "male", "active");
		//UserLombok user = new UserLombok("Amarendra",getrandomMailid(), "male", "active");
		
		UserLombok user = UserLombok.builder()
	               .name("Amarendra Pani")
	               .email(getrandomMailid())
	               .gender("male")
	               .status("active")
	               .build();
		
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

}

	
}