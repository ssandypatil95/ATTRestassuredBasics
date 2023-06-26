package basicrequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateUser {
	static String messagevalue;

	@Test(priority = 1)
	public void createAUser() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		Response response = given()

				.body("{\r\n" + "  \"id\": 0,\r\n" + "  \"username\": \"userthree\",\r\n"
						+ "  \"firstName\": \"Ron\",\r\n" + "  \"lastName\": \"Dutta\",\r\n"
						+ "  \"email\": \"ron.dutta@gmail.com\",\r\n" + "  \"password\": \"Test@1234\",\r\n"
						+ "  \"phone\": \"9988776655\",\r\n" + "  \"userStatus\": 0\r\n" + "}")

				.header("Content-Type", "application/json")

				.when()

				.post("/user")

				.then()

				.extract()

				.response();

		String resp = response.asPrettyString();

		System.out.println(resp);

		JsonPath jp = response.jsonPath();

		int codevalue = jp.getInt("code");// 200

		System.out.println(codevalue);

		messagevalue = jp.getString("message");// 1581268527

		System.out.println("message from Create user API" + messagevalue);

		String typevalue = jp.getString("type");// unknown

		System.out.println(typevalue);

	}

	@Test(priority = 2)
	public void getUserDetails() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		Response response = given()

				.when()

				.get("/user/userthree")

				.then()

				.extract()

				.response();

		String resp = response.asPrettyString();

		System.out.println(resp);

		JsonPath jp = response.jsonPath();

		String idvalue = jp.getString("id");

		System.out.println("id value from Get request is" + idvalue);

		Assert.assertEquals(messagevalue, idvalue);

	}

}
