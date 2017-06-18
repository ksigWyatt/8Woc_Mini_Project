package faffimg;

import java.io.*;
import java.util.*;
//import java.awt.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

public class Main {

	static ArrayList<JSONItem> templates = new ArrayList<>();
	static ArrayList<String> outputTextArray = new ArrayList<String>();
	static Scene2 scene2 = new Scene2();

 public static void main(String[] args) throws ClassNotFoundException, IOException {
	 Scene1 starting = new Scene1();
	 Main main = new Main();
 }

 public static void compareLetters(ArrayList<JSONItem> imgData) {

 	int minKey = Integer.MAX_VALUE;
	 HashMap<Integer, String> resultSet = new HashMap<>();

	 Collections.sort(imgData);

 	// iterate over all templates from imgData
	 for (JSONItem item: imgData) {
		int[] img = item.getImg();

		//compare each letter each template
		 for (JSONItem templateItem : templates) {
			 int[] templateImgArray = templateItem.getImg();

			 int sum = 0;
			 for (int i = 0; i<templateImgArray.length; i++) {
				 sum += Math.abs(templateImgArray[i] - img[i]);
			 }
			 if (minKey > sum) {
			 	minKey = sum;
			 }
			 resultSet.put(sum, templateItem.getLetter());
		 }

		 String s = resultSet.get(minKey);

		 //START HERE
		outputTextArray.add(s);
		 System.out.println( s );
	 }
 }

 public static void outputText()throws FileNotFoundException, IOException{
	 FileWriter fwriter = null;
	 BufferedWriter writer = null;
	 String output = "";

	 try{
	 	File file = new File("Hello.txt");
	 	writer = new BufferedWriter(new FileWriter(file));
	 	for (String str : outputTextArray){
	 		writer.write(str);
		}
		writer.close();
	 }catch (Exception e){
	 	System.out.println(e);
	 }
	 FileReader reader = new FileReader("Hello.txt");
	 for (String str : outputTextArray){
		output = output + str;
	 }
	 System.out.println(output);
	 scene2.outputTranscription.setText(output);
	 scene2.outputTranscription.validate();
	 scene2.outputTranscription.repaint();
 }

 public static void getTemplates() {
	 File folder = new File("templates/");

	 for (File file : folder.listFiles()) {
		 JSONItem item = postImage(file.getAbsolutePath()).get(0);
		 item.setLetter(String.valueOf(file.getName().charAt(0)));

		 templates.add(item);
	 }

 }

 public static ArrayList<JSONItem> postImage(String filepath) {

	 // do an HTTP request and get the response
	 ObjectMapper mapper = new ObjectMapper();
	 HttpClient client = HttpClientBuilder.create().build();
	 HashMap<String, ArrayList<Integer>> letterHash;
	 ArrayList<Integer> listOfImgValues;

	 HttpPost httppost = new HttpPost("http://localhost:12345/images");

	 FileBody bin = new FileBody(new File(filepath));

	 HttpEntity reqEntity = MultipartEntityBuilder.create()
			 .addPart("bin", bin)
			 .build();
	 httppost.setEntity(reqEntity);

	 HttpResponse response = null;
	 try {
		 response = client.execute(httppost);
	 }
	 catch (Exception e) {
		 e.printStackTrace();
	 }

	 mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	 String jsonString = null;
	 try {
		 jsonString = EntityUtils.toString(response.getEntity());
	 }
	 catch (Exception e) {
		 e.printStackTrace();
	 }

	 ArrayList<JSONItem> temp = null;

	 try {
		 temp = mapper.readValue(jsonString, new TypeReference<ArrayList<JSONItem>>() {});
	 }
	 catch (Exception e) {
		 e.printStackTrace();
	 }

	 return temp;
 }


}