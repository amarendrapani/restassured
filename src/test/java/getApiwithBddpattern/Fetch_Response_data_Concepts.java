package getApiwithBddpattern;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Fetch_Response_data_Concepts {
	
	@Test
	public void get_Contacts_Api_Test_With_Invalid_Token(){
		
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		given().log().all()
			.header("Authorization", "Bearer hb")
				.when().log().all()
					.get("/contacts")
						.then().log().all()
							.assertThat()
								.statusCode(401)
								.and()
								.body("error", equalTo("Please authenticate."));
			
	}
	
	@Test
	public void get_Contacts_Api_Test_With_Invalid_Token_WithExtract() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		String errorMessage = given().log().all()
		.header("Authorization", "Bearer hb")
			.when().log().all()
				.get("/contacts")
					.then().log().all()
						.extract()
							.path("error");
		
		System.out.println(errorMessage);
		Assert.assertEquals(errorMessage, "Please authenticate.");
		
	}
	
	@Test
	public void getSingleUser_FetchUserData() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		Response response = given().log().all()
				.header("Authorization", "Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
					.when().log().all()
						.get("/public/v2/users/7549072");
		
		 JsonPath js = response.jsonPath();
		 
		 System.out.println("statuscode : "+ response.statusCode());
		 System.out.println("statusLine : "+  response.statusLine());
		 response.prettyPrint();
		  
		 int userId = js.getInt("id");
		 System.out.println("userid : " + userId);
		 
		 String userName =  js.getString("name");
		 System.out.println("userName : " + userName);
		 
		 String status = js.getString("status");
		 System.out.println("status : " + status);
		  	
		
	}
	
	@Test
	public void getuser_FetchFullUsersData() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		Response response = given().log().all()
				.header("Authorization", "Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
					.when().log().all()
						.get("/public/v2/users");
		
		 JsonPath js = response.jsonPath();
		 
		 System.out.println("statuscode : "+ response.statusCode());
		 System.out.println("statusLine : "+  response.statusLine());
		 response.prettyPrint();
		 
		List<Integer> ids =  js.getList("id");
		System.out.println(ids);
		 
		 List<String> names = js.getList("name");
		 System.out.println(names);
		 
		 for(Integer e : ids) {
			 System.out.println(e);
		 }
		 	 
	}
	
	
	@Test
	public void getProduct_FetchNestedData() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		Response response = given()
			.when()
				.get("/products");
		
		 System.out.println("statuscode : "+ response.statusCode());
		 System.out.println("statusLine : "+  response.statusLine());
		 response.prettyPrint();
		 
		 JsonPath js = response.jsonPath();
		 
		 List<Integer> ids = js.getList("id");
		 System.out.println(ids);
		 
		 List<Object> prices = js.getList("price");
		 System.out.println(ids);
		 
		 List<Object> rateList = js.getList("rating.rate");
		 System.out.println(ids);
		 
		 List<Integer> countList = js.getList("rating.count");
		 System.out.println(ids);
		 
		 
		 for(int i = 0; i< ids.size(); i++) {
			 
			 int id = ids.get(i);
			 Object price = prices.get(i);
			 Object rate = rateList.get(i);
			 int count = countList.get(i);
			 
			 System.out.println("ID : " + id + "price : " + price + "rate : "+ rate +"count :" + count);
			 
		 }
		 
		 Assert.assertTrue(rateList.contains(4.7f));
		
	}
	
	
	
	
	
	
	

}
