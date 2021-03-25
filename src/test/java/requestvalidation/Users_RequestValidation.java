package requestvalidation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Users_RequestValidation {
	
	@BeforeTest
	public void bt()
	{
		baseURI="https://petstore.swagger.io/v2";
	}

	@Test
	public void Validfieldtest()
	{
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Content-Type","application/json");
		JSONObject request = new JSONObject();
		
		request.put("id",3);
		request.put("username" ,"nithinka");
		request.put("firstName" ,"Nithin");
		request.put("lastName" ,"Kashiyap");
		request.put("email", "abc@gmail.com");
		request.put("password" ,"nithin123");
		request.put("phone", "9986085892");
		request.put("userStatus", 0);
		
		httprequest.body(request.toJSONString());
		Response response = httprequest.request(Method.POST,"/user");
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.statusCode());
		
		
	}
	
	@Test
	public void Invalidfieldtest()
	{
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Content-Type","application/json");
		JSONObject request = new JSONObject();
		
		request.put("id",4);
		request.put("username" ,"nithinkas");
		request.put("firstName" ,"Nithin");
		request.put("lastName" ,"Kashiyap");
		request.put("email", "abc@gmail.com");
		request.put("password" ,"nithin123");
		request.put("phone", "9986085892");
		request.put("userStatus", 0);
		
		httprequest.body(request.toJSONString());
		Response response = httprequest.request(Method.POST,"/user");//(Method.POST,"/user/createWithArray");
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.statusCode());
		
	}
	
	@Test
	public void InvalidContentType()
	{
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Content-Type","text/plain");
		JSONObject request = new JSONObject();
		
		request.put("id",5);
		request.put("username" ,"nithinkashi");
		request.put("firstName" ,"Nithin");
		request.put("lastName" ,"Kashiyap");
		request.put("email", "abc@gmail.com");
		request.put("password" ,"nithin123");
		request.put("phone", "9986085892");
		request.put("userStatus", 0);
		
		
		httprequest.body(request.toJSONString());
		Response response = httprequest.request(Method.POST,"/user");//(Method.POST,"/user/createWithArray");
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 415);
		System.out.println(response.statusCode());
		/*given()
			.contentType(ContentType.TEXT)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/user")
		.then().statusCode(200).log().all();*/
		
		
		
	}
	
}
