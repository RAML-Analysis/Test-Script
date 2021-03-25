package petTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;


public class FunctionalValidation {
	
	 @BeforeClass
	    public void start() throws Exception{
	        RestAssured.baseURI="https://petstore.swagger.io/v2";
	    }
	@Test(enabled=false)
	public void functional_valid_test(){
		
		RequestSpecification request = RestAssured.given(); //sending request for the server
		    
	         JSONObject json =new JSONObject();	         
	         json.put("id",12);
	         JSONObject json1=new JSONObject();
	         json1.put("id",2);
	         json1.put("name","dog");
	         json.put("category",json1);
	         JSONArray array1=new JSONArray();
	         array1.add("String");
	         json.put("photoUtls",array1);
	         JSONArray tag=new JSONArray();
	         JSONObject item =new JSONObject();
	         item.put("id",3);
	         item.put("name","leo");
	         tag.add(item);
	         json.put("tags",tag);
	         json.put("status","avilable");
	         request.header("content-Type","application/json");
	         request.body(json.toJSONString());
	        
	         Response response = request.post("/pet");//getting the response from the server
	         Assert.assertEquals(200,response.getStatusCode());
	         response.getBody().prettyPrint();
//	         JsonPath jsonPath = response.jsonPath();
//	         id = jsonPath.getLong("id");
//	         System.out.println(id);
	    

	 

	         }
	 @Test(enabled=false)
     public void valid_id()
     {   
     
    
     RequestSpecification request = RestAssured.given();//sending request for the server
    
     request.header("content-Type","application/json");
     Response response = request.get("/pet/12");
     response.prettyPrint();
     
}
  
     @Test(enabled=false)
     public void invalid_id()
     {
         RequestSpecification request = RestAssured.given();//sending request for the server
            
         request.header("content-Type","application/json");
         Response response = request.get("/pet/13");
         response.prettyPrint();
         Assert.assertEquals(404,response.getStatusCode());
                  }
     @Test
     public void missing_header()
     { 
     RequestSpecification request = RestAssured.given();//sending request for the server
     JSONObject json =new JSONObject();	         
     json.put("id",12);
     JSONObject json1=new JSONObject();
     json1.put("id",2);
     json1.put("name","dog");
     json.put("category",json1);
     JSONArray array1=new JSONArray();
     array1.add("String");
     json.put("photoUtls",array1);
     JSONArray tag=new JSONArray();
     JSONObject item =new JSONObject();
     item.put("id",3);
     item.put("name","leo");
     tag.add(item);
     json.put("tags",tag);
     json.put("status","avilable");
    // request.header("content-Type","application/json");
     request.body(json.toJSONString());
     Response response = request.post("/pet/12"); 
     Assert.assertEquals(415,response.getStatusCode());
     response.prettyPrint();
     
     }
     
     }

	
	
    
   
    