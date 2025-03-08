package session17_JSONObjectUsingJacksonAPI;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONObjectUsingJacksonAPI
{
	@Test
	public void CreateUser() throws JsonProcessingException
	{
		/*
		 * { "firstName":"Prerna", "lastName":"Gupta", "age": 28, "salary": 10000.56,
		 * "IsMarried":true, "TechSkill":{ "Programming language":"Java",
		 * "WebAutomation": "Selenium", "API testing" : "Rest Assured" }
		 * 
		 * }
		 */

		// create object mapper class instance
		ObjectMapper objectMapper = new ObjectMapper();

		// create object node i.e json node
		ObjectNode userDetails = objectMapper.createObjectNode();
		userDetails.put("firstName", "Prerna");
		userDetails.put("age", 28);
		userDetails.put("salary", 10000.56);
		userDetails.put("IsMarried", true);

		ObjectNode techSkill = objectMapper.createObjectNode();
		techSkill.put("Programming language", "Java");
		techSkill.put("WebAutomation", "Selenium");
		techSkill.put("API testing", "Rest Assured");

		userDetails.set("TechSkill", techSkill);

		// print user details json object
		String userDetailsAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
		System.out.println("created json node is: " + userDetailsAsString);
	}

}
