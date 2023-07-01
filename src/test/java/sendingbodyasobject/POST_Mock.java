package sendingbodyasobject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class POST_Mock {

	@Test
	public void getRequest()
	{
		
		HashMap<String, String> obj1 = new HashMap<String, String>();
		
		obj1.put("id", "1001");
		
		obj1.put("type", "Regular");
		
		HashMap<String, String> obj2 = new HashMap<String, String>();
		
		obj2.put("id", "1002");
		
		obj2.put("type", "Chocolate");
		
		
		List<Map<String, String>> jsonObject = new ArrayList<Map<String,String>>();
	
		jsonObject.add(obj1);
		jsonObject.add(obj2);
		
		
		
		RestAssured.baseURI = "https://02bb9a44-db49-4734-9c5b-7991b066bb5a.mock.pstmn.io";
		
		given()
		
		.body(jsonObject)
		
		.log().all()
		
		.when()
		
		.post("/post")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
	}
	
}
