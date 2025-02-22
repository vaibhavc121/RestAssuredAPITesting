package session03_HTTPMethods;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Test_GetMethod
{
	@Test
	public void test()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("response code: " + response.getStatusCode());
		System.out.println("response body: " + response.getBody().asString());
		System.out.println("response time: " + response.getTime());
		System.out.println("response header: " + response.header("Content-Type"));

		// validate status code
		// expected status code- 200

		int expectedStatusCode = 200;
		int actualStatusCode = response.getStatusCode();

		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}
}
