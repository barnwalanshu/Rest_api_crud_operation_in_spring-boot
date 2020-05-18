package org.app.uport.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="User_Detail")
public class User_Detail_Entity {

	@Id
	private Long id ;
	
	@NotNull
	@Column(name="email_id")
	private String email_id ;
	
	@NotNull
	@Column(name="name")
	private String name ;
	
	@NotNull
	@Column(name="password")
	private String password ;
	
	@NotNull
	@Column(name="phone_number")
	private Long phone_number ;
	
	@NotNull
	@Column(name="date_of_birth")
	private Timestamp date_of_birth ;
	
	@Column(name="address")
	private String address ;
	
	@Column(name="gender")
	private String gender ;
	
	@Column(name="updated_at")   //this value will be taken by system automatically .
	private Timestamp updated_at ;

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
	
}
