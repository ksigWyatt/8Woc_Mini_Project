
import java.awt.List;
import java.io.File;
import java.io.IOException;
//import java.util.Arrays;
import java.util.ArrayList;

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
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

 
public class Test {
 public static void main(String[] args) throws ClassNotFoundException, 
	JsonParseException, JsonMappingException , IOException {
	 
	 JSONParser parser = new JSONParser();
	 ObjectMapper mapper = new ObjectMapper();
	 HttpClient client = HttpClientBuilder.create().build();
	 JSONObject obj = new JSONObject();
	 JSONItem items = new JSONItem();
	 IMG image = new IMG();
	 
	 HttpPost httppost = new HttpPost("http://172.19.144.219:12345/images");
	 FileBody bin = new FileBody(new File("Hello.png"));
	 HttpEntity reqEntity = MultipartEntityBuilder.create()
		        .addPart("bin", bin)
		        .build();
	httppost.setEntity(reqEntity);
	HttpResponse response = client.execute(httppost);
	
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
    String jsonString = EntityUtils.toString(response.getEntity());
    ArrayList<JSONItem> temp = mapper.readValue(jsonString, new TypeReference<ArrayList<JSONItem>>() {});
    int i = 0;
    
    for (JSONItem j: temp){
    	System.out.println("Letter number " + i);
    	System.out.println("X Start "+ j.getX_start());
    	System.out.println("Y Start " + j.getY_start());
    	System.out.println("X Dim " + j.getX_dim());
    	System.out.println("Y Dim " + j.getY_dim());    	
    	i++;
    }
 }
}