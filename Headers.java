package Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class Headers {

	
	@Test
	public void headers() {
		RestAssured
		.given()
		.get("https://reqres.in/api/users/2")
		.then()
		.log()
		.headers();
		
	}
}
