package application.controller.LocationController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.Main.Main;
import application.controller.LoginController.LoginController;
import application.model.AddressBook.Address;
import application.model.UserInfo.UserInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LocationController implements Initializable {
	
	Stage primaryStage = new Stage();
	
	@FXML Button con;
	@FXML ImageView map;
	@FXML TableColumn<String, Address> name;
	@FXML TableColumn<Integer, Address> time;
	@FXML TableColumn<String, Address> insurance;
	@FXML TableView<Address> list;
	@FXML RadioButton filter;
	UserInfo user = Main.user;
	Address address = Main.address;
	List<Address> addList = new ArrayList<Address>();
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Image image = new Image("unnamed.png");
		map.setImage(image);
		
		getList();
		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		time.setCellValueFactory(new PropertyValueFactory<>("time"));
		insurance.setCellValueFactory(new PropertyValueFactory<>("insurance"));
		
		list.setItems(FXCollections.observableArrayList(addList));
	}
	
	public void getList(){
		addList.clear();
		try {
			Scanner scanner = new Scanner(new File("addressBook.txt"));
			String choice=null;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tokens = line.split(",");
				
				int buffer=user.getChoice();
				switch(buffer) {
				case 1:
					choice="Clinic";
					break;
				case 2:
					choice="Urgent";
					break;
				case 3:
					choice="Emergency";
					break;
				}
				if(choice.equals(tokens[3])) {
				
					String name = tokens[0];
					String time = tokens[1];
					String[] tokens2 = tokens[2].split("/");
					List<String> insurance=new ArrayList<String>();
					for(int i=0; i<tokens2.length; i++) {
						insurance.add(tokens2[i]);
					}
					String type = tokens[3];
				
					Address add = new Address(name,time,insurance,type);
				
					addList.add(add);
				}
				
			}
			scanner.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handle(ActionEvent event) {
		con = (Button) event.getSource();
		
		if(con.getId().equals("con")) {
			
			ObservableList<Address> items=list.getSelectionModel().getSelectedItems();
			String name=items.get(0).name;
			String time=items.get(0).time;
			List<String> insurance=items.get(0).insurance;
			String type=items.get(0).type;
			user.setMyAddress(new Address(name, time, insurance, type));
			
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(LoginController.class.getResource("/Confirmation.fxml"));
				AnchorPane layout = (AnchorPane) loader.load();
				Scene scene = new Scene(layout);
				Main.stage.setScene(scene);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void filterHandle() {

		if(filter.isSelected()==true) {
			newList();
			list.getItems().clear();
			list.refresh();
			list.setItems(FXCollections.observableArrayList(addList));
			
		}
		if(filter.isSelected()==false) {
			getList();
			list.getItems().clear();
			list.refresh();
			list.setItems(FXCollections.observableArrayList(addList));
		}
	}
		
		public void newList(){
			addList.clear();
			try {
				Scanner scanner = new Scanner(new File("addressBook.txt"));
				String choice=null;
				String in=user.getInsurance();
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String[] tokens = line.split(",");
					int greenLight=0;
					
					int buffer=user.getChoice();
					switch(buffer) {
					case 1:
						choice="Clinic";
						break;
					case 2:
						choice="Urgent";
						break;
					case 3:
						choice="Emergency";
						break;
					}
					if(choice.equals(tokens[3])) {
					
						String name = tokens[0];
						String time = tokens[1];
						String[] tokens2 = tokens[2].split("/");
						for(int j=0; j<tokens2.length; j++) {
							if(in.equals(tokens2[j])) {
								greenLight=1;
							}
						}
						if(greenLight==1) {
							List<String> insurance=new ArrayList<String>();
							for(int i=0; i<tokens2.length; i++) {
								insurance.add(tokens2[i]);
							}
							String type = tokens[3];
					
							Address add = new Address(name,time,insurance,type);
					
							addList.add(add);
						}
					}
					
				}
				scanner.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	
	
}
