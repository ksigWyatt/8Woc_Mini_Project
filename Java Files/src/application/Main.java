package application;

import org.apache.http.*;
import org.apache.http.message.BasicHttpRequest;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane(); //create new border object
			Scene scene = new Scene(root,400,400); // set window size
			//Reference style sheet to make it look pretty
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene); //set the scene
			primaryStage.show(); //show the scene
		}
		//Catch unnecessary exceptions
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		//Adding HTTP request framework to make sure this is all working
				HttpRequest request = new BasicHttpRequest("GET", "/",
					    HttpVersion.HTTP_1_1);

//					System.out.println(request.getRequestLine().getMethod());
//					System.out.println(request.getRequestLine().getUri());
//					System.out.println(request.getProtocolVersion());
					System.out.println(request.getRequestLine().toString());

		//Launching and opening the program
		launch(args);



	}
}
