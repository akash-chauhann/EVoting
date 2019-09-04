package com.bean.voting;

public class Voter {

	 private  String firstname;
	 private String lastname;
	 private String password;
	 private String confirmpassword;
	 private  int id;
	 
	
	public Voter(String firstname, String lastname, String password, String confirmpassword, int id) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	   
	
	
}
