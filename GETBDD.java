package Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GETBDD {

	@Test
	public void get() {
		
		RestAssured.given()
		.baseUri("https://reqres.in/")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.get("/api/users/2")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.log()
		.all();
		
	}
}
