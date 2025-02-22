package session12_DeserialisationJson;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserialisationJson
{
	@Test
	public void createUser()
	{
		// https://reqres.in/api/users
		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");

		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "vaibhav");
		jsonData.put("job", "QA");

		// perform post request
		Response response = requestSpec.contentType(ContentType.JSON).body(jsonData.toJSONString()).post();

		ResponseBody responseBody = response.getBody();

		// deserialize responsebody i.e json response body to class object
		JSONPostRequestResponse responseClass = responseBody.as(JSONPostRequestResponse.class);

		Assert.assertEquals(responseClass.name, "vaibhav");
		Assert.assertEquals(responseClass.job, "QA");

	}
}
