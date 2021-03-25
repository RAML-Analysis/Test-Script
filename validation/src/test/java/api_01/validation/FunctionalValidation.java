package api_01.validation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FunctionalValidation 
{
	RequestSpecification httprqst= RestAssured.given();

	@BeforeMethod
	public void url()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
	}

	@Test
	public void postValidField()
	{
		httprqst.header("Content-Type","application/json");

		JSONObject request1=new JSONObject();
		request1.put("id",1122222222);
		request1.put("petId",4);
		request1.put("quantity",1);
		request1.put("shipDate","2021-03-22T11:58:16.462Z");
		request1.put("status","placed");
		request1.put("complete",false);

		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST, "/store/order");
		Assert.assertEquals(200,response.getStatusCode());
		response.getBody().prettyPrint();

	}
	@Test
	public void postNegativeId()
	{
		httprqst.header("Content-Type","application/json");

		JSONObject request1=new JSONObject();
		request1.put("id",-23);
		request1.put("petId",4);
		request1.put("quantity",1);
		request1.put("shipDate","2021-03-22T11:58:16.462Z");
		request1.put("status","placed");
		request1.put("complete",false);

		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST, "/store/order");
		Assert.assertEquals(200,response.getStatusCode());
		response.getBody().prettyPrint();

	}
	@Test
	public void getValidField()
	{
		httprqst.header("Content-Type","application/json");

		Response response=httprqst.request(Method.GET, "/store/order/3");
		Assert.assertEquals(200,response.getStatusCode());
		response.getBody().prettyPrint();

	}

	@Test
	public void getInValidId()
	{
		httprqst.header("Content-Type","application/json");

		Response response=httprqst.request(Method.GET, "/store/order/11222222222");
		Assert.assertEquals(404,response.getStatusCode());
		response.getBody().prettyPrint();

	}
}
