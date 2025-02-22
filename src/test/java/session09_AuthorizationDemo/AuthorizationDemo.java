package session09_AuthorizationDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemo
{
	@Test
	public void bearerToken()
	{
		// https://gorest.co.in/public/v2/users
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");

		JSONObject payload = new JSONObject();
		payload.put("name", "vaibhavc");
		payload.put("email", "vaibhavc@gmail.com");
		payload.put("gender", "male");
		payload.put("status", "active");

		String authToken = "Bearer 48e85ceb0517da4bb804f101ee46593ba0e12b349b2ea7e38b604a603ee4cb5a";
		requestSpec.headers("Authorization", authToken).contentType(ContentType.JSON).body(payload.toJSONString());

		Response response = requestSpec.post();

		Assert.assertEquals(response.statusCode(), 201);

		System.out.println("response status: " + response.statusLine());
		System.out.println("response body: " + response.body().asString());
	}

}
