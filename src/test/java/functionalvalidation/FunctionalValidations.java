package functionalvalidation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.io.FileReader;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FunctionalValidations 
{
	@Test()
	public void awithAllValidFields()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 123654984);
		parameter.put("username", "ravi99");
		parameter.put("firstname", "ravi6597");
		parameter.put("lastname", "varma");
		parameter.put("email", "rvarma@gmail.com");
		parameter.put("password", "123456789");
		parameter.put("phone", "9874563210");
		parameter.put("userStatus", 0);
		JSONArray json = new JSONArray();
		json.add(parameter);
		httprqst.header("Content-Type","application/json");
		httprqst.body(json.toJSONString());
		Response response=httprqst.request(Method.POST,"/user/createWithArray");
		int code=response.getStatusCode();
		Assert.assertEquals(200,code);
		JsonPath jo=new JsonPath(response.body().asString());
		Assert.assertEquals("ok", jo.get("message"));
		Assert.assertEquals("unknown", jo.get("type"));
	}
	
	@Test
	public void awithMissingUserStatus()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 9856);
		parameter.put("username", "srihari");
		parameter.put("firstname", "ravi6597");
		parameter.put("lastname", "varma");
		parameter.put("email", "rvarma@gmail.com");
		parameter.put("password", "123456789");
		parameter.put("phone", "9874563210");
//		parameter.put("userStatus", 0);
		JSONArray json = new JSONArray();
		json.add(parameter);
		httprqst.header("Content-Type","application/json");
		httprqst.body(json.toJSONString());
		Response response=httprqst.request(Method.POST,"/user/createWithArray");
		int code=response.getStatusCode();
		Assert.assertEquals(200,code);
		JsonPath jo=new JsonPath(response.body().asString());
		Assert.assertEquals("ok", jo.get("message"));
		Assert.assertEquals("unknown", jo.get("type"));
	}
	
	@Test
	public void errorWithoutBody()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		Response response=httprqst.request(Method.POST,"/user/createWithArray");
		JsonPath jo=new JsonPath(response.body().asString());
		Assert.assertEquals(415,response.getStatusCode());
		Assert.assertEquals("unknown", jo.get("type"));
		
	}
	
	@Test
	public void checkGetForInvalidIDGiven()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", -100123);
		parameter.put("username", "ravi9876");
		parameter.put("firstname", "ravi6597");
		parameter.put("lastname", "varma");
		parameter.put("email", "rvarma@gmail.com");
		parameter.put("password", "123456789");
		parameter.put("phone", "9874563210");
		parameter.put("userStatus", 0);
		JSONArray json = new JSONArray();
		json.add(parameter);
		httprqst.header("Content-Type","application/json");
		httprqst.body(json.toJSONString());
		Response response=httprqst.request(Method.POST,"/user/createWithArray");
		Response response2=httprqst.request(Method.GET,"/user/ravi9875");
		String body=response2.getBody().asString();
		Assert.assertEquals(200, response2.getStatusCode());
		Assert.assertTrue(body.contains("-100123"));
		
	}
	
	@Test
	public void perfectGET()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		Response response=httprqst.request(Method.GET,"/user/ravi99");
		response.then().assertThat().body(matchesJsonSchema(new File(".\\schemas\\getUserDetailsResponseSchema.jsd")));
		JsonPath jp=new JsonPath(response.body().asString());
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals(123654984, jp.get("id"));
		Assert.assertEquals("ravi99", jp.get("username"));
		Assert.assertEquals("rvarma@gmail.com", jp.get("email"));
		Assert.assertEquals("123456789", jp.get("password"));
		Assert.assertEquals("9874563210", jp.get("phone"));
		Assert.assertEquals(0, jp.get("userStatus"));
	}
	
	@Test
	public void testGETResponseMissingFields()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		Response response=httprqst.request(Method.GET,"/user/srihari");
		response.prettyPrint();
		response.then().assertThat().body(matchesJsonSchema(new File(".\\schemas\\getUserDetailsResponseSchema.jsd")));
		JsonPath jp=new JsonPath(response.body().asString());
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals(9856, jp.get("id"));
		Assert.assertEquals("srihari", jp.get("username"));
		Assert.assertEquals("rvarma@gmail.com", jp.get("email"));
		Assert.assertEquals("123456789", jp.get("password"));
		Assert.assertEquals("9874563210", jp.get("phone"));
//		Assert.assertEquals(0, jp.get("userStatus"));
	}
}
