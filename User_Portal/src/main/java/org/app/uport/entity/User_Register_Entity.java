package org.app.uport.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="User_Login")

public class User_Register_Entity
{
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
	@Column(name="date_of_birth")
	private Timestamp date_of_birth ;

	@NotNull
	@Column(name="created_at")
	private Timestamp created_at ;

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

/*	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
*/
	public Timestamp getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Timestamp date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	

}
