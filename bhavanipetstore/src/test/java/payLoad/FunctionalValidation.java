package payLoad;

import java.util.Random;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.testng.Assert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.junit.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class FunctionalValidation {
	private long id;
	
	@Before
    public void start() throws Exception{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
	}
	
		//@Ignore
		 @Test
		 public void validfunctional_test()
		 {   
		 
		
		 RequestSpecification httpRequest = RestAssured.given();//sending request for the server
		
		 httpRequest.header("content-Type","application/json");
		 Random random = new Random();
    	 JSONObject json =new JSONObject();
    	 //JSONArray array=new JSONArray();
    	 
    	// json.put("id",random.nextInt(20));
    	 json.put("id",1050);
    	 JSONObject json1=new JSONObject();
    	 json1.put("id",2);
    	 json1.put("name","dog");
    	 json.put("category",json1);
    	 JSONArray array1=new JSONArray();
    	 array1.add("String");
    	 json.put("photoUrls",array1);
    	 JSONArray tag=new JSONArray();
    	 JSONObject item =new JSONObject();
    	 item.put("id",3);
    	 item.put("name","leo");
    	 tag.add(item);
    	 json.put("tags",tag);
    	 json.put("status","avilable");
    	// httpRequest.body(json.toJSONString());
    	// Response response = httpRequest.request(Method.POST, "/pet");//getting the response from the server
    	 httpRequest.body(json);
    	 Response response = httpRequest.post("/pet");
    	 Assert.assertEquals(200,response.getStatusCode());
    	  //int re=response.statusCode();
    	 response.getBody().prettyPrint();
    	 JsonPath jsonPath = response.jsonPath();
         id = jsonPath.getLong("id");
         System.out.println(id);
    

		 }
		 @Ignore
		 @Test
		 public void functional_test_validid()
		 {   
		 
		
		 RequestSpecification httpRequest = RestAssured.given();//sending request for the server
		
		 httpRequest.header("content-Type","application/json");
		 Response response = httpRequest.request(Method.GET, "/pet/1050");
		 Assert.assertEquals(200,response.getStatusCode());
		 
	
		 
}
		@Ignore
		 @Test
		 public void invalid_id()
		 {
			 RequestSpecification httpRequest = RestAssured.given();//sending request for the server
				
			 httpRequest.header("content-Type","application/json");
			 Response response = httpRequest.request(Method.GET, "/pet/1051");
		
			 response.prettyPrint();
		 Assert.assertEquals(404,response.getStatusCode());
			 		 }
		 
		//@Ignore
		 @Test
		 public void valid_data()
		 { RequestSpecification httpRequest = RestAssured.given();//sending request for the server
		
		 httpRequest.header("content-Type","application/json");
		 Response response = httpRequest.request(Method.GET, "/pet/1050");
		 JsonPath jsonPath = response.jsonPath();
		
		 System.out.println( jsonPath.get("category.name"));
		 int re=response.statusCode();
		 System.out.println(re);
		 Assert.assertEquals("dog",jsonPath.get("category.name"));
		 
		 
		 }
		 
		 }

