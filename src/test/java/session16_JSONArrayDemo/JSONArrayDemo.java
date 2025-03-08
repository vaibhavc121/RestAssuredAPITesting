package session16_JSONArrayDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArrayDemo
{
	@Test(enabled = false)
	public void createUserUsingJSONArray()
	{
		// create json object for users

		JSONObject user1 = new JSONObject();
		user1.put("firstname", "vaibhav");
		user1.put("lastname", "chavan");
		user1.put("age", 11);
		user1.put("salary", "1000");

		JSONObject user2 = new JSONObject();
		user2.put("firstname", "vaibhav1");
		user2.put("lastname", "chavan");
		user2.put("age", 11);
		user2.put("salary", "1000");

		JSONObject user3 = new JSONObject();
		user3.put("firstname", "vaibhav2");
		user3.put("lastname", "chavan");
		user3.put("age", 11);
		user3.put("salary", "1000");

		// add JSON object to json array
		JSONArray usersPayload = new JSONArray();
		usersPayload.add(user1);
		usersPayload.add(user2);
		usersPayload.add(user3);

		RequestSpecification reqSpec = RestAssured.given();

		Response response = reqSpec.baseUri("https://reqres.in/api/users").contentType(ContentType.JSON)
				.body(usersPayload).post();

		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 201);
	}

	@Test
	public void createJSONArrayUsingList()
	{
		// create json object for users

		Map<String, Object> user1 = new HashMap<String, Object>();
		user1.put("firstname", "vaibhav");
		user1.put("lastname", "chavan");
		user1.put("age", 11);
		user1.put("salary", "1000");

		Map<String, Object> user2 = new HashMap<String, Object>();
		user2.put("firstname", "vaibhav1");
		user2.put("lastname", "chavan");
		user2.put("age", 11);
		user2.put("salary", "1000");

		Map<String, Object> user3 = new HashMap<String, Object>();
		user3.put("firstname", "vaibhav2");
		user3.put("lastname", "chavan");
		user3.put("age", 11);
		user3.put("salary", "1000");

		// create json array using list
		List<Map<String, Object>> jsonArrayListPayload = new ArrayList<Map<String, Object>>();
		jsonArrayListPayload.add(user1);
		jsonArrayListPayload.add(user2);
		jsonArrayListPayload.add(user3);

		RequestSpecification reqSpec = RestAssured.given();

		Response response = reqSpec.baseUri("https://reqres.in/api/users").contentType(ContentType.JSON)
				.body(jsonArrayListPayload).post();

		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 201);
	}
}
