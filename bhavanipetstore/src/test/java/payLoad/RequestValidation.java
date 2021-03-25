package payLoad;

import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestValidation {
	@Before
    public void startup() throws Exception{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
	}
	    @Ignore
		@Test
		 public void misssingheader_rv()
		 {   
		 
		
		 RequestSpecification httpRequest = RestAssured.given();//sending request for the server
		
		 //httpRequest.header("content-Type","application/json");
		 Random random = new Random();
   	 JSONObject json =new JSONObject();
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
   	 httpRequest.body(json.toJSONString());
   	 Response response = httpRequest.post("/pet");
   	 Assert.assertEquals(415,response.getStatusCode());
   	  //int re=response.statusCode();
   	 response.getBody().prettyPrint();
	}
		
	 @Ignore
	@Test
	public void invalid_id_type()                     
	{

	 RequestSpecification httpRequest = RestAssured.given();//sending request for the server
	
	 httpRequest.header("content-Type","application/json");
	 Random random = new Random();
	 JSONObject json =new JSONObject();
	 json.put("id","abc");
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
	 item.put("name","bjdfs");
	 tag.add(item);
	 json.put("tags",tag);
	 json.put("status","avilable");
	 httpRequest.body(json.toJSONString());
	 Response response = httpRequest.post("/pet");
	 Assert.assertEquals(500,response.getStatusCode());
	int re= response.getStatusCode();
	System.out.println(re);

}
	@Ignore
	@Test
	public void invalid_categoryid_tagid_type()                     
	{

	 RequestSpecification httpRequest = RestAssured.given();//sending request for the server
	
	 httpRequest.header("content-Type","application/json");
	 Random random = new Random();
	 JSONObject json =new JSONObject();
	 json.put("id",1050);
	 JSONObject json1=new JSONObject();
	 json1.put("id","abc");
	 json1.put("name","dog");
	 json.put("category",json1);
	 JSONArray array1=new JSONArray();
	 array1.add("String");
	 json.put("photoUrls",array1);
	 JSONArray tag=new JSONArray();
	 JSONObject item =new JSONObject();
	 item.put("id","abcd");
	 tag.add(item);
	 json.put("name","leo");
	 
	 json.put("tags",tag);
	 json.put("status","avilable");
	 httpRequest.body(json.toJSONString());
	 Response response = httpRequest.post("/pet");
	Assert.assertEquals(500,response.getStatusCode());
	int re= response.getStatusCode();
	System.out.println(re);

	
}
	@Test
	public void invalid_categoryname_type()                     
	{

	 RequestSpecification httpRequest = RestAssured.given();//sending request for the server
	
	 httpRequest.header("content-Type","application/json");
	 Random random = new Random();
	 JSONObject json =new JSONObject();
	 json.put("id",-1);
	// JSONArray array=new JSONArray();
	 JSONObject json1=new JSONObject();
	 json1.put("id",2);
	 json1.put("name",54);
	json.put("category",json1);
	 JSONArray array1=new JSONArray();
	 array1.add("String");
	 json.put("photoUrls",array1);
	 JSONArray tag=new JSONArray();
	 JSONObject item =new JSONObject();
	 item.put("id",3);
	 json.put("name",4);
	 tag.add(item);
	 json.put("tags",tag);
	 json.put("status","avilable");
	 httpRequest.body(json.toJSONString());
	 Response response = httpRequest.post("/pet");
	//Assert.assertEquals(500,response.getStatusCode());
	int re= response.getStatusCode();
	System.out.println(re);
	
}
}