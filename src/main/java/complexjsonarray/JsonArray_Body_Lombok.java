package complexjsonarray;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class JsonArray_Body_Lombok {
	
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<User_Data> data;
	private Support support;
	
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class User_Data{
		private int id;
		private String email;
		private String first_name;
		private String last_name;
		private String avatar;
	}
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Support{
		private String url;
		private String text;
	}


}
