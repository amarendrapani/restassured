package authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AuthApiTest {
	
	//basic need to send username and password
	
	//preemptive -- a to b(encoading), b to a (decoading)
	
	//digestive --when you are sending a request to server, then server will give you some information along with header www.Authentication and some secreat details . 
	//and it clearly mention that its digest type Authentication along with header which i mention,then you need to pass username and password along with the details ,
	//which the server send to you then only the server respond you.its more secure than basic Auth and premitive Auth.
	
	
	//form
	//Oauth1
	//OAuth2
	//JWT
	
	
	
	
	// basic auth : username and password
	
	@Test
	public void basicAuthTest() {
		RestAssured.baseURI = "https://the-internet.herokuapp.com";
		
		given()
			.auth()
				.basic("admin", "admin")
					.when()
						.get("/basic_auth")
							.then()
								.assertThat()
									.statusCode(200);
		
		
	}
	
	@Test
	public void preemptiveAuthTest() {
		RestAssured.baseURI = "https://the-internet.herokuapp.com";
		
		given()
			.auth()
				.preemptive()
					.basic("admin", "admin")
						.when()
							.get("/basic_auth")
								.then()
									.assertThat()
										.statusCode(200);
		
		
	}
	
	
	@Test
	public void digastiveAuthTest() {
		RestAssured.baseURI = "https://postman-echo.com";
		
		given()
			.auth()
				.digest("postman", "password")
						.when()
							.get("/digest-auth")
								.then()
									.assertThat()
										.statusCode(200)
											.and()
												.body("authenticated", equalTo(true));
		
		
	}
	
	
	
	
	
	
	
	

}
