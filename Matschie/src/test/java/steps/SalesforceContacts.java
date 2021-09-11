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

public class SalesforceContacts {
	
	public Response response;
	public ValidatableResponse json;
	public RequestSpecification request;


	@Given("enable logs")
	public void setUp(){ 
		request = given().log().all();
	}
	
	@When("i get all Contact")
	public void get_all_contacts(){
		response = request.when().contentType(ContentType.JSON).get("Contact");
		response.prettyPrint();
		System.out.println(response.jsonPath().get("recentItems.size()"));
		for (int i = 0; i < response.jsonPath().get("recentItems.size()"); i++) {
			
		}
	}
	
	@When("get all Contact with (.*)$")
	public void get_specific_contacts(String id){
		response = request.when().contentType(ContentType.JSON).get("Contact/"+id);
		response.prettyPrint();
	}
	
	@Then("i should find the newly created contact (.*)$")
	public void verify_new_contact(String id){
		//response.jsonPath().
		response.prettyPrint();
	}
	
	@And("i update the contact (.*)$")
	public void update_a_Contact(String id){
		response = request.contentType(ContentType.JSON).patch("Contact/"+id);
		response.prettyPrint();
	}

	
	@When("firstname and last name is added as (.*) , (.*)$")
	public void add_description(String firstName, String lastName){
		request = request.when().body("{\"FirstName\" : \""+firstName+ "\"," +"\"LastName\" : \"" +   lastName +"\"}");
	}
	
	@When("new contact is created")
	public void a_new_contact_created(){
		response = request.when().contentType(ContentType.JSON).post("contact");
		response.prettyPrint();
	}
	
	@Then("the status code should be (\\d+)$")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
	}
	
	@When("Mailing address is added as jsonbody from the path (.*)$")
	public void add_description(String path){
		request = request.when().body(new File(path));
	}

}
 