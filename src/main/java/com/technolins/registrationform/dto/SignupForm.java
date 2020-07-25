package com.technolins.registrationform.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SignupForm {
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@Pattern(regexp = "^[+]62+[0-9]*", message = "Please enter valid Indonesian phone number")
	private String mobileNumber;
	private String day;
	private String month;
	private String year;
	@NotEmpty
	@Email(message = "Please enter valid email")
	private String email;
	private Integer gender;

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
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SignupForm [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", day=");
		builder.append(day);
		builder.append(", month=");
		builder.append(month);
		builder.append(", year=");
		builder.append(year);
		builder.append(", email=");
		builder.append(email);
		builder.append(", gender=");
		builder.append(gender);
		builder.append("]");
		return builder.toString();
	}
}
