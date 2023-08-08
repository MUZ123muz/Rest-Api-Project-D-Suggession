package com.cetpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
public class Doctor {

	@Id
	@GeneratedValue(generator = "doc_seq")
	@SequenceGenerator(name= "doc_seq", initialValue=111,allocationSize=1)
	private int did;
	@NotNull(message = "name can not be null")
	@Size(min=3,message = "Name must have atleast 3 characters")
	private String name;
	@NotNull(message = "city is required")
	@Pattern(regexp = "Delhi|Noida|Faridabad" , message = "City should be either Delhi or Noida or Faridabad")
	private String city;
	@NotNull(message = "email is required")
	@Email(message = "Invalid Email")
	private String email;
	@NotNull(message = "phone is required")
	@Size(min = 10, message = "Phone number must have atleast 10 characters ")
	private String phone;
	@NotNull(message = "speciality is required")
	@Pattern(regexp = "Orthopedic|Gynecology|Dermotology|ENT", message = "Speciality can have 4 values Orthopedic or Gynecology or Dermotology or Ent")
	private String speciality;
	
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
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
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	
	
}
