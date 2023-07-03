package uploadanddownload;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DownloadFile {
	
	@Test
	public void getFileFromServer() throws IOException
	{
	
	RestAssured.baseURI = "https://github.com";
	
	
	
	byte[] byteArray = given()

	
	.log().all()
	
	.when()
	
	.get("/Vimannagar/ATTRestassuredBasics/raw/master/BDD flow2.png")
	
	.then()
	
	.log().all()
	
	.extract()
	
	.response()
	
	.asByteArray();
	
	OutputStream os = new FileOutputStream(new File("F:\\Desktop\\VimanNagar\\ATT\\Downloaded content\\BDD flow2.png"));

	os.write(byteArray);
	
	os.close();
	
	
	
	
	}

}
