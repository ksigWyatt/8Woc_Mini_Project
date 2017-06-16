package faffimg;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ann_ejones
 */
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Scene1 extends javax.swing.JFrame {

	//Creating Global Variables
	ObjectMapper mapper = new ObjectMapper();
	HttpClient client = HttpClientBuilder.create().build();
	HashMap<String, ArrayList<Integer>> letterHash = null;
	ArrayList<Integer> listOfImgValues = null;
	HttpPost httppost = new HttpPost("http://172.19.144.219:12345/images");
	 
	 
	 
	 
	 int[] letterH = new int[] {
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 103, 
			 103, 103, 103, 100, 30, 0, 0, 0, 103, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179,
			 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 
			 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 103, 0, 0, 0, 27,
			 103, 103, 103, 103, 103, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 
			 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 34, 0, 0, 0, 102, 102, 102, 102, 102, 102, 
	                                103, 103, 103, 103, 103, 17, 0, 0, 0, 103, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 
	                                0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 
	                                0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 
	                                179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 107, 0, 0, 0, 143, 143, 15, 0, 0, 107, 0, 0, 0, 
	                                0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 179, 0, 0, 0, 0, 0, 0, 
	                                0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 
	                                0, 0, 0, 0, 0, 0, 0, 0, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 
	                                179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
	                                0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0,
	                                0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 0, 0, 
	                                0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 
	                                0, 179, 126, 0, 0, 26, 126, 126, 0, 0, 0, 126, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 
	                                0, 0, 0, 179, 179, 0, 0, 0, 0, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 
	                                0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 
	                                179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 
	                                0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 101, 101, 101, 101, 101, 101, 
	                                0, 0, 0, 48, 105, 0, 0, 0, 13, 98, 101, 105, 105, 105, 179, 0, 0, 0, 0, 0, 0, 0, 0, 
	                                179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 
	                                0, 0, 0, 0, 0, 0, 179, 105, 0, 0, 0, 24, 91, 105, 105, 105, 105, 179, 0, 0, 0, 0, 0, 
	                                0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 
	                                0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 
	                                0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 103, 
	                                103, 103, 103, 103, 23, 0, 0, 0, 103, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
	                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	                                0
	 };
	 
	 int[] letterE = new int[] {
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 0, 0, 0, 
			 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 
			 0, 0, 0, 0, 179, 178, 0, 0, 0, 0, 0, 0, 0, 0, 178, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 106, 32, 135, 0, 106, 106, 0, 0, 0, 106, 113, 113, 113, 113, 75, 48, 0, 0, 0, 73, 167, 47, 58, 53, 
			 14, 2, 0, 0, 0, 167, 103, 103, 103, 103, 103, 25, 0, 0, 0, 103, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 
			 0, 0, 0, 0, 0, 0, 0, 179, 102, 0, 0, 0, 37, 102, 102, 102, 102, 102, 144, 0, 0, 0, 3, 19, 90, 91, 75, 144, 
			 113, 0, 0, 0, 4, 27, 113, 113, 113, 113, 87, 0, 0, 0, 102, 102, 0, 166, 26, 87, 18, 113, 113, 113, 113, 113, 
			 0, 0, 0, 3, 114, 114, 104, 114, 36, 12, 0, 0, 0, 114, 166, 93, 8, 1, 7, 0, 0, 0, 0, 166, 109, 109, 109, 109, 
			 68, 15, 0, 0, 0, 109, 44, 0, 0, 0, 102, 102, 102, 102, 102, 102, 103, 103, 103, 103, 103, 22, 0, 0, 0, 103, 
			 108, 0, 0, 0, 18, 72, 108, 108, 108, 108, 156, 0, 0, 0, 0, 12, 1, 12, 123, 156, 15, 0, 0, 0, 36, 104, 114, 
			 114, 114, 114, 10, 0, 0, 0, 13, 108, 129, 129, 129, 44, 43, 104, 103, 117, 117, 117, 0, 0, 0, 11, 91, 121, 
			 121, 121, 93, 45, 0, 0, 0, 32, 121, 121, 121, 121, 56, 9, 0, 0, 0, 51, 149, 85, 32, 9, 70, 80, 0, 0, 0, 149, 
			 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 172, 0, 0, 0, 0, 1, 7, 22, 66, 172, 28, 
			 0, 0, 0, 6, 50, 125, 125, 125, 117, 29, 0, 0, 0, 109, 109, 109, 109, 109, 64, 15, 0, 0, 0, 137, 137, 126, 
			 67, 59, 48, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 25, 83, 59, 93, 149, 149, 0, 0, 0, 2, 178, 0, 0, 0, 0, 0, 0, 
			 0, 0, 178, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 5, 0, 0, 0, 112, 112, 112, 112, 112, 
			 44, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 3, 0, 0, 1, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 
			 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 109, 0, 0, 0, 24, 62, 109, 109, 109, 109, 17, 0, 0, 0, 28, 57, 136, 136, 
			 136, 63, 29, 0, 0, 0, 35, 89, 116, 116, 116, 116, 76, 0, 0, 0, 162, 162, 0, 0, 0, 76, 0, 0, 0, 0, 179, 179, 
			 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 18, 74, 81, 87, 149, 149, 0, 0, 0, 2, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 5, 0, 0, 0, 113, 113, 113, 113, 113, 
			 20, 47, 0, 0, 0, 95, 103, 103, 103, 103, 103, 120, 0, 0, 0, 1, 13, 91, 111, 120, 120, 179, 5, 0, 0, 0, 0, 
			 0, 0, 0, 179, 100, 100, 100, 100, 100, 100, 0, 0, 0, 61, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 103, 103, 103, 103, 103, 103, 0, 0, 0, 23, 7, 21, 28, 74, 169, 169, 0, 0, 0, 3, 42, 38, 83, 
			 107, 145, 145, 0, 0, 0, 13, 87, 0, 0, 0, 97, 97, 97, 97, 97, 97, 112, 0, 0, 0, 12, 40, 112, 112, 112, 112, 
			 103, 0, 0, 0, 15, 103, 103, 103, 103, 103, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 
			 179, 20, 14, 19, 14, 177, 177, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 1, 10, 138, 138, 138, 78, 
			 29, 9, 179, 3, 2, 0, 3, 8, 5, 7, 16, 179, 86, 127, 127, 127, 88, 16, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 
			 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
	};
		 
	 int[] letterL = new int[] {
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 113, 113, 104, 113, 
		 47, 12, 0, 0, 0, 113, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 
		 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 
		 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 110, 0, 0, 0, 12, 55, 110, 110, 110, 
		 110, 119, 0, 0, 0, 9, 39, 119, 96, 103, 119, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 
		 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 
		 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 111, 111, 111, 
		 111, 45, 9, 0, 0, 0, 111, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		 0, 0

	 };
	 
	 
	 int[] letterO = new int[] {
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 157, 118, 28, 0, 9, 0, 0, 0, 0, 157, 103, 103, 
			 103, 103, 103, 21, 0, 0, 0, 103, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 104, 
			 0, 0, 0, 20, 104, 104, 104, 97, 104, 178, 0, 0, 0, 0, 0, 0, 1, 27, 178, 76, 0, 0, 0, 89, 89, 110, 157, 0, 
			 76, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 137, 125, 0, 86, 86, 0, 0, 0, 86, 104, 127, 127, 127, 55, 24, 0, 0, 
			 0, 30, 110, 110, 110, 110, 56, 10, 0, 0, 0, 110, 169, 77, 30, 8, 3, 0, 0, 0, 0, 169, 0, 0, 0, 0, 175, 175,
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128, 0, 0, 0, 10, 12, 39, 116, 128, 128, 115, 0, 0, 0, 41, 54, 
			 115, 115, 83, 115, 112, 0, 0, 0, 19, 35, 112, 112, 112, 112, 96, 0, 0, 0, 85, 98, 98, 98, 98, 98, 52, 137, 
			 137, 137, 71, 11, 0, 0, 0, 14, 89, 107, 107, 107, 107, 75, 0, 0, 0, 70, 106, 106, 106, 106, 85, 27, 0, 0,
			 0, 106, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 
			 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 103, 0, 0, 0, 34, 99, 103, 103, 103, 103, 97, 0, 0, 0, 88, 97, 97, 
			 97, 97, 97, 9, 0, 0, 0, 112, 112, 112, 112, 112, 32, 100, 100, 100, 100, 100, 100, 0, 0, 0, 63, 19, 113, 
			 113, 113, 113, 113, 0, 0, 0, 9, 113, 113, 104, 113, 39, 22, 0, 0, 0, 113, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0, 27, 49, 
			 110, 110, 110, 110, 11, 0, 0, 0, 113, 113, 113, 113, 113, 19, 81, 0, 0, 0, 98, 98, 98, 98, 98, 98, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 22, 89, 66, 88, 147, 147, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 155, 155, 83, 58, 72, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 107, 0, 0, 0, 40, 73, 107, 
			 107, 107, 107, 16, 0, 0, 0, 26, 87, 128, 128, 128, 82, 33, 0, 0, 0, 39, 106, 112, 112, 112, 112, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			 115, 115, 115, 115, 93, 36, 0, 0, 0, 29, 97, 121, 121, 121, 97, 29, 0, 0, 0, 18, 100, 100, 100, 100, 100, 
			 100, 0, 0, 0, 62, 8, 0, 0, 0, 71, 119, 119, 119, 119, 45, 96, 0, 0, 0, 96, 96, 96, 96, 96, 96, 126, 0, 0, 
			 0, 1, 19, 86, 95, 126, 126, 113, 0, 0, 0, 7, 23, 113, 113, 113, 113, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 
			 0, 0, 0, 0, 0, 0, 0, 0, 179, 151, 82, 72, 82, 8, 1, 0, 0, 0, 151, 112, 112, 112, 112, 39, 4, 0, 0, 0, 112, 
			 96, 96, 96, 96, 96, 96, 0, 0, 0, 96, 27, 113, 113, 113, 113, 113, 0, 0, 0, 8, 89, 0, 0, 0, 97, 97, 97, 97, 
			 97, 97, 11, 0, 0, 0, 10, 63, 134, 134, 134, 79, 159, 0, 0, 0, 2, 2, 11, 37, 111, 159, 0, 0, 0, 0, 0, 0, 0, 
			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 110, 
			 110, 110, 44, 33, 0, 0, 0, 110, 111, 111, 111, 111, 52, 8, 0, 0, 0, 111, 96, 96, 96, 96, 96, 96, 0, 0, 0, 
			 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128, 0, 0, 0, 30, 30, 0, 116, 128, 128, 104, 0, 0, 0, 33, 104, 104, 104, 
			 92, 104, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 
			 179, 179, 0, 0, 0, 0, 0, 0, 0, 0, 179, 105, 90, 105, 105, 105, 37, 0, 0, 0, 105, 86, 0, 151, 106, 86, 86, 
			 0, 0, 0, 86, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
	 };
	
	
	
    /**
     * Creates new form Scene1
     */
    public Scene1() {
        initComponents();
        main();
    }

    private void main() {
    	 try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(Scene1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(Scene1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(Scene1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(Scene1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>

         /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 
                 setVisible(true);
                 //new Scene2().setVisible(false);
                                
               
             }
         });
    
		
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        successImage_label = new javax.swing.JLabel();
        done_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        upload_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Please submit your written image"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        done_btn.setText("Translate");
        done_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done_btnActionPerformed(evt);
            }
        });

        save_btn.setText("Temp Save Button");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(successImage_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(done_btn)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(save_btn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(successImage_label)
                    .addComponent(done_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(save_btn))
        );

        upload_btn.setText("Upload Image");
        upload_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(upload_btn)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(upload_btn)
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    private void upload_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_btnActionPerformed
    
    	
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "png", "JPEG file", "jpg", "jpeg", "exif", "tiff", "bmp");
        
        fileChooser.addChoosableFileFilter(filter);
        
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();
	        
	        fileLocation = selectedFile.getAbsolutePath();
	       
	        successImage_label.setText("Upload complete");
	        
		 
	        ObjectMapper mapper = new ObjectMapper();
	        HttpClient client = HttpClientBuilder.create().build();
	        
	        
	        HttpPost httppost = new HttpPost("http://172.19.144.219:12345/images");
	        FileBody bin = new FileBody(new File(fileLocation));
	        
	        HttpEntity reqEntity = MultipartEntityBuilder.create()
			        .addPart("bin", bin)
			        .build();
		httppost.setEntity(reqEntity);
		HttpResponse response = null;
            try {
                response = client.execute(httppost);
            } catch (IOException ex) {
                Logger.getLogger(Scene1.class.getName()).log(Level.SEVERE, null, ex);
            }
	
	//try(FileWriter file = new FileWriter(""))
	
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
    String jsonString = null;
            try {
                jsonString = EntityUtils.toString(response.getEntity());
            } catch (IOException ex) {
                Logger.getLogger(Scene1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Scene1.class.getName()).log(Level.SEVERE, null, ex);
            }
    ArrayList<JSONItem> temp = null;
            try {
                temp = mapper.readValue(jsonString, new TypeReference<ArrayList<JSONItem>>() {});
            } catch (IOException ex) {
                Logger.getLogger(Scene1.class.getName()).log(Level.SEVERE, null, ex);
            }
    int i = 0;
    
	    for (JSONItem j: temp){
	    	int y[] = new int[1000];
	    	System.out.println("Letter number " + i);
	    	System.out.println("X Start "+ j.getX_start());
	    	System.out.println("Y Start " + j.getY_start());
	    	System.out.println("X Dim " + j.getX_dim());
	    	System.out.println("Y Dim " + j.getY_dim());
	    	
	
	    	int x = 0;
	    	
	    	int index = 0;
	    	letterHash = new HashMap<String, ArrayList<Integer>>();
			listOfImgValues = new ArrayList<Integer>();
	    	
	    	for (int value : j.getImg()) {   
	    		
	    		
	    		int valSize = j.getImg().length;
	    		
	    		
	    		y[index] = value;
	    		System.out.println("Value is " + value);
	    		
	    		
	    		
	    		//System.out.println(b);
	    		
	    		//y[i] = hash.get(i);
	    		
	    		
	    		
	    		listOfImgValues.add(value);
	    		
	    		System.out.println("\n" + listOfImgValues.size());
	    		
	    		 		
	    		index++;
	    	
	    		x++;
	    		
	    	}
	    	index = 0;
	    	letterHash.put("H", listOfImgValues);
	    	System.out.println(letterHash.get("H"));
	    	i++;
    	}
      }
    }//GEN-LAST:event_upload_btnActionPerformed
    
    private void done_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done_btnActionPerformed
       setVisible(false);
       Scene2 scene2 = new Scene2();
       scene2.setVisible(true);
    }//GEN-LAST:event_done_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        fileChooser.setDialogTitle("Specify a file to save");   
 
        int userSelection = fileChooser.showSaveDialog(this);
 
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        }

    }//GEN-LAST:event_save_btnActionPerformed

   
    String fileLocation;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton done_btn;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton save_btn;
    private javax.swing.JLabel successImage_label;
    private javax.swing.JButton upload_btn;
    // End of variables declaration//GEN-END:variables
}
