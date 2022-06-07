package ip.swagger.resources.publicURL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import io.restassured.internal.support.FileReader;
import ip.swagger.petstoretests.publicURL.NegativeTest;
import ip.swagger.petstoretests.publicURL.PetStoreTest;
import ip.swagger.petstoretests.publicURL.StoreTest;
import ip.swagger.petstoretests.publicURL.UsersTest;


public class ReadConfigUtility {

	protected static Properties prop;


	public static void readPropertiesFile() throws IOException {

		prop = new Properties();
		FileInputStream ip = new FileInputStream("src/test/java/ip/swagger/resources/publicURL/config.properties");
		prop.load(ip);
		PetStoreTest.baseEndpoint = prop.getProperty("baseEndpoint");
		UsersTest.baseEndpoint = prop.getProperty("baseEndpoint");
		StoreTest.baseEndpoint = prop.getProperty("baseEndpoint");
		NegativeTest.baseEndpoint = prop.getProperty("baseEndpoint");
	}
	
	public static String getObject(String Data) throws IOException
	{
		readPropertiesFile();
		String data = prop.getProperty(Data);
		return data;
	}
	
}
