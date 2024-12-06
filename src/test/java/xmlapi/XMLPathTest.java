package xmlapi;

import io.restassured.*;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.Test;

public class XMLPathTest {

	@Test
	public void circuitApiTest() {

		RestAssured.baseURI = "http://ergast.com";

		Response response = given()
				.when()
					.get("/api/f1/2017/circuits.xml")
						.then()
							.extract()
								.response();

		String responseBody = response.body().asString();
		System.out.println(responseBody);

		XmlPath xmlpath = new XmlPath(responseBody);

		List<String> circuitsNames = xmlpath.getList("MRData.CircuitTable.C");
		System.out.println("total circit size" + circuitsNames.size());

		System.out.println("**************************");

		for (String circuit : circuitsNames) {
			System.out.print(circuit);
		}

		System.out.println("**************************");

		// fetch the circuit id where circuitid = america ==> Austin

		String locality = xmlpath.getString("**.findAll{it.@circuitid == 'americas'}.Location.Locality");
		System.out.println(locality);

		System.out.println("******************************************");

		// fetch the circuit id where circuitid = america ==> country

		String country = xmlpath.getString("**.findAll{it.@circuitid == 'americas'}.Location.Country");
		System.out.println(country);

		System.out.println("******************************************");

		// fetch the locality where circuitid = 'americas or circuitid = baharin '

		List<String> morelocalities = xmlpath.getList("MRData.CircuitTable.C");

		System.out.println(morelocalities);

	}

	@Test
	public void xmlpathTest() {
		
		RestAssured.baseURI = "http://ergast.com";

		Response response = given()
								.when()
									.get("/api/f1/2017/circuits.xml")
										.then()
											.extract()
												.response();
		
		
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		
		XmlPath xmlPath = new XmlPath(responseBody);
		
		
		//fetch the lat and long values where circuitid = baharin
		String lat 	= xmlPath.getString("**findAll{it.@circuitid == birlin}.Location.@lat");
		String longvalue = xmlPath.getString("**findAll{it.@circuitid == birlin}.Location.@long");

	}

}
