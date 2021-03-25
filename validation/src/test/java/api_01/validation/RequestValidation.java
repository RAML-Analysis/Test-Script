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

public class RequestValidation 
{
	RequestSpecification httprqst= RestAssured.given();

	@BeforeMethod
	public void url()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
	}

	//PlaceOrderRequestSchema
	@Test
	public void requiredField()
	{
		httprqst.header("Content-Type","application/json");
		Response response=httprqst.request(Method.POST, "/store/order");
		Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
	}

	@Test
	public void postMissingId()
	{
		httprqst.header("Content-Type","application/json");	
		JSONObject request1=new JSONObject();
		request1.put("petId",4);
		request1.put("quantity",1);
		request1.put("shipDate","2021-03-22T11:58:16.462Z");
		request1.put("status","placed");
		request1.put("complete",false);

		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST, "/store/order");
		Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
	}

	@Test
	public void postMissingPetId()
	{
		httprqst.header("Content-Type","application/json");

		JSONObject request1=new JSONObject();
		request1.put("id",3);
		request1.put("quantity",1);
		request1.put("shipDate","2021-03-22T11:58:16.462Z");
		request1.put("status","placed");
		request1.put("complete",false);

		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST, "/store/order");
		Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
	}

	@Test
	public void PostInvalidDate()
	{
		httprqst.header("Content-Type","application/json");

		JSONObject request1=new JSONObject();
		request1.put("id",3);
		request1.put("petId",4);
		request1.put("quantity",1);
		request1.put("shipDate","2021/03/22");
		request1.put("status","placed");
		request1.put("complete",false);

		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST, "/store/order");
		Assert.assertEquals(500,response.getStatusCode());
		response.getBody().prettyPrint();

	}
	@Test
	public void postMissingStatus()
	{
		httprqst.header("Content-Type","application/json");

		JSONObject request1=new JSONObject();
		request1.put("id",3);
		request1.put("petId",4);
		request1.put("quantity",1);
		request1.put("shipDate","2021-03-22T11:58:16.462Z");
		//request1.put("status","placed");
		request1.put("complete",false);

		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST, "/store/order");
		JsonPath jp=new JsonPath(response.body().asString());
		Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
	}

	//PlceOrderResponseSchema
	@Test
	public void postMissingIdRes()
	{
		httprqst.header("Content-Type","application/json");

		JSONObject request1=new JSONObject();
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
	public void postMissingPetIdRes()
	{
		httprqst.header("Content-Type","application/json");

		JSONObject request1=new JSONObject();
		request1.put("id",3);
		request1.put("quantity",1);
		request1.put("shipDate","2021-03-22T11:58:16.462Z");
		request1.put("status","placed");
		request1.put("complete",false);

		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST, "/store/order");
		JsonPath jp=new JsonPath(response.body().asString());
		Assert.assertEquals(200,response.getStatusCode());
		response.getBody().prettyPrint();
	}

	@Test
	public void PostInvalidDateRes()
	{
		httprqst.header("Content-Type","application/json");

		JSONObject request1=new JSONObject();
		request1.put("id",3);
		request1.put("petId",4);
		request1.put("quantity",1);
		request1.put("shipDate","2021/03/22");
		request1.put("status","placed");
		request1.put("complete",false);

		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST, "/store/order");
		Assert.assertEquals(500,response.getStatusCode());
		response.getBody().prettyPrint();

	}
	@Test
	public void postMissingStatusRes()
	{
		httprqst.header("Content-Type","application/json");

		JSONObject request1=new JSONObject();
		request1.put("id",3);
		request1.put("petId",4);
		request1.put("quantity",1);
		request1.put("shipDate","2021-03-22T11:58:16.462Z");
		//request1.put("status","placed");
		request1.put("complete",false);

		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST, "/store/order");
		Assert.assertEquals(200,response.getStatusCode());
		response.getBody().prettyPrint();
	}



}
