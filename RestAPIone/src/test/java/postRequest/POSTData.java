package postRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import com.sun.tools.jxc.ConfigReader;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;
import io.restassured.matcher.RestAssuredMatchers;


public class POSTData {
	
	@Test
	public void test1() {
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		
			
		json.put( "name", "morpheux");
		json.put( "job", "leaderx");
	

		
		request.body(json.toJSONString());
		
		Response response = request.post("https://reqres.in/api/users");
		
		int code = response.getStatusCode();
		
		Assert.assertEquals(code, 201);
		
        String data = response.asString();
		
		System.out.println("The data is as below --->"  +data);
		
		System.out.println("Response Time is ---> "   +response.getTime());
		
		
		
	}

}
