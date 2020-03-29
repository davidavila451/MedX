package application.controller.ConfirmationController;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main.Main;
import application.controller.LoginController.LoginController;
import application.model.AddressBook.Address;
import application.model.UserInfo.UserInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConfirmationController implements Initializable {
	
	Stage primaryStage = new Stage();
	
	@FXML Button ret;
	@FXML Text name;
	@FXML Text time;
	UserInfo user = Main.user;
	Address newAdd = user.getMyAddress();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		name.setText(newAdd.getName());
		time.setText(newAdd.getTime()+" min");
	}
	
	@FXML
	public void handle(ActionEvent event) {
		if(ret.getId().equals("ret")) {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(LoginController.class.getResource("/Selection.fxml"));
				AnchorPane layout = (AnchorPane) loader.load();
				Scene scene = new Scene(layout);
				Main.stage.setScene(scene);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
