package payLoad;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PayLoad_Request {
public static void data()
{
	

JSONObject json =new JSONObject();
JSONArray array=new JSONArray();
json.put("id",4);
JSONObject json1=new JSONObject();
json1.put("id","2");
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




}

}
