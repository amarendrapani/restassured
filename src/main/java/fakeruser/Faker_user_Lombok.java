package fakeruser;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Faker_user_Lombok {
	

	private Address address;
	private String email;
	private String username;
	private String password;
	private Name name;
	private String phone;
	
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Name{
		private String firstname;
		private String lastname;			
	}
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Address{
		private String city;
		private String street;
		private int number;
		private String zipcode;
		private Geolocation geolocation;
		
		@Data
		@Builder
		@NoArgsConstructor
		@AllArgsConstructor
		public static class Geolocation{
			private String lat;
			@JsonProperty("long")
			private String longitute;
		}
		
	}
	

}
