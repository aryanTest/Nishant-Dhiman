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

public class PetStoreTest extends ReadConfigUtility {

	public static String baseEndpoint;
	static final String petId = "101";
	static final String petIdToDelete = "10";

	@BeforeClass
	public void init() throws IOException {
		getObject("baseEndpoint");
	}

	@Test(priority = 0)
	public void createNewPet() {
		JSONObject request = new JSONObject();
		request.put("id", "101");
		request.put("name", "newProductTest");
		// This Request is by default created in such a manner that it will get executed
		// with 200 Success Code
		Response res = given().contentType(ContentType.JSON).body(request.toJSONString()).when()
				.post(baseEndpoint + "/pet");
		res.then().statusCode(200);
		String responseBody = res.getBody().asString();
		try {

			FileWriter file = new FileWriter("src/test/java/responseForProductCreation.json");
			file.write(responseBody);
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void searchPetByID() {

		expect().statusCode(200).and().when().get(baseEndpoint + "/pet/{petId}", petId);
	}

	@Test(priority = 2)
	public void updatePet() {
		JSONObject request = new JSONObject();
		request.put("id", "10");
		request.put("name", "sampleTest");
		Response res = given().contentType(ContentType.JSON).body(request.toJSONString()).when()
				.put(baseEndpoint + "/pet");
		res.then().statusCode(200);
		String responseBody = res.getBody().asString();
		try {

			FileWriter file = new FileWriter("src/test/java/responseForProductUpdate.json");
			file.write(responseBody);
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 3)
	public void deletePetByID() {
		expect().statusCode(200).and().when().delete(baseEndpoint + "/pet/{petId}", petIdToDelete);
	}
}
