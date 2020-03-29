package application.controller.SymptomController;

import application.Main.Main;
import application.model.UserInfo.UserInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SymptomContController {

	Stage primaryStage = new Stage();
	
	@FXML Button cont;
	@FXML TextArea desc;
	
	UserInfo user = Main.user;
	
	public void handle(ActionEvent event) {
		cont = (Button) event.getSource();
		
		if(cont.getId().equals("cont")) {
			
			String text = desc.getText();
			user.setDesc(text);
			
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(SymptomController.class.getResource("/Location.fxml"));
				AnchorPane layout = (AnchorPane) loader.load();
				Scene scene = new Scene(layout);
				Main.stage.setScene(scene);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
