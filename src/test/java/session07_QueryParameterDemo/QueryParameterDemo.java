package session07_QueryParameterDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameterDemo
{
	@Test
	public void QueryParameterDemo()
	{
		// get request specification for the given user
		RequestSpecification requestSpec = RestAssured.given();

		// specify url
		requestSpec.baseUri("https://reqres.in/");
		requestSpec.basePath("api/users");
		requestSpec.queryParam("page", 2).queryParam("id", 10);

		// perform get request
		Response response = requestSpec.get();
		String responseBodyString = response.getBody().asString();
		System.out.println("response body: " + responseBodyString);

		// get json path view of response body
		JsonPath jsonPathView = response.jsonPath();
		String firstname = jsonPathView.get("data.first_name");
		System.out.println("1st name: " + firstname);
		Assert.assertEquals(firstname, "Byron");
	}

}
