package pojo;


//pojo: plain old java object
//can not extent /implement anything
//private data fields (variable)
//Public getter / setter
//Encapsulation
//public const...


public class Credential {
	
	private String username;
	private String password;
	
	public Credential(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
