package getApiwithBddpattern;



import  io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test
public class Get_Api_With_Queryparameter_and_Pathparameter {
	
	
	
	public void getuser_With_Queryparams() {
		
		RestAssured.baseURI = "https://gorest.co.in/"; 
		
		given().log().all()
		.header("Authorization","Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
		
			.queryParam("name", "trivedi")
				.queryParam("status", "Active")
					.when().log().all()
						.get("/public/v2/users")
							.then().log().all()
								.assertThat()
									.statusCode(200)
										.and()
											.contentType(ContentType.JSON);
		
	}
	
	
	// passing Query parameters by using Hashmap Class
	@Test
	public void getuser_With_Queryparams_Using_Hashmap() {
		
		RestAssured.baseURI = "https://gorest.co.in/"; 
		
		  Map<String,String> queryparms = new HashMap<String,String>();
		  queryparms.put("name", "trivedi");
		  queryparms.put("status", "active");
		  queryparms.put("gender", "male");
		
		given().log().all()
		.header("Authorization","Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
		
			.queryParams(queryparms)
					.when().log().all()
						.get("/public/v2/users")
							.then().log().all()
								.assertThat()
									.statusCode(200)
										.and()
											.contentType(ContentType.JSON);
		
	}

	
		// passing Query parameters by using Map.oF(); 
		//so its very simple dont need to create the hashmap class and its available in java9 version
		
		
	@Test
	public void getuser_With_Queryparams_Using_Map_oF() {
	
		RestAssured.baseURI = "https://gorest.co.in/"; 
	
		Map<String,String> queryparms = Map.of("name", "trivedi"
												,"status", "active");
	
	
		given().log().all()
		.header("Authorization","Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
	
				.queryParams(queryparms)
					.when().log().all()
						.get("/public/v2/users")
							.then().log().all()
								.assertThat()
									.statusCode(200)
										.and()
											.contentType(ContentType.JSON);
		
		
	}
	
	
	@DataProvider
	public Object[][] getUsername_and_Status(){
		return new Object[][] {	
			{"trivedi","active"},
			{"trivedi","inactive"}
		};
	}
	
	
	@Test(dataProvider = "getUsername_and_Status")
	public void getuser_With_Queryparams_Using_Dataprovider(String name,String status) {
	
		RestAssured.baseURI = "https://gorest.co.in/"; 
	
		 Map<String,String> queryparms = new HashMap<String,String>();
		  queryparms.put("name", name);
		  queryparms.put("status", status);
	
	
		given().log().all()
		.header("Authorization","Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
	
				.queryParams(queryparms)
					.when().log().all()
						.get("/public/v2/users")
							.then().log().all()
								.assertThat()
									.statusCode(200)
										.and()
											.contentType(ContentType.JSON);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		//==========================================================================================================
		//============================ Path Parameters handling ====================================================
		//==========================================================================================================
		
		@Test
		public void getUserApi_With_Pathparameter() {
			
			RestAssured.baseURI = "https://gorest.co.in/";
			
			given().log().all()
				.header("Authorization","Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
				
					.pathParam("userid","7381532")
						.when().log().all()
							.get("/public/v2/users/{userid}/posts")
								.then().log().all()
									.assertThat()
										.statusCode(200);
			
			
		}
		
		
		// by using data provider
		
		@DataProvider
		public Object[][] getUserId(){
			return new Object[][] {
				
				{"6942516"},{"7589658"},{"5285698"}
				
				};
				
		}
		
		@Test(dataProvider = "getUserId")
         public void getUserApi_With_Pathparameter_WithDataProvider(String userid) {
			
			RestAssured.baseURI = "https://gorest.co.in/";
			
			given().log().all()
				.header("Authorization","Bearer fffcb18cd760cbb70acb4190be85c2996d3be5d2a802c25e1dfb088666bc3821")
				
					.pathParam("userid",userid)
						.when().log().all()
							.get("/public/v2/users/{userid}/posts")
								.then().log().all()
									.assertThat()
										.statusCode(200);
			
			
		}
		
	

	

}
