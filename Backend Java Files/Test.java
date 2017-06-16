import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

 
public class Test {
 public static void main(String[] args) throws ClassNotFoundException, 
	JsonParseException, JsonMappingException , IOException {
    String jsonString = sendPostRequest();
    ArrayList<JSONItem> items = mapJSONObjects(jsonString);
    int i = 0;
    
    Collections.sort(items);
    for (JSONItem j: items){
    	System.out.println("Letter number " + i);
    	System.out.println("X Start "+ j.getX_start());
    	System.out.println("Y Start " + j.getY_start());
    	System.out.println("X Dim " + j.getX_dim());
    	System.out.println("Y Dim " + j.getY_dim());    	
    	i++;
    }
 }
 
 
 //function for sending POST request to server
 //will return string created from JSON objects returned from server
 public static String sendPostRequest() throws ClientProtocolException, IOException{
	 HttpClient client = HttpClientBuilder.create().build();
	 HttpPost httppost = new HttpPost("http://172.19.144.219:12345/images");
	 FileBody bin = new FileBody(new File("/users/nicholasdipinto1/Desktop/Hello.png"));
	 HttpEntity reqEntity = MultipartEntityBuilder.create()
		        .addPart("bin", bin)
		        .build();
	httppost.setEntity(reqEntity);
	HttpResponse response = client.execute(httppost);	
	return EntityUtils.toString(response.getEntity());
 }
 
 //function will map the string containing the information on the JSON objects
 //to an array list of objects and return that array list
 public static ArrayList<JSONItem> mapJSONObjects(String sourceString) throws JsonParseException, JsonMappingException, IOException{
	 ObjectMapper mapper = new ObjectMapper();
	 mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	 ArrayList<JSONItem> temp = mapper.readValue(sourceString, new TypeReference<ArrayList<JSONItem>>() {});
	 return temp;
 }
}