package petTest;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static petTest.ProjectConstants.BASE_URL;
import static petTest.ProjectConstants.END_POINT;

public class TestAPIPet {
	 private RequestSpecification requestSpecification;
     FileReader petData;
     File petData_invalid_id;
     Object obj;
     JSONObject op;
     JSONParser jsonParser;
   
	 @BeforeMethod
	public void setup() throws Exception{
		 petData = new FileReader("C:\\Java_training\\PracticeAPIPet\\src\\petData.json");
		 jsonParser = new JSONParser();
		 obj = jsonParser.parse(petData);
		 op = (JSONObject) obj;
		
		 
		RequestSpecBuilder requestSpecificationBuilder = new RequestSpecBuilder();
        requestSpecificationBuilder.setBaseUri(BASE_URL);
        requestSpecificationBuilder.setBasePath(END_POINT);
        requestSpecificationBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecificationBuilder.build();
	}
	@Test(enabled=false)
	public void validData() throws Exception, ParseException{	
		Response response=given(requestSpecification)
                .header("Content-type","application/json")   
				.body(op)
				.when()
				.post()
				.then()
				.statusCode(200)
				.extract().response();
		String re=response.prettyPrint();
	
	}
	@Test(enabled=false) //No Header
	public void validData_noHeader() throws Exception, ParseException{
		
		Response response=given(requestSpecification)  
				.body(op)
				.when()
				.post()
				.then()
				.statusCode(200)
				.extract().response();
		String re=response.prettyPrint();
	
	}
	@Test(enabled=false) //Test with invalid type for category
	public void Invalid_category_type(){
       op.put("category", 2);
       op.put("category", "string");
		Response response=given(requestSpecification)
                .header("Content-type","application/json")   
				.body(op)
				.when()
				.post()
				.then()
				.statusCode(500)
				.extract().response();
		String r=response.prettyPrint();
		
	}
	@Test //Test with invalid type for pets category id
	public void Invalid_Data_PetactegoryId(){
      op.put("category", new JSONObject().put("id", 100)); 
		Response response=given(requestSpecification)
                .header("Content-type","application/json")   
				.body(op)
				.when()
				.post()
				.then()
				.statusCode(200)
				.extract().response();
		String r=response.prettyPrint();
		
	}

	@Test(enabled=false) //Test with invalid type name actual it should be string but its taking integer
	public void Invalid_name(){
        op.remove("name");
        op.put("name", 2);
		Response response=given(requestSpecification)
                .header("Content-type","application/json")   
				.body(op)
				.when()
				.post()
				.then()
				.statusCode(200)
				.extract().response();
		String r=response.prettyPrint();
		
	}
	
	@Test(enabled=false) //Test with invalid type photourl actual it should be array but if we give other than that- error(500)
	public void Invalid_photoUrl_type(){
        op.remove("photoUrls");
        op.put("photoUrls", 2);
		Response response=given(requestSpecification)
                .header("Content-type","application/json")   
				.body(op)
				.when()
				.post()
				.then()
				.statusCode(500)
				.extract().response();
		String r=response.prettyPrint();
		
	}
	
	@Test(enabled=false) //Test with invalid type tags actual it should be array but if we give other than that-  error(500)
	public void Invalid_tags_type(){
        op.remove("tags");
        op.put("tags", 2);
		Response response=given(requestSpecification)
                .header("Content-type","application/json")   
				.body(op)
				.when()
				.post()
				.then()
				.statusCode(500)
				.extract().response();
		String r=response.prettyPrint();
		
	}
	@Test(enabled=false) //Test with invalid type status actual it should be string but if we give other than that no error 
	public void Invalid_status_type(){
        op.remove("status");
        op.put("status", 8);
		Response response=given(requestSpecification)
                .header("Content-type","application/json")   
				.body(op)
				.when()
				.post()
				.then()
				.statusCode(500)
				.extract().response();
		String r=response.prettyPrint();
		
	}
	
	

}
