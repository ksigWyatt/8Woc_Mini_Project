


import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	
	static int lengthOfWord = 5;
	static HashMap<String, String> hash = new HashMap<String, String>();
	
	public static void main(String[] args) throws 
					JsonParseException, JsonMappingException, IOException {
		
		
		doStuff();

	}

	private static void doStuff() {
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
        
		JSONObject[] letters = new JSONObject[lengthOfWord];
		for (int i = 0; i < letters.length; i++) {
			
			JSONItem items = new JSONItem();
			
			for (int j = 0; j < 1; j++) {
				
				System.out.println("the X_dim value is " + items.getX_dim());
				
				
			}
			
		}
		
		
        
//		for () {
//			
//		}
		
	}

}
