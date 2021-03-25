package functionalValidation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Store_FunctionalValidation 
{

	@BeforeTest
	public void setup()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
	}
	
	@Test(priority=1)
	public void testwithValidRequest()
	{
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		
		JSONObject request=new JSONObject();
		request.put("id",9);
		request.put("petId",3);
		request.put("quantity",2);
		request.put("shipDate","2021-03-22T11:58:16.462Z");
		request.put("status","placed");
		request.put("complete",false);
		
		httprequest.body(request.toJSONString());
		Response response=httprequest.request(Method.POST, "/store/order");
	    JsonPath jp=new JsonPath(response.body().asString());
	    Assert.assertEquals(null,jp.get("message"));
	    Assert.assertEquals(200,response.getStatusCode());
		response.getBody().prettyPrint();
		
	}
	@Test
	public void testwithNegativeID()//should get 400 but getting 200
	{
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		
		JSONObject request=new JSONObject();
		request.put("id",-67);
		request.put("petId",1);
		request.put("quantity",6);
		request.put("shipDate","2021-03-22T11:58:16.462Z");
		request.put("status","placed");
		request.put("complete",false);
		
		httprequest.body(request.toJSONString());
		Response response=httprequest.request(Method.POST, "/store/order");	    
	    Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
		
	}
	@Test
	public void testwithMaxID()//should get 400 but getting 200
	{
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		
		JSONObject request=new JSONObject();
		request.put("id",1234567890);
		request.put("petId",4);
		request.put("quantity",1);
		request.put("shipDate","2021-03-22T11:58:16.462Z");
		request.put("status","placed");
		request.put("complete",false);
		
		httprequest.body(request.toJSONString());
		Response response=httprequest.request(Method.POST, "/store/order");	    
	    Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
		
	}
	@Test
	public void getrequestwithValidID()
	{
			RequestSpecification httprequest= RestAssured.given();
			httprequest.header("Content-Type","application/json");
			
			Response response=httprequest.request(Method.GET, "/store/order/9");
		    Assert.assertEquals(200,response.getStatusCode());
			response.getBody().prettyPrint();
			
	}
	
	@Test
	public void getrequestwithInValidID()
	{
			RequestSpecification httprequest= RestAssured.given();
			httprequest.header("Content-Type","application/json");
			
			Response response=httprequest.request(Method.GET, "/store/order/11222222222");		
		    Assert.assertEquals(404,response.getStatusCode());
			response.getBody().prettyPrint();
			
	}
}

