package com.shelly.jsonpoc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class JsonpocApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JsonpocApplication.class, args);
		new JsonpocApplication().readJson();
	}
	
	public void readJson() throws Exception
	{
		   File file = new File("continents.json");
		   String content = FileUtils.readFileToString(file);
		    
		    // Convert JSON string to JSONObject
		   JSONArray jsonFileArray = new JSONArray(content); 
		   System.out.println("continents="+getAllContinents(jsonFileArray,"continent"));
		   System.out.println(getCountryByContinent(jsonFileArray,"America"));
	}
	
	private Map<String,String> getCountryByContinent(JSONArray jsonFileArray,String continent) throws Exception
	{
		Map<String,String> countryMap =new HashMap<>();
		
		for (int i = 0; i < jsonFileArray.length(); i++) {
			JSONObject jsonObject=jsonFileArray.getJSONObject(i);
			if(jsonObject.get("continent").equals(continent))  
			{
				JSONArray countries=jsonObject.getJSONArray("countries");	
				for (int j = 0; j < countries.length(); j++) {
					JSONObject countryObj= (JSONObject) countries.get(j);
					String flag =(String) countryObj.get("flag");
					String name =(String) countryObj.get("name");
					System.out.println(flag);
					System.out.println(name);
					countryMap.put(flag, name);
				}
				
			}
			   
			   
		}
		return countryMap;
		
	}
	private List<String> getAllContinents(JSONArray jsonFileArray,String type) throws Exception
	{
		List<String> enitity =new ArrayList<>();
		String jsonElement=null;
		 for (int i = 0; i < jsonFileArray.length(); i++) {
			   jsonElement=(String) jsonFileArray.getJSONObject(i).get(type);
			   enitity.add(jsonElement);
		}
		 return enitity;
	}
}
