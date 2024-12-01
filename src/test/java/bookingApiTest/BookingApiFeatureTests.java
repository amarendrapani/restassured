package bookingApiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookingApiFeatureTests {
	String token;
	
	@BeforeMethod
	public void getToken() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		token = given().log().all()
		.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/pojo/auth.json"))
				.when().log().all()
					.post("/auth")
						.then().log().all()
							.assertThat()
								.statusCode(200)
									.extract()
										.path("token");
		
		System.out.print("tokenID ==> " + token);
		
	}
	
	@Test
	public void getBookingIdsTest() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		Response response = given().log().all()
		.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/pojo/auth.json"))
				.when().log().all()
					.get("/booking")
						.then().log().all()
							.assertThat()
								.statusCode(200)
									.extract()
									.response();
		
		JsonPath js = response.jsonPath();
		List<Integer> allIds = js.getList("bookingid");
		System.out.println("total booking ids: " + allIds.size());
		
		//select count(*) from booking: --> X if you want to validate the database you can do it.
	
		
		for(Integer id : allIds) {
			Assert.assertNotNull(id);
			
		}
	}
	
	@Test
	public void getBookingid() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		//create a new booking id : post
		int newBookingId = createBookingid();
		
		given().log().all()
			.pathParam("bookingId", newBookingId)
				.when().log().all()
					.get("/booking/{bookingId}")
						.then().log().all()
							.assertThat()
								.statusCode(200)
									.and()
										.body("firstname", equalTo("Jim"))
											.and()
												.body("bookingdates.checkin", equalTo("2018-01-01"));
			
	}
	
	@Test
	public void createbookingidTest() {
		
		Assert.assertNotNull(createBookingid());
		
	}
	
	@Test
	public void updateBookingTest() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		//create a new booking id : Post
		int newBookingId = createBookingid();
		
		//check the id is successfully created or not : Get
		/*given().log().all()
		.pathParam("bookingId", newBookingId)
			.when().log().all()
				.get("/booking/{bookingId}")
					.then().log().all()
						.assertThat()
							.statusCode(200);*/
	
		// instead of writing again and again the above given call for validation we can call the method we createdfor the above
		verifyBookingid(newBookingId);
		
		// Update the same booking id : put
		given().log().all()
		.pathParam("bookingId", newBookingId)
		.contentType(ContentType.JSON)
		.header("cookie","token="+token)
			.body("{\n"
					+ "    \"firstname\" : \"Amarendra\",\n"
					+ "    \"lastname\" : \"Pani\",\n"
					+ "    \"totalprice\" : 111,\n"
					+ "    \"depositpaid\" : true,\n"
					+ "    \"bookingdates\" : {\n"
					+ "        \"checkin\" : \"2018-01-01\",\n"
					+ "        \"checkout\" : \"2019-01-01\"\n"
					+ "    },\n"
					+ "    \"additionalneeds\" : \"Lunch\"\n"
					+ "}")
			
				.when().log().all()
					.put("/booking/{bookingId}")
						.then().log().all()
							.statusCode(200)
								.body("firstname", equalTo("Amarendra"))
									.and()
										.body("lastname", equalTo("Pani"))
											.and()
												.body("additionalneeds", equalTo("Lunch"));
		
	}
	
	@Test
	public void partialUpdateBookingTest() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		//create a new booking id : Post
		int newBookingId = createBookingid();
		
		//check the id is successfully created or not : Get
		/*given().log().all()
		.pathParam("bookingId", newBookingId)
			.when().log().all()
				.get("/booking/{bookingId}")
					.then().log().all()
						.assertThat()
							.statusCode(200);*/
	
		// instead of writing again and again the above given call for validation we can call the method we createdfor the above
		verifyBookingid(newBookingId);
		
		// Update the same booking id : patch
		given().log().all()
		.pathParam("bookingId", newBookingId)
		.contentType(ContentType.JSON)
		.header("cookie","token="+token)
			.body("{\r\n"
					+ "    \"firstname\" : \"Api\",\r\n"
					+ "    \"lastname\" : \"Testing\"\r\n"
					+ "}")
			
				.when().log().all()
					.patch("/booking/{bookingId}")
						.then().log().all()
							.statusCode(200)
								.body("firstname", equalTo("Api"))
									.and()
										.body("lastname", equalTo("Testing"));
											
		
	}
	
		@Test
		public void deleteBookingTest() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		//create a new booking id : Post
		int newBookingId = createBookingid();
		
		/*//check the id is successfully created or not : Get
		given().log().all()
			.pathParam("bookingId", newBookingId)
				.when().log().all()
					.get("/booking/{bookingId}")
						.then().log().all()
							.assertThat()
								.statusCode(200);*/
		
		// instead of writing again and again the above given call for validation we can call the method we createdfor the above
		verifyBookingid(newBookingId);
		
		// delete the same booking id : delete
		given().log().all()
		.pathParam("bookingId", newBookingId)
		.contentType(ContentType.JSON)
		.header("cookie","token="+token)
			.when().log().all()
					.delete("/booking/{bookingId}")
						.then().log().all()
							.statusCode(201);
								
											
		
	}
	
	
	
	// added this method for code optimization,   
	//if you want you can call this method instead of validating this again and aagain for post, put , and delete calls
	public void  verifyBookingid(int newBookingId) {
		
		given().log().all()
		.pathParam("bookingId", newBookingId)
			.when().log().all()
				.get("/booking/{bookingId}")
					.then().log().all()
						.assertThat()
							.statusCode(200);
		
	}
	public int createBookingid() {
		
			RestAssured.baseURI = "https://restful-booker.herokuapp.com";
			
			int bookingid = given().log().all()
			.contentType(ContentType.JSON)
				.body("{\n"
						+ "    \"firstname\" : \"Jim\",\n"
						+ "    \"lastname\" : \"Brown\",\n"
						+ "    \"totalprice\" : 111,\n"
						+ "    \"depositpaid\" : true,\n"
						+ "    \"bookingdates\" : {\n"
						+ "        \"checkin\" : \"2018-01-01\",\n"
						+ "        \"checkout\" : \"2019-01-01\"\n"
						+ "    },\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\n"
						+ "}")
				
					.when().log().all()
						.post("/booking")
							.then().log().all()
								.extract()
									.path("bookingid");
			
			System.out.println("bookingid : "+ bookingid);
			return bookingid;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
