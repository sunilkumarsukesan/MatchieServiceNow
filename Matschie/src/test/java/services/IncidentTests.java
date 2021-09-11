package services;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.containsString;

import java.io.File;

public class IncidentTests extends BaseRequest{
	
	
	@Test
	public void getIncidents(){
		request
			.get("incident")//Table Name
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("sys_id"));		
	}
}
