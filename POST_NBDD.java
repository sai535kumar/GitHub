package Test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST_NBDD {

	@Test
	public void postbdd() {
		String json="{ \"name\": \"Saikumar\" , \"job\": \"Software Engineer\"}";
		RequestSpecification req=RestAssured.given();
		req.contentType(ContentType.JSON);
		req.baseUri("https://reqres.in/api/users");
		req.body(json);
		Response resp=req.post();
		String result=resp.asString();
		System.out.println("Details are:"+result);
		ValidatableResponse vrs=resp.then();
		vrs.statusCode(201);
		vrs.assertThat().body("name", Matchers.equalTo("Saikumar"));
	}
}
