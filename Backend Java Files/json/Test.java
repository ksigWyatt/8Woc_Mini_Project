package com.mykong.json;
import java.io.File;
import java.io.IOException;
//import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;

//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

 
public class Test {
 public static void main(String[] args) throws IOException {
	 JSONParser parser = new JSONParser();
	 ObjectMapper mapper = new ObjectMapper();
	 HttpClient client = HttpClientBuilder.create().build();
	 JSONObject obj = new JSONObject();
	 JSONItem items = new JSONItem();
	 IMG image = new IMG();
	 
	 HttpPost httppost = new HttpPost("http://172.19.144.219:12345/images");
	 FileBody bin = new FileBody(new File("/users/nicholasdipinto1/Desktop/template_e.png"));
	 HttpEntity reqEntity = MultipartEntityBuilder.create()
		        .addPart("bin", bin)
		        .build();
	httppost.setEntity(reqEntity);
	HttpResponse response = client.execute(httppost);
	
	//try(FileWriter file = new FileWriter(""))
	
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    JSONObject temp = mapper.readValue(EntityUtils.toString(response.getEntity()), JSONObject.class);
    
   /* for (int i = 0; i < letters.length; i++) {
		for (int j = 0; j < 1; j++) {	
			System.out.println("the X_dim value is " + items.getX_dim());
			System.out.println("the Y_dim value is " + items.getY_dim());
			System.out.println("the x_start value is " + items.getX_start());
			System.out.println("the Y_start value is " + items.getY_start());
			for (int z = 0; z < 100; z++) {
//					hash.put(z, IMG.getValue());
			}
		}
	}*/
 }
}