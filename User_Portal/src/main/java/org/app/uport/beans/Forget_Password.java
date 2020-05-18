package org.app.uport.beans;

import java.sql.Timestamp;

public class Forget_Password {

	private Long id ;
	private String email_id ;
	private Timestamp date_of_birth ;
	private String newpassword ;
	private String confirmpassword ;
	
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
	public Timestamp getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Timestamp date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	@Override
	public String toString() {
		return "Forget_Password [id=" + id + ", email_id=" + email_id + ", date_of_birth=" + date_of_birth
				+ ", newpassword=" + newpassword + ", confirmpassword=" + confirmpassword + "]";
	}


}
