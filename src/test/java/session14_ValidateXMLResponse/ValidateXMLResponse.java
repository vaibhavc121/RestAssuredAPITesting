package session14_ValidateXMLResponse;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ValidateXMLResponse
{

	public void AddPet()
	{
		RequestSpecification requestSpec = RestAssured.given();
		// https://petstore.swagger.io/v2/pet
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/pet");
	}
}
