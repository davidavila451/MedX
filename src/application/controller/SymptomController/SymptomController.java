package application.controller.SymptomController;

import java.util.ArrayList;
import java.util.List;

import application.Main.Main;
import application.model.UserInfo.UserInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SymptomController {
	
	Stage primaryStage = new Stage();
	
	@FXML Button cont;
	@FXML CheckBox illness;
	@FXML CheckBox skin;
	@FXML CheckBox injury;
	@FXML CheckBox lab;
	@FXML CheckBox immune;
	@FXML CheckBox TB;
	@FXML CheckBox physical;
	@FXML CheckBox travel;
	@FXML CheckBox refill;
	@FXML CheckBox staple;
	@FXML CheckBox smoking;
	@FXML CheckBox cosmetic;
	List<String> symptoms = new ArrayList<String>();
	
	UserInfo user = Main.user;
	
	@FXML
	public void handle(ActionEvent event) {
		cont = (Button) event.getSource();
		
		if(cont.getId().equals("cont")) {
			//Illness
			if (illness.isSelected()==true) {
				symptoms.add("Illness");
			}
			//Skin
			if (skin.isSelected()==true) {
				symptoms.add("Skin/Hair");
			}
			//Injury
			if (injury.isSelected()==true) {
				symptoms.add("Injury");
			}
			//Lab
			if (lab.isSelected()==true) {
				symptoms.add("Labwork");
			}
			//Immune
			if (immune.isSelected()==true) {
				symptoms.add("Immunization");
			}
			//TB
			if (TB.isSelected()==true) {
				symptoms.add("TB (Testing / Reading");
			}
			//Physical
			if (physical.isSelected()==true) {
				symptoms.add("Physical Exam");
			}
			//Travel
			if (travel.isSelected()==true) {
				symptoms.add("International Travel");
			}
			//Refill
			if (refill.isSelected()==true) {
				symptoms.add("One Time Refill");
			}
			//Staple
			if (staple.isSelected()==true) {
				symptoms.add("Suture/Staple Removal");
			}
			//Smoking
			if (smoking.isSelected()==true) {
				symptoms.add("Stop Smoking/Tobacco Use");
			}
			//Cosmetic
			if (cosmetic.isSelected()==true) {
				symptoms.add("Cosmetic Services");
			}
			
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(SymptomController.class.getResource("/SymptomsCont.fxml"));
				AnchorPane layout = (AnchorPane) loader.load();
				Scene scene = new Scene(layout);
				Main.stage.setScene(scene);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
