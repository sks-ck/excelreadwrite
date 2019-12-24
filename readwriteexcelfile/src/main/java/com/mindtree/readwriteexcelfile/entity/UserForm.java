package com.mindtree.readwriteexcelfile.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private long mobile;
	private String email;
	private String gender;
	private String designation;
	public UserForm() {
		super();
	}
	public UserForm(int userId, String userName, long mobile, String email, String gender, String designation) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.designation = designation;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "UserForm [userId=" + userId + ", userName=" + userName + ", mobile=" + mobile + ", email=" + email
				+ ", gender=" + gender + ", designation=" + designation + "]";
	}
}
