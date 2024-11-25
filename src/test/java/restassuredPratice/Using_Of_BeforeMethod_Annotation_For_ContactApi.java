package restassuredPratice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Using_Of_BeforeMethod_Annotation_For_ContactApi {
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
	}
	
	
	@Test
	public void getContactApiTest() {
		
		given().log().all()
			.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzQyMTExYzFkNDUzYTAwMTMzNTBjYTQiLCJpYXQiOjE3MzIzOTIxMjV9.dtj2-qns3BdQn3Z0MG2uvWSGp1BSirD2DEGVME3VG5s")
				.when().log().all()
					.get("/contactList")
						.then().log().all()
							.assertThat()
								.statusCode(200)
									.and()
										.statusLine("HTTP/1.1 200 OK")
											.and()
												.contentType(ContentType.HTML)
													.and()
														.body("$.size()", equalTo(1));
		
	}
	
	@Test
	//negtive test
	public void getContactApiTest_2() {
		
		given().log().all()
			//intensionally passing the wrong bearear token.
			.header("Authorization", "Bearer yhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzQyMTExYzFkNDUzYTAwMTMzNTBjYTQiLCJpYXQiOjE3MzIzOTIxMjV9.dtj2-qns3BdQn3Z0MG2uvWSGp1BSirD2DEGVME3VG5s")
				.when().log().all()
					.get("/contactList")
						.then().log().all()
							.assertThat()
								.statusCode(400)
									.and()
										.statusLine("HTTP/1.1 200 OK")
											.and()
												.contentType(ContentType.HTML)
													.and()
														.body("$.size()", equalTo(1));
		
	}
	

}
