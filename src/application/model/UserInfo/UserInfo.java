package application.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

import application.model.AddressBook.Address;

public class UserInfo {
	String userName;
	int Choice;
	String insurance;
	List<String> symptoms = new ArrayList<String>();
	String desc;
	Address myAddress = new Address("","",null,"");
	
	
	public Address getMyAddress() {
		return myAddress;
	}
	public void setMyAddress(Address myAddress) {
		this.myAddress = myAddress;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<String> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getChoice() {
		return Choice;
	}
	public void setChoice(int choice) {
		Choice = choice;
	}
	
	

}
