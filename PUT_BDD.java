package Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PUT_BDD {

	@Test
	public void put_bdd() {
		String json="{\r\n"
				+ "    \"name\": \"Saikumar\",\r\n"
				+ "    \"job\": \"India President\"\r\n"
				+ "}";
		RestAssured.given()
		.baseUri("https://reqres.in/api/users/2")
		.contentType(ContentType.JSON)
		.body(json)
		.when()
		.put()
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
	}
}
