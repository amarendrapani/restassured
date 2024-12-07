package sslcertification;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class SSLCertificationTest {
	
	@Test
	public void sslTest() {
		RestAssured.given().log().all()
			.relaxedHTTPSValidation()
				.when().log().all()
					.get("https://expired.badssl.com/")
						.then().log().all()
							.statusCode(200);
	}
	
	@Test
	public void sslTest_With_Config() {
		RestAssured.config()
		.sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
	
		RestAssured.given().log().all()
			.when().log().all()
				.get("https://untrested-root.badssl.com/")
					.then().log().all()
						.statusCode(200);
	
	
	}
	
	
	
	

}
