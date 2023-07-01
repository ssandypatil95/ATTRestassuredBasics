package uploadanddownload;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UploadFile {
	
	
	@Test
	public void getRequest()
	{
		
		File image= new File("C:\\Users\\DELL\\Desktop\\TestImage.png");
		RestAssured.baseURI = "https://the-internet.herokuapp.com";
		
		given()
//		multipart is a method to send the file to the server
		.multiPart("file", image)
		
		.log().all()
		
		.when()
		
		.post("/upload")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
	}
	
	

}
