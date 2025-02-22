package session_QueryRequestSpecification;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification
{
	// https://reqres.in/api/users
	@Test
	public void createUser()
	{
		// create json data
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "rohit");
		jsondata.put("job", "QA");

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in").basePath("/api/users").contentType(ContentType.JSON)
				.body(jsondata.toJSONString());

		// query details for request specification

		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(reqSpec);

		// get base URI
		String retrieveBaseURI = queryRequest.getBaseUri();
		System.out.println("base uri: " + retrieveBaseURI);

		// get base URI
		String retrieveBasePath = queryRequest.getBasePath();
		System.out.println("base path: " + retrieveBasePath);

		// get base URI
		String retrieveBody = queryRequest.getBody();
		System.out.println("body: " + retrieveBody);
	}

}
