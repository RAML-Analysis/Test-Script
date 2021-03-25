package functionalvalidation;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Users_FunctionalValidation {
	
 RequestSpecification httprequest;
 Response response;
	
	@BeforeTest
	public void bt()
	{
		 httprequest = RestAssured.given();
		baseURI="https://petstore.swagger.io/v2";
	}

	@Test
	public void test1()
	{
		RequestSpecification httprequest = RestAssured.given();
		response = httprequest.request(Method.GET, "/user/nithin");
		
		
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.statusCode());
	}
	
	@Test
	public void Negativefieldtest()
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
		
	    response = httprequest.post("/user");
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(response.statusCode());
		JsonPath jp=new JsonPath(response.body().asString());
		Assert.assertEquals("unknown", jp.get("type"));
		Assert.assertEquals("4", jp.get("message"));
		response.then().assertThat().body(matchesJsonSchema("createUserResponseSchema.jsd"));
	}
	
	@Test
	public void Invalidusername()
	{

		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Content-Type","application/json");
		JSONObject request = new JSONObject();
		
		request.put("id",9);
		request.put("username" ,2);
		request.put("firstName" ,"Nithin");
		request.put("lastName" ,"Kashiyap");
		request.put("email", "abc@gmail.com");
		request.put("password" ,"nithin123");
		request.put("phone", "9986085892");
		request.put("userStatus", 0);
		
        httprequest.body(request.toJSONString());
		
	    response = httprequest.post("/user");
		response.getBody().prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(response.statusCode());
		JsonPath jp=new JsonPath(response.body().asString());
		Assert.assertEquals("unknown", jp.get("type"));
		Assert.assertEquals("9", jp.get("message"));
		
		
		
	}

}
