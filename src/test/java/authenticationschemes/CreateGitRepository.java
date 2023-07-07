package authenticationschemes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class CreateGitRepository {
	
	
	@Test
	public void createRepo()
	{
		RestAssured.baseURI = "https://api.github.com";
		
		given()
		
		.header("Accept", "application/vnd.github+json")
		
		.header("Authorization", "Bearer token")
		
		.header("X-GitHub-Api-Version", "2022-11-28")
		
		.log().all()
		
		.body("{\r\n"
				+ "  \"name\": \"ATTBatchDemoRepo\",\r\n"
				+ "  \"description\": \"This is a test repository\",\r\n"
				+ "  \"homepage\": \"https://github.com\",\r\n"
				+ "  \"private\": true,\r\n"
				+ "  \"is_template\": true\r\n"
				+ "}")
		
		.when()
		
		.post("/user/repos")
		
		.then()
		
		.log().all();
		
		
		
		
		
		
	}

}
