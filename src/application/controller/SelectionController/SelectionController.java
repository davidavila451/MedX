package application.controller.SelectionController;

import application.Main.Main;
import application.model.UserInfo.UserInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This controller handles the selection screen and what the user selects
 * User can select Urgent care, Clinic, or Emergency Room.
 * 
 * @author David
 *
 */

public class SelectionController {
	
	Stage primaryStage = new Stage();
	
	@FXML Button cont;
	@FXML RadioButton clinic;
	@FXML RadioButton urgentCare;
	@FXML RadioButton Emergency;
	UserInfo user = Main.user;
	int choice=0;
	
	@FXML
	public void handle(ActionEvent event) {
		cont = (Button) event.getSource();
		
		/*
		 * The purpose of this method is to read what selection the user made and then process
		 * the correct filter for them. Show all clinics, Urgent Cares, or ERs in the area
		 */
		
		if(cont.getId().equals("cont")) {
			switch(choice) {
			case 1:
				user.setChoice(choice);
				break;
			case 2:
				user.setChoice(choice);
				break;
			case 3:
				user.setChoice(choice);
				break;
			}
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(SelectionController.class.getResource("/Insurance.fxml"));
				AnchorPane layout = (AnchorPane) loader.load();
				Scene scene = new Scene(layout);
				Main.stage.setScene(scene);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void ClinicRadio() {
		choice=1;
		urgentCare.setSelected(false);
		Emergency.setSelected(false);
	}
	
	public void UrgentRadio() {
		choice=2;
		clinic.setSelected(false);
		Emergency.setSelected(false);
	}
		
	public void EmergencyRadio() {
		choice=3;
		clinic.setSelected(false);
		urgentCare.setSelected(false);
	}
}
