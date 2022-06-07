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

public class StoreTest extends ReadConfigUtility {

	public static String baseEndpoint;
	static final String orderId = "102";
	
	@BeforeClass
	public void init() throws IOException {
		getObject("baseEndpoint");
	}

	@Test(priority = 0)
	public void createNewOrder() {
		JSONObject request = new JSONObject();
		request.put("id", "102");
		request.put("petId", "55");
		request.put("quantity", "50");
		Response res = given().contentType(ContentType.JSON).body(request.toJSONString()).when()
				.post(baseEndpoint + "/store/order");
		res.then().statusCode(200);
		String responseBody = res.getBody().asString();
		try {

			FileWriter file = new FileWriter("src/test/java/responseForOrderCreation.json");
			file.write(responseBody);
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void searchOrders() {

		expect().statusCode(200).and().when().get(baseEndpoint + "/store/inventory");
	}

	@Test(priority = 2)
	public void searchOrderByID() {

		expect().statusCode(200).and().when().get(baseEndpoint + "/store/order/{orderId}", orderId);
	}
}
