package jsonarrauusercreation;

import io.restassured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.testng.annotations.Test;

import complexjsonarray.JsonArray_Body_Lombok;
import complexjsonarray.JsonArray_Body_Lombok.Support;
import complexjsonarray.JsonArray_Body_Lombok.User_Data;

public class Json_Array_complex_Creation_Lombok {
	
	@Test
	public void createUserWithjsonarraylombok() {
		
		RestAssured.baseURI = "http://httpbin.org";
		
		User_Data user1 = new User_Data(1, "amarendra@gmail.com1", "Amarendra", "pani", "https://reqres.in/img/faces/3-image.jpg");
		User_Data user2 = new User_Data(2, "amarendra@gmail.com1", "Amrita", "pani", "https://reqres.in/img/faces/3-image.jpg");
		User_Data user3 = new User_Data(3, "amarendra@gmail.com1", "Pragnya", "pani", "https://reqres.in/img/faces/3-image.jpg");
		User_Data user4 = new User_Data(4, "amarendra@gmail.com1", "Amit", "pani", "https://reqres.in/img/faces/3-image.jpg");
		User_Data user5 = new User_Data(5, "amarendra@gmail.com1", "Amar", "pani", "https://reqres.in/img/faces/3-image.jpg");
		User_Data user6 = new User_Data(6, "amarendra@gmail.com1", "Ama", "pani", "https://reqres.in/img/faces/3-image.jpg");
		
		
		Support support = new Support("https://reqres.in/#support-heading", "To keep reqres free, i am adding this");
		
		JsonArray_Body_Lombok user = new JsonArray_Body_Lombok(1, 2, 10, 2, Arrays.asList(user1,user2,user3,user4,user5,user6), support);
		
		
		given().log().all()
			.contentType(ContentType.JSON)
				.body(user)
					.when().log().all()
						.post("/post")
							.then().log().all()
								.assertThat()
									.statusCode(200);
		
	}
	
	@Test
	public void createUserWithjsonarraylombok_Builder() {
		
		RestAssured.baseURI = "http://httpbin.org";
		
		User_Data user1 = User_Data
				.builder()
					.id(12)
						.email("amarendra@gmail.com1")
							.first_name("dipu").last_name("pani")
								.avatar("https://reqres.in/img/faces/3-image.jpg")
									.build();
		
		User_Data user2 = User_Data
				.builder()
					.id(41)
						.email("amarendra@gmail.com1")
							.first_name("dipu")
								.last_name("pani")
									.avatar("https://reqres.in/img/faces/3-image.jpg")
										.build();
		
		//User_Data user1 = new User_Data(1, "amarendra@gmail.com1", "Amarendra", "pani", "https://reqres.in/img/faces/3-image.jpg");
		//User_Data user2 = new User_Data(1, "amarendra@gmail.com1", "Amarendra", "pani", "https://reqres.in/img/faces/3-image.jpg");
		//User_Data user3 = new User_Data(1, "amarendra@gmail.com1", "Amarendra", "pani", "https://reqres.in/img/faces/3-image.jpg");
		//User_Data user4 = new User_Data(1, "amarendra@gmail.com1", "Amarendra", "pani", "https://reqres.in/img/faces/3-image.jpg");
		//User_Data user5 = new User_Data(1, "amarendra@gmail.com1", "Amarendra", "pani", "https://reqres.in/img/faces/3-image.jpg");
		//User_Data user6 = new User_Data(1, "amarendra@gmail.com1", "Amarendra", "pani", "https://reqres.in/img/faces/3-image.jpg");
		
		
		//Support support = new Support("https://reqres.in/#support-heading", "To keep reqres free, i am adding this");
		
		Support support = Support
				.builder()
					.url("https://reqres.in/#support-heading")
						.text("To keep reqres free, i am adding this")
							.build();
		
		JsonArray_Body_Lombok user = new JsonArray_Body_Lombok(1, 2, 10, 2, Arrays.asList(user1,user2), support);
		
		
		given().log().all()
			.contentType(ContentType.JSON)
				.body(user)
					.when().log().all()
						.post("/post")
							.then().log().all()
								.assertThat()
									.statusCode(200);
		
	}
	
	

}
