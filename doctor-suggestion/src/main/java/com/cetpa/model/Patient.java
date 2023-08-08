package com.cetpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Patient {

	@Id
	@GeneratedValue
	private int pid;
	@NotNull(message = "name is required")
	private String name;
	@NotNull(message = "city is required")
	@Size(min=3, max=15, message = "City length should be between 3 to 15 characters")
	private String city;
	@NotNull(message = "email is required")
	@Email(message = "email is required")
	private String email;
	@NotNull(message = "phone is required")
	@Size(min=10,max=10, message="phone number should have 10 digits")
	@Pattern(regexp = "[0-9]*", message = "phone must have number digits digits")
	private String phone;
	@NotNull(message = "symptoms is required")
	@Pattern(regexp = "Arthritis|Back Pain|Tissue Injuries|Dysmenorrhea|Skin Infection|Skin Burn|Ear Pain", message ="Not a valid symptoms")
	private String symptoms;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	
}
