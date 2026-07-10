package project;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;

public class gitHubrestAssuredproject {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIOPhy3xVpDty6PLUHMKJvEj/ZM8AvXdNW4spOiBnDXMa";
	int sshKeyId;
	
	@BeforeClass
	public void setup() {
		//Request Specification
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://api.github.com/user/keys").
				addHeader("Authorization","token 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").
				addHeader("Content-Type","application/json").
				build();
		//Response Specification
		responseSpec = new ResponseSpecBuilder().
				expectResponseTime(lessThanOrEqualTo(5000L)).
				expectBody("key",equalTo(sshKey)).
				expectBody("title", equalTo("TestAPIKey")).
				build();	
		
	}
	
	@Test (priority=1)
	public void postRequest(){
		//Create Request Body
		  Map<String, String> reqBody = new HashMap<String, String>();
		  reqBody.put("title", "TestAPIKey");
		  reqBody.put("key", sshKey);	
		//Send request, save response
		  Response response = 
				  given().spec(requestSpec).body(reqBody).
				  when().post();
		  response.prettyPrint();
		//Extract ID
		  sshKeyId = response.then().extract().path("id");
		//Assertions
		  response.then().statusCode(201).spec(responseSpec);
		
	}
	
	@Test (priority=2)
	public void getRequest(){
		  //Path: https://api.github.com/user/keys/{keyId}
		  //Generate response and assert
		  given().spec(requestSpec).pathParam("keyId", sshKeyId).
		  when().get("/{keyId}").
		  then().statusCode(200).spec(responseSpec);
		
	}
	
	@Test (priority=3)
	public void deleteRequest(){
		//Path: https://api.github.com/user/keys/{keyId}
		  //Generate response and assert
		  given().spec(requestSpec).pathParam("keyId", sshKeyId).
		  when().delete("/{keyId}").
		  then().statusCode(204).time(lessThan(3000L));  
		
	}
	
}
