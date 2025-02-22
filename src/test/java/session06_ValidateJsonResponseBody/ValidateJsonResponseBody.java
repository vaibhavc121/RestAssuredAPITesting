package session06_ValidateJsonResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody
{
	@Test
	public void UserListResponseBody()
	{
		// get requestspecification reference
		RequestSpecification requestSpec = RestAssured.given();

		// specify base URI & base path
		requestSpec.baseUri("https://reqres.in/");
		requestSpec.basePath("api/users?page=2");

		// create/perform get request
		Response response = requestSpec.get();

		// read response body
		ResponseBody responseBody = response.getBody();
		System.out.println(responseBody.asString());
		/*
		 * String responseString = responseBody.asString();
		 * System.out.println("response body: " + responseString);
		 * 
		 * // check for presense of george in response body
		 * Assert.assertEquals(responseString.contains("George"), true);
		 */

		// get json path view of response body
		JsonPath jsonPathView = responseBody.jsonPath();
		String firstname = jsonPathView.get("data[0].first_name");
		Assert.assertEquals(firstname, "George");
	}

}
