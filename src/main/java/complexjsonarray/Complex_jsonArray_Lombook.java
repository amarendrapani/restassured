package complexjsonarray;

import lombok.Data;
import lombok.Builder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Complex_jsonArray_Lombook {
	
	private int id;
	private String name;
	private String email;
	private Address address;
	private String phone;
	private String website;
	private Company company;
	private List<Skills> skills;
	private List<Projects> projects;
	private String active;
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Address{
		private String city;
		private String zipcode;
		private Geo geo;
		
		@Data
		@Builder
		@AllArgsConstructor
		@NoArgsConstructor
		public static class Geo{
			private String lat;
			@JsonProperty("long")
			private String longitute;
			
		}
		
	}
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Company{
		private String name;
		private String catchPhrase;
		private String bs;
	}
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Skills{
		private String name;
		private String proficiency;
	}
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Projects{
		private String title;
		private String description;
		private int durationmonth;
		private List<String> technology;
	}
	

}
