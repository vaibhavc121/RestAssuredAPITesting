package session15_JsonObjectUsingJavaMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonObjectUsingJavaMap
{
	@Test(enabled = false)
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

	@Test
	public void createUser()
	{
		HashMap<String, Object> UserData = new HashMap<String, Object>();
		UserData.put("firstName", "Amod");
		UserData.put("lastName", "Mahajan");
		UserData.put("age", 28);
		UserData.put("salary", 10000.56);
		UserData.put("IsMarried", true);

		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("Music");
		hobbies.add("computers");
		hobbies.add("Games");
		UserData.put("Hobbies", hobbies);

		HashMap<String, String> TechSkill = new HashMap<String, String>();
		TechSkill.put("Programming language", "Java");
		TechSkill.put("WebAutomation", "Seleniuim");
		TechSkill.put("API testing", "Rest Assured");

		UserData.put("TechSkill", TechSkill);

		Response response = RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON)
				.body(UserData).post();

		response.prettyPrint();

		// verify status code
		Assert.assertEquals(response.statusCode(), 201, "check for status code.");
	}

}
