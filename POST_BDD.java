package Test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POST_BDD {

	@Test
	public void post_nonBDD() {
		String json="{ \"name\": \"Saikumar\" , \"job\": \"Software Engineer\"}";
		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body(json)
		.when()
		  .post()
		.then()
		  .statusCode(201)
		  .assertThat()
		  .body("job", Matchers.equalTo("Software Engineer"))
		  .extract()
		  .headers();
	}
}
