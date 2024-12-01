package pojo;


//pojo: plain old java object
//can not extent /implement anything
//private data fields (variable)
//Public getter / setter
//Encapsulation
//public const...


public class Credential {
	
	private String userName;
	private String passWord;
	
	public Credential(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	
	

}
