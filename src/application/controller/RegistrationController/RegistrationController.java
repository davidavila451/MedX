package application.controller.RegistrationController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import application.Main.Main;
import application.controller.LoginController.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationController {

	Stage primaryStage = new Stage();
	
	@FXML TextField username;
	@FXML PasswordField password;
	@FXML PasswordField password2;
	@FXML Button register;
	@FXML Text error;
	@FXML Text login;
	
	@FXML
	public void handle(ActionEvent event) {
		register = (Button) event.getSource();
		
		if(register.getId().equals("register")) {
			String user=username.getText();
			String pass=password.getText();
			String pass2=password2.getText();
			int status=checkAccounts(user, pass);
			
			if(status == 1) {
				error.setText("User already exist");
				error.setFill(Color.RED);
				error.setFont(Font.font("system",FontWeight.NORMAL, FontPosture.REGULAR,14.0));
				error.setLayoutY(375.0);
				error.setLayoutX(188.0);
			}else {
				if(pass.equals(pass2)) {
					try {
					
						String newUser=user+","+pass;
						BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt", true));
					
						writer.newLine();
						writer.write(newUser);
						writer.close();
					
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(LoginController.class.getResource("/Login.fxml"));
						AnchorPane layout = (AnchorPane) loader.load();
						Scene scene = new Scene(layout);
						Main.stage.setScene(scene);
					
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					error.setText("Password do not match");
					error.setFill(Color.RED);
					error.setFont(Font.font("system",FontWeight.NORMAL, FontPosture.REGULAR,14.0));
					error.setLayoutY(375.0);
					error.setLayoutX(164.0);
				}
			}
				
		}
	}
	
	public int checkAccounts(String user, String pass) {
		try	{
			int result=0;
			Scanner scanner = new Scanner(new File("accounts.txt"));
		
			//While going through the lines of accounts, tokenize them
			//and check the username first then password.
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tokens = line.split(",");
				String bufferA = tokens[0];
				String bufferB = tokens[1];
				//If the username is good, check password. Assign result
				//then return
				if(user.equals(bufferA)) {
					if(pass.equals(bufferB)) {
						result=1;
						scanner.close();
						return result;
					}
					result=1;
					scanner.close();
					return result;
				}
			}
		scanner.close();
		return result;
		}catch (IOException e) {
			e.printStackTrace();
		}
		//Close the scanner and return the result
		
		return 0;
	}
	
	public void login() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LoginController.class.getResource("/Login.fxml"));
			AnchorPane layout = (AnchorPane) loader.load();
			Scene scene = new Scene(layout);
			Main.stage.setScene(scene);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}
