package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SalesforceLeads {
	
	public Response response;
	public ValidatableResponse json;
	public RequestSpecification request;

	
	@When("get all leads with (.*)$")
	public void get_all_leads(String id){
		response = request.when().contentType(ContentType.JSON).get("Contact/"+id);
		response.prettyPrint();
	}
	

}
 