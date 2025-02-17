package session08;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization
{
	@Test
	public void BasicAuth()
	{
		RequestSpecification requestSpec = RestAssured.given();

		// specify url
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");

		Response response = requestSpec.auth().preemptive().basic("postman", "password").get();

		System.out.println("response status: " + response.statusLine());
	}

	@Test
	public void DigestAuth()
	{
		// http://httpbin.org/digest-auth/undefined/vaibhav/vaibhav
		RequestSpecification requestSpec = RestAssured.given();

		// specify url
		requestSpec.baseUri("http://httpbin.org");
		requestSpec.basePath("/digest-auth/undefined/vaibhav/vaibhav");

		Response response = requestSpec.auth().digest("vaibhav", "vaibhav").get();

		Assert.assertEquals(response.statusCode(), 200);

		System.out.println("digest auth response status: " + response.statusLine());
		System.out.println("response body: " + response.body().asString());
	}
}
