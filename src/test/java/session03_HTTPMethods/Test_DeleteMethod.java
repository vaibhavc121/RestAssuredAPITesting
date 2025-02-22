package session03_HTTPMethods;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_DeleteMethod
{
	@Test
	public void delete()
	{
		RestAssured.baseURI = "https://reqres.in/api/users/13";
		RestAssured.given().when().delete().then().log().all().statusCode(204);
	}

}
