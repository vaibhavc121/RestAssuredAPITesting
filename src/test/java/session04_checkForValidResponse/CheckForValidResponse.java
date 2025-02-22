package session04_checkForValidResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse
{
	@Test
	public void getSingleUser()
	{
		// specify the base URL
		RestAssured.baseURI = "https://reqres.in/api/users/2";

		// get request specification of the request
		RequestSpecification requestSpec = RestAssured.given();

		// call get method
		Response response = requestSpec.get();
		int statusCode = response.getStatusCode();

		// validation
		// Assert.assertEquals(statusCode, 200);

		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "incorrect status line");

	}
	
	@Test
	public void getSingleUser_BDDStyle()
	{
		RestAssured.given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
	}

}
