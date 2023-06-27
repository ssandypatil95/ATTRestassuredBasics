package fetchdata;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class GetDataFromReadyMadeJSON {
	
	@Test
	public void getData() {
		
		
		JsonPath jp = new JsonPath(BodyDefinition.getBody());
		
		String value= jp.getString("dashboard.website");
		
		System.out.println(value);//www.abc.com
		
	
		
		
	}

}
