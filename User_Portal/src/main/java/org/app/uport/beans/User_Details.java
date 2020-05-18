package org.app.uport.beans;

import java.sql.Timestamp;

public class User_Details {

	private Long id ;
	private String email_id ;
	private String name ;
	private String password ;
	private Long phone_number ;
	private Timestamp date_of_birth ;
	private String address ;
	private String gender ;
	private Timestamp updated_at ;  //this value will be taken by system automatically .
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	public Timestamp getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Timestamp date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "User_Details [id=" + id + ", email_id=" + email_id + ", name=" + name + ", password=" + password
				+ ", phone_number=" + phone_number + ", date_of_birth=" + date_of_birth + ", address=" + address
				+ ", gender=" + gender + ", updated_at=" + updated_at + "]";
	}

	

}
