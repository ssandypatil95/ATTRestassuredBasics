package basicrequest;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadRequest {
	
	@Test
	public void getHeadInformation()
	{
		RestAssured.baseURI = "https://api.getpostman.com";

		Response response = given()

							.header("x-api-key", "api-key")

							.when()

							.head("/workspaces")

							.then()

							.extract()

							.response();
		
		String resp = response.asPrettyString();
		
		System.out.println(resp);
		
		int statuscode = response.getStatusCode();
		
		System.out.println(statuscode);
		
		
//		Fetching headers information
		
		Headers header = response.headers();
		
		List<Header> value = header.asList();
		
		Header firstheader = value.get(0);
		
		String name = firstheader.getName();
		
		String val = firstheader.getValue();
		
		System.out.println(name +" "+val);// printing only the specified index position of name and value of header
		
		
		
//		Fetching all values of header
		
		String valueee = header.toString();
		
		System.out.println(valueee);// will print the complete header information
		
		
//		Get individual value of header
		
		String contentvalue = response.getHeader("Content-Type");
		
		System.out.println(contentvalue);//application/json; charset=utf-8
		
		
		
	}

}
