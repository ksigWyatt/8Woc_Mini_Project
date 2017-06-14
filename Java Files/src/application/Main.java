package application;

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

		//Launching and opening the program
		launch(args);
	}
}
