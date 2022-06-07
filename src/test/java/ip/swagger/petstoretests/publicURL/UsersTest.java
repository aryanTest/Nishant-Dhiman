package ip.swagger.petstoretests.publicURL;

import static io.restassured.RestAssured.expect;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import ip.swagger.resources.publicURL.ReadConfigUtility;

public class UsersTest extends ReadConfigUtility {

	public static String baseEndpoint;
	static final String userId = "11";
	static final String updatedUserId = "21";
	static final String username = "aryan";
	static final String petIdToDelete = "10";

	@BeforeClass
	public void init() throws IOException {
		getObject("baseEndpoint");
	}

	@Test(priority = 0)
	public void createNewUser() {
		JSONObject request = new JSONObject();
		request.put("id", userId);
		request.put("username", username);
		request.put("firstname", "aryan");
		request.put("lastname", "d");
		request.put("email", "abxd@zya.com");
		request.put("password", "abcxdf@123");
		request.put("phone", "9999999999");
		Response res = given().contentType(ContentType.JSON).body(request.toJSONString()).when()
				.post(baseEndpoint + "/user");
		res.then().statusCode(200);
		String responseBody = res.getBody().asString();
		try {

			FileWriter file = new FileWriter("src/test/java/responseForUserCreation.json");
			file.write(responseBody);
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void searchUserByUsername() {

		expect().statusCode(200).and().when().get(baseEndpoint + "/user/{username}", username);
	}

	@Test(priority = 2)
	public void UpdateUserDetailsByUserName() {

		JSONObject request = new JSONObject();
		request.put("id", updatedUserId);
		request.put("username", username);
		request.put("firstname", "aryan");
		request.put("lastname", "d");
		request.put("email", "abcd@zya.com");
		request.put("password", "abcxdf@12o03");
		request.put("phone", "9999999999");
		Response res = given().contentType(ContentType.JSON).body(request.toJSONString()).when()
				.put(baseEndpoint + "/user/{username}", username);
		res.then().statusCode(200);
		String responseBody = res.getBody().asString();
		try {

			FileWriter file = new FileWriter("src/test/java/responseForUserUpdation.json");
			file.write(responseBody);
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 3)
	public void deletePetByID() {
		expect().statusCode(200).and().when().delete(baseEndpoint + "/user/{username}", username);
	}

}
