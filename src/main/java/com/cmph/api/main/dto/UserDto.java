package com.cmph.api.main.dto;

public class UserDto {

	private String userName;
	private String password;
	private String email;
	private String mobile;

	public UserDto() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", password=" + password + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}
}
