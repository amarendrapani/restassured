package fakerusercreate;

import io.restassured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import fakeruser.Faker_user_Lombok;
import fakeruser.Faker_user_Lombok.Address;
import fakeruser.Faker_user_Lombok.Address.Geolocation;
import fakeruser.Faker_user_Lombok.Name;

public class Faker_User_Creation {
	
	@Test
	public void createUserTest_WithLombok() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		Geolocation geoLocation = new Geolocation("997.78", "587");
		Address address = new Address("Hydrabad", "Kondhapur", 3, "8545632545", geoLocation);
		Name name = new Name("Amarendra", "Pani");
		Faker_user_Lombok user = new Faker_user_Lombok(address, "amarendra.p@gmail.com","Amarendra Pani", "dgfswer", name, "789-785-8544");
		
		
		 Integer id = given().log().all()
			.body(user)
				.when().log().all()
					.post("/users")
						.then().log().all()
							.and()
								.statusCode(200)
									.and()
										.extract()
											.path("id");
		 
		 System.out.println("id : "+id);
		
		
		
	}
	
	@Test
	public void createUserTest_WithLombok_Builderpattern() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		Geolocation geolocation = Geolocation.
									builder()
										.lat("853.23")
											.longitute("6587.23")
												.build();
		
		Address address = Address
					.builder()
						.city("Hydrabad")
							.street("kondapur")
								.number(21)
									.zipcode("528565")
										.geolocation(geolocation)
											.build();
		
		
		Name name = Name
					.builder()
						.firstname("Amarendra")
							.lastname("Pani")
								.build();
		
		Faker_user_Lombok user = new Faker_user_Lombok(address, "amarendra.pani@gmail.com", "Amarendra pani", "jhygt", name, "856-589-5874");
		
		//Geolocation geoLocation = new Geolocation("997.78", "587");
		//Address address = new Address("Hydrabad", "Kondhapur", 3, "8545632545", geoLocation);
		//Name name = new Name("Amarendra", "Pani");
		//Faker_user_Lombok user = new Faker_user_Lombok(address, "amarendra.p@gmail.com","Amarendra Pani", "dgfswer", name, "789-785-8544");
		
		
		
		
		
		 Integer id = given().log().all()
			.body(user)
				.when().log().all()
					.post("/users")
						.then().log().all()
							.and()
								.statusCode(200)
									.and()
										.extract()
											.path("id");
		 
		 System.out.println("id : "+id);
		
		
		
	}
	
	
	
	
	

}
