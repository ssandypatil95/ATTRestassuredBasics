package fetchdata;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FetchValueOfCoursesAndPRice {
	
	
	@Test
	
	public void getPriceAndValue()
	{
		JsonPath jsonpath = new JsonPath(BodyDefinition.getBody());
		
		
		
		int coursecount = jsonpath.getInt("courses.size()");
		
		
		for(int i=0; i<coursecount; i++)
		{
			String title = jsonpath.getString("courses["+i+"].title");
			int price = jsonpath.getInt("courses["+i+"].price");
			
			System.out.println(title + " : " + price);
			
			
		}
		
	}
	
	@Test
	
	public void validateCoursePrice()
	{
		JsonPath jsonpath = new JsonPath(BodyDefinition.getBody());
		
		
		
		int coursecount = jsonpath.getInt("courses.size()");
		
		int sum = 0;
		
		for(int i=0; i<coursecount; i++)
		{
			int copies = jsonpath.getInt("courses["+i+"].copies");
			int price = jsonpath.getInt("courses["+i+"].price");
			
			sum = sum + copies * price;
		}
		
		System.out.println("Sum value is : "+sum);
		
		
		int purchaseamount = jsonpath.getInt("dashboard.purchaseAmount");

		System.out.println("Purchase amount value is : "+purchaseamount);
		
		Assert.assertEquals(sum, purchaseamount);
		
	}
	
	
	

}
