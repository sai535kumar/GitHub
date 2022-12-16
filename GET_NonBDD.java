package Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GET_NonBDD {

	@Test
	public void get_NonBDD() {
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://reqres.in/api/users/2");
		Response resp=req.get();
		String result=resp.asString();
		System.out.println("Response details are: "+result);
		ValidatableResponse vrs=resp.then();
		System.out.println(vrs.statusCode(200));
		System.out.println(vrs.statusLine("HTTP/1.1 200 OK"));
		
	}
}
