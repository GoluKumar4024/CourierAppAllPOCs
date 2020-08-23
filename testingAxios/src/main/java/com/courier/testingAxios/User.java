package com.courier.testingAxios;

public class User {
	
	
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private String password;
	private String confirmPassword;
	private boolean isAgree;
	
	

	public User() {
		super();
	}



	public User(String firstName, String lastName, String mobileNumber, String email, String password,
			String confirmPassword, boolean isAgree) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.isAgree = isAgree;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	public boolean isAgree() {
		return isAgree;
	}



	public void setAgree(boolean isAgree) {
		this.isAgree = isAgree;
	}



	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", email="
				+ email + ", password=" + password + ", confirmPassword=" + confirmPassword + ", isAgree=" + isAgree
				+ "]";
	}



	
	
	
	
	
	
	
}
