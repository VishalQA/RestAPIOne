package getRequest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DemoGetData {
	
	
	@Test (priority = 1)
	public void testresponsecode() {
		
		Response result  = get("http://localhost:3030/products");
		int code = result.getStatusCode();
		System.out.println("Status code is ---> "  +code);
		
		Assert.assertEquals(code, 200);
	}
	
	@Test (priority = 2)
	public void testbody() {
		Response result = get("http://localhost:3030/products");
		
		String data = result.asString();
		
		System.out.println("The data is as below --->"  +data);
		
		System.out.println("Response Time is ---> "   +result.getTime());
		
		
	}

}

