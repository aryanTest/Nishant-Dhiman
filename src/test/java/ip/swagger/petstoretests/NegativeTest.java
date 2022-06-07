package ip.swagger.petstoretests;

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
import ip.swagger.resources.ReadConfigUtility;

public class NegativeTest extends ReadConfigUtility {

	public static String baseEndpoint;
	static final String invalidPetId = "101119999999111111999998";
	static final String invalidUserId = "21999099999999900000";
	static final String username = "roshan";
	static final String petIdToDelete = "101299";

	@BeforeClass
	public void init() throws IOException {
		getObject("baseEndpoint");
	}

	@Test(priority = 0)
	public void getPetDetailsWithInvalidId() {
		expect().statusCode(400).and().when().get(baseEndpoint + "/api/v3/pet/{invalidPetId}", invalidPetId);
	}
	
	@Test(priority = 1)
	public void createStoreDetailsWithInvalidId() {
		
			JSONObject request = new JSONObject();
			request.put("id", "99999999999999999999");
			request.put("petId", "55");
			request.put("quantity", "50");
			Response res = given().contentType(ContentType.JSON).body(request.toJSONString()).when()
					.post(baseEndpoint + "/api/v3/store/order");
			res.then().statusCode(400);
			
	}
	
	@Test(priority = 2)
	public void updateUserDetailsWithInvalidId() {
		
		JSONObject request = new JSONObject();
		request.put("id", invalidUserId);
		request.put("username", username);
		request.put("firstname", "aryan");
		request.put("lastname", "d");
		request.put("email", "abcd@zya.com");
		request.put("password", "abcxdf@12o03");
		request.put("phone", "9999999999");
		Response res = given().contentType(ContentType.JSON).body(request.toJSONString()).when()
				.put(baseEndpoint + "/api/v3/user/{username}", invalidUserId);
		res.then().statusCode(400);
			
	}
	
}
