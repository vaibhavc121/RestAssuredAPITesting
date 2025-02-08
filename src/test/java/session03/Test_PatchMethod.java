package session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PatchMethod
{
	@Test
	public void test()
	{
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "vaibhav c");
		jsonData.put("job", "SDET QA");

		RestAssured.baseURI = "https://reqres.in/api/users/13";
		RestAssured.given().header("Content-type", "application/json").contentType(ContentType.JSON)
				.body(jsonData.toJSONString()).when().patch().then().statusCode(200).log().all();
	}
}
