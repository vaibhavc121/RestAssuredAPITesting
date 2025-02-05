package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest
{
	@Test
	public void testcase01()
	{
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.asString());
		System.out.println("status code:" + res.getStatusCode());
	}
}
