


import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	
	static int lengthOfWord = 5;
	HashMap<Integer, String> hash = new HashMap<Integer, String>();
	
	public static void main(String[] args) throws 
					JsonParseException, JsonMappingException, IOException {
		
		
		doStuff();

	}

	private static void doStuff() {
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
        
		JSONObject[] letters = new JSONObject[lengthOfWord];
		JSONItem items = new JSONItem();
		IMG image = new IMG();
		
		for (int i = 0; i < letters.length; i++) {
			
			
			
			for (int j = 0; j < 1; j++) {
				
				System.out.println("the X_dim value is " + items.getX_dim());
				System.out.println("the Y_dim value is " + items.getY_dim());
				System.out.println("the x_start value is " + items.getX_start());
				System.out.println("the Y_start value is " + items.getY_start());
				
				for (int z = 0; z < 100; z++) {
					
// 					hash.put(z, IMG.getValue());
					
				}
				
				
			}
			
		}
		
		
        
//		for () {
//			
//		}
		
	}

}
