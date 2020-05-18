package org.app.uport.beans;
/**
 * 
 * @author ANSHU
 *
 */
public class User_Login {

	private Long id ;
	private String password ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User_Login [id=" + id + ", password=" + password + "]";
	}

}
