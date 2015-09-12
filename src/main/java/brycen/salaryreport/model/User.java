package brycen.salaryreport.model;

import java.util.Date;
public class User {
	
	private Long id;	
	private String userName;

	private String password;
	
	private String email;
	

		
	public String getEmail() {
		return email;
	}
	

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}	

}
