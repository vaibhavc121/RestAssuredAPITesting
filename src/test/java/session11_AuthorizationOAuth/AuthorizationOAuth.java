package session11_AuthorizationOAuth;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationOAuth
{
	public static String accessToken;

	// https://api-m.sandbox.paypal.com/v1/oauth2/token
	@Test(priority = 1)
	public void OAuth2()
	{
		String clientId = "ARGgADKN70VPZMG_dq09dviTPlIFPAaPzhF5CsDHghcqYQwdTKbbxIfIOfjW3Dl6DO75LKqs42kAwIm-";
		String clientSecret = "EIsHKpwdf3gGH0XF4RCZUQJD5x8z8eBvRQaW_5751-SIeXNhIzatlArcjDl0u5eYtePp5CpgVXEXxc07";

		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://api-m.sandbox.paypal.com");
		requestSpec.basePath("v1/oauth2/token");

		// basic authorization
		Response response = requestSpec.auth().preemptive().basic(clientId, clientSecret)
				.param("grant_type", "client_credentials").post();

		response.prettyPrint();

		System.out.println("response code: " + response.statusCode());
		System.out.println("status line: " + response.statusLine());

		Assert.assertEquals(response.statusCode(), 200);

		// get access token from response body
		accessToken = response.getBody().path("access_token");

	}

	@Test(priority = 2)
	public void listInvoice()
	{
		// page=3&page_size=4&total_count_required=true
		Response response = RestAssured.given().auth().oauth2(accessToken).queryParam("page", "3")
				.queryParam("page_size", "4").queryParam("total_count_required", true)
				.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");

		System.out.println("----------list invoice---------");

		response.prettyPrint();
		System.out.println("response code: " + response.statusCode());
		System.out.println("status line: " + response.statusLine());

		Assert.assertEquals(response.statusCode(), 200);
	}

}
