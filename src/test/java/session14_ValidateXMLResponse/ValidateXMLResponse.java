package session14_ValidateXMLResponse;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateXMLResponse
{
	@Test
	public void AddPet()
	{
		String jsonData = "{\r\n" + "  \"id\": 0,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggie\",\r\n" + "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"status\": \"available\"\r\n" + "}";
		RequestSpecification requestSpec = RestAssured.given();
		// https://petstore.swagger.io/v2/pet
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/pet");
		requestSpec.header("accept", "application/xml");
		requestSpec.header("Content-Type", "application/json");
		requestSpec.body(jsonData);
		Response response = requestSpec.post();

		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 200);
		response.then().body("Pet.name", Matchers.equalTo("doggie"));

	}
}
