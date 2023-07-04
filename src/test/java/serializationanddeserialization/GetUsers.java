package serializationanddeserialization;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.Data;
import pojo.GetUsersResponseBody;

public class GetUsers {
	
	
	@Test
	public void getAllUser()
	{
		RestAssured.baseURI = "https://reqres.in/";
				
		GetUsersResponseBody responseBody = given()	
		
						.when()
						
						.log().all()
		
						.get("api/users?page=2")
		
						.then()
						
						.log().all()
		
						.extract()
		
						.response().as(GetUsersResponseBody.class);
		
		Integer pagecount = responseBody.getTotal_pages();
		
		System.out.println(pagecount);//2
		
		
		List<Data> datavalue = responseBody.getData();
		
		String firstname = datavalue.get(0).getFirst_name();
		
		System.out.println(firstname);//Micheal
		
//		Assignment :
		
//		WAP to print all the parameters of support json
		

}
}
