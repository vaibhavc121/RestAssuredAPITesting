package session10;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization
{
	@Test
	public void getWeatherDataByCity()
	{
		// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
		RequestSpecification requestSpect = RestAssured.given();
		requestSpect.baseUri("https://api.openweathermap.org");
		requestSpect.basePath("data/2.5/weather");
		requestSpect.queryParam("q", "pune").queryParam("appid", "95501abd36486d3cde08b2c8d89f0adc");

		Response response = requestSpect.get();

		Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println("response status line: " + response.statusLine());
		System.out.println("response body: " + response.body().asString());

	}
}
