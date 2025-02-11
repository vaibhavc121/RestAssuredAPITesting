package session05;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader
{
	@Test
	public void getSingleUser()
	{
		// get request specification
		RequestSpecification requestSpec = RestAssured.given();

		// specify base URI
		requestSpec.baseUri("https://reqres.in/");
		requestSpec.basePath("/api/users/2");

		// create get request
		Response response = requestSpec.get();

		// validate response header
		String contentType = response.getHeader("Content-Type");
		System.out.println("value of connection: " + contentType);

		// read all the response header attributes/keys and print their values
		Headers headersList = response.getHeaders();

		// iterate over header list
		for (Header header : headersList)
		{
			System.out.println("key: " + header.getName() + "," + " value: " + header.getValue());
		}

		// validation
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}

}
