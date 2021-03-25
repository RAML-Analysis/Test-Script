package requestvalidation;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RequestValidations 
{
	@Test
	public void missingEmailID()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 123654);
		parameter.put("username", "ravi");
		parameter.put("firstname", "ravi");
		parameter.put("lastname", "varma");
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
	}
	
	@Test
	public void missingUsername()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 123654);
//		parameter.put("username", "ravi");
		parameter.put("firstname", "ravi");
		parameter.put("lastname", "varma");
		parameter.put("email", "ravivarmacjjdcn@gmail.com");
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
	}
	
	@Test
	public void missingFirstname()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 123654);
		parameter.put("username", "ravi");
//		parameter.put("firstname", "ravi");
		parameter.put("lastname", "varma");
		parameter.put("email", "ravivarmacjjdcn@gmail.com");
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
	}
	
	@Test
	public void missingLastname()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 123654);
		parameter.put("username", "ravi");
		parameter.put("firstname", "ravi");
//		parameter.put("lastname", "varma");
		parameter.put("email", "ravivarmacjjdcn@gmail.com");
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
	}
	
	@Test
	public void missingPassword()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 123654);
		parameter.put("username", "ravi");
		parameter.put("firstname", "ravi");
		parameter.put("lastname", "varma");
		parameter.put("email", "ravivarmacjjdcn@gmail.com");
//		parameter.put("password", "123456789");
		parameter.put("phone", "9874563210");
		parameter.put("userStatus", 0);
		JSONArray json = new JSONArray();
		json.add(parameter);
		httprqst.header("Content-Type","application/json");
		httprqst.body(json.toJSONString());
		Response response=httprqst.request(Method.POST,"/user/createWithArray");
		int code=response.getStatusCode();
		Assert.assertEquals(200,code);
	}
	
	@Test
	public void missingPhone()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 123654);
		parameter.put("username", "ravi");
		parameter.put("firstname", "ravi");
		parameter.put("lastname", "varma");
		parameter.put("email", "ravivarmacjjdcn@gmail.com");
		parameter.put("password", "123456789");
//		parameter.put("phone", "9874563210");
		parameter.put("userStatus", 0);
		JSONArray json = new JSONArray();
		json.add(parameter);
		httprqst.header("Content-Type","application/json");
		httprqst.body(json.toJSONString());
		Response response=httprqst.request(Method.POST,"/user/createWithArray");
		int code=response.getStatusCode();
		Assert.assertEquals(200,code);
	}
	
	@Test
	public void missingUserStatus()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 123654);
		parameter.put("username", "ravi5486");
		parameter.put("firstname", "ravi");
		parameter.put("lastname", "varma");
		parameter.put("email", "ravivarmacjjdcn@gmail.com");
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
	}
	
	@Test
	public void negativeID() throws Exception
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", -123465);
		parameter.put("username", "ravivarma36");
		parameter.put("firstname", "ravi35");
		parameter.put("lastname", "varma35");
		parameter.put("email", "rvarmfdfa@gmail.com");
		parameter.put("password", "123456789");
		parameter.put("phone", "9874563210");
		parameter.put("userStatus", 0);
		JSONArray json = new JSONArray();
		json.add(parameter);
//		JSONObject schema=new JSONObject();
//		JSONParser jsonparser=new JSONParser();
//		FileReader reader=new FileReader(".\\schemas\\createUserRequestSchema.json");
//		Object obj1=jsonparser.parse(reader);
//		schema=(JSONObject)obj1;
		httprqst.header("Content-Type","application/json");
		httprqst.body(json.toJSONString());
		Response response=httprqst.request(Method.POST,"/user/createWithArray");
		int code=response.getStatusCode();
		Assert.assertEquals(200,code);
	}
	
	@Test
	public void testPhonePattern()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 1548759);
		parameter.put("username", "ravivarma39");
		parameter.put("firstname", "ravi35");
		parameter.put("lastname", "varma35");
		parameter.put("email", "rvafdgarma@gmail.com");
		parameter.put("password", "123456789");
		parameter.put("phone", "98745632105454211");
		parameter.put("userStatus", 0);
		JSONArray json = new JSONArray();
		json.add(parameter);
		httprqst.header("Content-Type","application/json");
		httprqst.body(json.toJSONString());
		Response response=httprqst.request(Method.POST,"/user/createWithArray");
		int code=response.getStatusCode();
		Assert.assertEquals(200,code);
	}
	
	@Test
	public void unavailableUserNameInGET()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		Response response=httprqst.request(Method.GET,"/user/abcde");
		Assert.assertEquals(404, response.getStatusCode());
	}
	
	
	@Test
	public void invalidEmailPattern()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject parameter=new JSONObject();
		parameter.put("id", 15487529);
		parameter.put("username", "ravivarma3958");
		parameter.put("firstname", "ravi356");
		parameter.put("lastname", "varma3525");
		parameter.put("email", "rvarma@@gmail.com");
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
	}
}
