package session15_JsonObjectUsingJavaMap;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonObjectUsingJavaMap
{
	@Test
	public void CreateAuthToken()
	{
		// create json object using javamap
		Map<String, String> authToken = new HashMap<String, String>();
		authToken.put("username", "admin");
		authToken.put("password", "password123");

		Response response = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON).body(authToken).post();

		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
	}

}
