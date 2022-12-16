package Test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PUT_NonBDD {

	@Test
	public void putnonBDD() {
		String json="{\r\n"
				+ "    \"name\": \"Saikumar\",\r\n"
				+ "    \"job\": \"India President\"\r\n"
				+ "}";   
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://reqres.in/api/users/2");
		req.contentType(ContentType.JSON);
		req.body(json);
		Response resp=req.put();
		String result=resp.asString();
		System.out.println("Response details are: "+result);
		ValidatableResponse vrs=resp.then();
		vrs.statusCode(200);
		vrs.assertThat().body("job",Matchers.equalTo("India President"));
		
		
	}
}
