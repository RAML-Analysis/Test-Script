package requestValidation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Store_requestValidation 
{
	String endpoint = "/store/order";
	@BeforeTest
	public void setup()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
	}
	
	@Test
	 public void testwithEmptyRequiredFields()
	  {
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		
		Response response=httprequest.request(Method.POST, endpoint);    
		Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
	  }
	 
	@Test
	public void testwithMissingId()//should get 400 but getting 200
	{
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		
		JSONObject request=new JSONObject();
		request.put("petId",4);
		request.put("quantity",1);
		request.put("shipDate","2021-03-22T11:58:16.462Z");
		request.put("status","placed");
		request.put("complete",true);
		
		httprequest.body(request.toJSONString());
		Response response=httprequest.request(Method.POST, "endpoint");
	    Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
	}
	
	@Test
	public void testwithMissingPetId()//should get 400 but getting 200
	{
	RequestSpecification httprequest= RestAssured.given();
	httprequest.header("Content-Type","application/json");
	
	JSONObject request=new JSONObject();
	request.put("id",4);
	request.put("quantity",1);
	request.put("shipDate","2021-03-22T11:58:16.462Z");
	request.put("status","placed");
	request.put("complete",false);
	
	httprequest.body(request.toJSONString());
	Response response=httprequest.request(Method.POST, endpoint);
    Assert.assertEquals(400,response.getStatusCode());
	response.getBody().prettyPrint();
	}
	
	@Test
	public void testwithMissingQuantity()//should get 400 but getting 200
	{
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		
		JSONObject request=new JSONObject();
		request.put("id",2);
		request.put("petId",2);
		request.put("shipDate","2021-03-22");
		request.put("status","placed");
		request.put("complete",true);
		
		httprequest.body(request.toJSONString());
		Response response=httprequest.request(Method.POST, endpoint);
	    Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
		
	}
	
	@Test
	public void testwithInvalidShipDate()
	{
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		
		JSONObject request=new JSONObject();
		request.put("id",3);
		request.put("petId",4);
		request.put("quantity",1);
		request.put("shipDate","2021/22/03");
		request.put("status","placed");
		request.put("complete",false);
		
		httprequest.body(request.toJSONString());
		Response response=httprequest.request(Method.POST, endpoint);	    
	    Assert.assertEquals(500,response.getStatusCode());
		response.getBody().prettyPrint();
		
	}
	
	@Test
	public void testwithMissingShipDate()//should get 400 but getting 200
	{
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		
		JSONObject request=new JSONObject();
		request.put("id",3);
		request.put("petId",4);
		request.put("quantity",1);
		request.put("status","placed");
		request.put("complete",false);
		
		httprequest.body(request.toJSONString());
		Response response=httprequest.request(Method.POST, endpoint);
	    Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
		
	}
	
	@Test
	public void testwithMissingStatus()//should get 400 but getting 200
	{
	RequestSpecification httprequest= RestAssured.given();
	httprequest.header("Content-Type","application/json");
	
	JSONObject request=new JSONObject();
	request.put("id",2);
	request.put("petId",2);
	request.put("quantity",2);
	request.put("shipDate","2021-03-22T11:58:16.462Z");
	request.put("complete",true);
	
	httprequest.body(request.toJSONString());
	Response response=httprequest.request(Method.POST, endpoint);
    Assert.assertEquals(400,response.getStatusCode());
	response.getBody().prettyPrint();
	}
	
	@Test
	public void testwithInvalidIdType()//should get 400 but getting 200
	{
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		
		JSONObject request=new JSONObject();
		request.put("id","3");
		request.put("petId",4);
		request.put("quantity",1);
		request.put("shipDate","2021-03-22T11:58:16.462Z");
		request.put("status","placed");
		request.put("complete",true);
		
		httprequest.body(request.toJSONString());
		Response response=httprequest.request(Method.POST, endpoint);
	    Assert.assertEquals(400,response.getStatusCode());
		response.getBody().prettyPrint();
	}
	
	@Test
	public void testwithAllFields()
	{
		RequestSpecification httprequest= RestAssured.given();
		httprequest.header("Content-Type","application/json");
		
		JSONObject request=new JSONObject();
		request.put("id",9);
		request.put("petId",8);
		request.put("quantity",2);
		request.put("shipDate","2021-03-22T11:58:16.462Z");
		request.put("status","placed");
		request.put("complete",true);
		
		httprequest.body(request.toJSONString());
		Response response=httprequest.request(Method.POST, endpoint);	    
	    Assert.assertEquals(200,response.getStatusCode());
		response.getBody().prettyPrint();
		JsonPath jp=new JsonPath(response.body().asString());
		String ids = jp.get("id").toString();
	    System.out.println("ID: " + ids);
	}
}
