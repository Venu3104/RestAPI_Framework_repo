package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import javax.print.DocFlavor.STRING;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(req==null) {
		PrintStream log=new PrintStream(new File("logging.txt")); // logging file
		 req =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log)) // request logging
				 .addFilter(ResponseLoggingFilter.logResponseTo(log)) // response logging
			 .setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\venuy\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	
	public String getJsonPath(Response response,String key) {
		String respString=response.asString();
		JsonPath js= new JsonPath(respString);
		return js.get(key).toString();
	}

}
