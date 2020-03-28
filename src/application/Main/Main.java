package application.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is used to load up the application when the app is first run.
 * After starting the app it will then jump to the login controller.
 * @author David
 *
 */

public class Main extends Application{
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
			primaryStage.setScene(new Scene(root, 500, 500));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
