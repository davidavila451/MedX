package application.model.AddressBook;

import java.util.List;

public class Address {
	
	public String name;
	public String time;
	public List<String> insurance;
	public String type;
	
	public Address(String name, String time, List<String> insurance, String type) {
		this.name = name;
		this.time = time;
		this.insurance = insurance;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<String> getInsurance() {
		return insurance;
	}

	public void setInsurance(List<String> insurance) {
		this.insurance = insurance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
