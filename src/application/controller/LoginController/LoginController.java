package application.controller.LoginController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import application.Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This controller handles the Login screen.
 * The user can enter a username and password and then login in.
 * The user can also tap on create an account to create a new account with us.
 * @author David
 *
 */
public class LoginController {
	
	Stage primaryStage = new Stage();
	@FXML Button login;
	@FXML TextField username;
	@FXML PasswordField password;
	@FXML Text create;
	
	@FXML
	public void handle(ActionEvent event) throws FileNotFoundException {
		login = (Button) event.getSource();
		
		/*
		 *If the user clicks the login button check the login info then change the scene
		 *to the Selection scene for doctor, urgency care, and hospital. 
		 */
		if(login.getId().equals("login")) {
			String user=username.getText();
			String pass=password.getText();
			int result=runVerification(user, pass);
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(LoginController.class.getResource("/Selection.fxml"));
				AnchorPane layout = (AnchorPane) loader.load();
				Scene scene = new Scene(layout);
				Main.stage.setScene(scene);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Run verification to make sure the user has an account
	 * Check username first. If the username exist check password
	 * Good username and bad password = 10
	 * Good username and password = 11
	 * bad username and password = 0
	 */
	private int runVerification(String user, String pass) throws FileNotFoundException {
		//Initiate the scanner that scans our account "database".
		int result=0;
		Scanner scanner = new Scanner(new File("/accounts.txt"));
		
		//While going through the lines of accounts, tokenize them
		//and check the username first then password.
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(",");
			String bufferA = tokens[0];
			String bufferB = tokens[1];
			//If the username is good, check password. Assign result
			//then return
			if(user==bufferA) {
				if(pass==bufferB) {
					result=11;
				}
				result=10;
			}
		}
		//Close the scanner and return the result
		scanner.close();
		return result;
	}
}
