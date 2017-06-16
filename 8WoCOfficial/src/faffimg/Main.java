package faffimg;

import java.util.*;
//import java.awt.List;
import java.io.File;
import java.io.IOException;

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

 
public class Main {
	
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
	 
	 Scene1 starting = new Scene1();
       
	 
	 
//	System.out.println(letterO.length); 
//	 
//	 ObjectMapper mapper = new ObjectMapper();
//	 HttpClient client = HttpClientBuilder.create().build();
//	 HashMap<String, ArrayList<Integer>> letterHash = null;
//	 ArrayList<Integer> listOfImgValues = null;
//	 HttpPost httppost = new HttpPost("http://172.19.144.219:12345/images");
//	 FileBody bin = new FileBody(new File("template_o.png"));
//	 HttpEntity reqEntity = MultipartEntityBuilder.create()
//		        .addPart("bin", bin)
//		        .build();
//	httppost.setEntity(reqEntity);
//	HttpResponse response = client.execute(httppost);
//	
//	
//    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//    
//    String jsonString = EntityUtils.toString(response.getEntity());
//    ArrayList<JSONItem> temp = mapper.readValue(jsonString, new TypeReference<ArrayList<JSONItem>>() {});
//    
//    int i = 0;
//    
//    System.out.println("There are " + temp.size() + " letters found. \n" );
//    
//    //Sorting items
//    //Collections.sort(arg0);
//    
//    for (JSONItem j: temp) {
//    	int y[] = new int[1000];
//    	System.out.println("Letter number " + i);
//    	System.out.println("X Start "+ j.getX_start());
//    	System.out.println("Y Start " + j.getY_start());
//    	System.out.println("X Dim " + j.getX_dim());
//    	System.out.println("Y Dim " + j.getY_dim() + "\n");
//    	
//    	
////    	for (int z = 0; z < 100; z++) {
////    		 System.out.println(imgs.getValue());
////    	}
//    	
//    	int x = 0;
//    	
//    	int index = 0;
//    	letterHash = new HashMap<String, ArrayList<Integer>>();
//		listOfImgValues = new ArrayList<Integer>();
//    	
//    	for (int value : j.getImg()) {   
//    		
//    		
//    		int valSize = j.getImg().length;
//    		
//    		
//    		y[index] = value;
//    		System.out.println("Value is " + value);
//    		
//    		
//    		
//    		//System.out.println(b);
//    		
//    		//y[i] = hash.get(i);
//    		
//    		
//    		
//    		listOfImgValues.add(value);
//    		
//    		System.out.println("\n" + listOfImgValues.size());
//    		
//    		 		
//    		index++;
//    	
//    		x++;
//    		
//    	}
//    	index = 0;
//    	letterHash.put("H", listOfImgValues);
//    	System.out.println(letterHash.get("H"));
//    	i++;
//    	
//    	
//    }
 }
}