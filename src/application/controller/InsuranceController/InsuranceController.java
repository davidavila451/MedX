package application.controller.InsuranceController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.Main.Main;
import application.controller.LoginController.LoginController;
import application.model.UserInfo.UserInfo;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This controller handles the selection of insurance provider. The selection is 
 * temporarily stored to be used in the query selection only of hospitals that accept or
 * do not accept a certain insurance.
 * @author David
 *
 */
public class InsuranceController implements Initializable {

	Stage primaryStage = new Stage();
	
	@FXML Button cont;
	@FXML ChoiceBox insurance;
	@FXML TextField other;
	UserInfo user = Main.user;
	
	//Set up the choice box with all the insurance information
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		other.setVisible(false);
		insurance.setItems(getList());
		
	}
	
	public ObservableList<String> getList(){
		ObservableList<String> list = FXCollections.observableArrayList();
		try {
			Scanner scanner = new Scanner(new File("Insurance Companies"));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				list.add(line);
			}
			scanner.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

	@FXML
	public void handle(ActionEvent event) {
		//String value = (String) insurance.getValue();
		
		if(cont.getId().equals("cont")) {
			String buffer;
			if(other.isVisible()==true) {
				buffer=other.getText();
				user.setInsurance(buffer);
			}else {
				buffer = (String) insurance.getValue();
				user.setInsurance(buffer);
			}
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(LoginController.class.getResource("/Symptoms.fxml"));
				AnchorPane layout = (AnchorPane) loader.load();
				Scene scene = new Scene(layout);
				Main.stage.setScene(scene);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void listen() {
		
	}
}
