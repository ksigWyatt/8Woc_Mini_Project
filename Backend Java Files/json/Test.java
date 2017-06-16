package faffimg;

import java.util.*;
//import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

 
public class Test {
	
	//this is useful because the Type of the list needs to be a JSON Item,
	//because we are receiving an Array of type JSONItem
	List<JSONItem> JSONItemtList;
	public List<JSONItem> getJSONList() {
		return JSONItemtList;
	}
	public void setRandomList(ArrayList<JSONItem> JSONItems) {
		this.JSONItemtList = JSONItems;
	}
	
 public static void main(String[] args) throws ClassNotFoundException, 
	JsonParseException, JsonMappingException , IOException {
	 
	 JSONParser parser = new JSONParser();
	 ObjectMapper mapper = new ObjectMapper();
	 HttpClient client = HttpClientBuilder.create().build();
	 
	 HttpPost httppost = new HttpPost("http://172.19.144.219:12345/images");
	 FileBody bin = new FileBody(new File("testing.png"));
	 HttpEntity reqEntity = MultipartEntityBuilder.create()
		        .addPart("bin", bin)
		        .build();
	httppost.setEntity(reqEntity);
	HttpResponse response = client.execute(httppost);
	
	
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
    String jsonString = EntityUtils.toString(response.getEntity());
    ArrayList<JSONItem> temp = mapper.readValue(jsonString, new TypeReference<ArrayList<JSONItem>>() {});
    
    int i = 0;
    
    System.out.println("There are " + temp.size() + " letters found. \n" );
    
    for (JSONItem j: temp){
    	System.out.println("Letter number " + i);
    	System.out.println("X Start "+ j.getX_start());
    	System.out.println("Y Start " + j.getY_start());
    	System.out.println("X Dim " + j.getX_dim());
    	System.out.println("Y Dim " + j.getY_dim() + "\n");
    	
    	
//    	for (int z = 0; z < 100; z++) {
//    		 System.out.println(imgs.getValue());
//    	}
    	
    	int x = 0;
    	for (int value : j.getImg()) {   		
    		
    		int valSize = j.getImg().length;
    		
    		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    		hash.put(x, value);
    		//System.out.println(b);
    		
    		//addToArray(value);
    		System.out.println("HashMap is: " + hash);
    		x++;
    		
    	}
    	
    	System.out.println();
    	i++;
    }
    //String what = EntityUtils.toString(response.getEntity()).toString();
    
    
    
//    for (int i = 0; i < 5; i++) {
//    	System.out.println("\nLetter " + i);
//		for (int j = 0; j < 1; j++) {	
//			System.out.println("the X_dim value is " + items.getX_dim());
//			System.out.println("the Y_dim value is " + items.getY_dim());
//			System.out.println("the x_start value is " + items.getX_start());
//			System.out.println("the Y_start value is " + items.getY_start());
//			
//			for (int z = 0; z < 100; z++) {
//				System.out.println(image.getValue());
//			}
//		}
//	}
 }
//	public static int[] addToArray(int b) {
//		int[] imgArray = new int[100];
//		int i = 0;
//		
//		imgArray[i] = b;
//		i++;
//		
//		//System.out.println(Arrays.toString(imgArray));
//		//System.out.println();
//		return imgArray;
//	}
}