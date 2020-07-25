package com.technolins.registrationform.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="adm_user")
public class User extends BaseEntity{


	@Id
	@GeneratedValue(generator="gen_user")
	@SequenceGenerator(name="gen_user", sequenceName="adm_user_id_seq", initialValue=1, allocationSize=1)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(name="first_name", nullable=false)
	private String firstName;
	@Column(name="last_name", nullable=false)
	private String lastName;
	@Column(name="mobile_number", unique=true, nullable=false)
	private String mobileNumber;
	@Column(name="date_of_birth", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(name="email", unique=true, nullable=true)
	private String email;
	@Column(name="gender", nullable=true)
	private Integer gender;

	public User() {
		super();
	}

	public User(Long id, String firstName, String lastName, String mobileNumber, Date dateOfBirth, String email,
			Integer gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
		builder.append("User [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", email=");
		builder.append(email);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdTerminal=");
		builder.append(createdTerminal);
		builder.append(", modifiedDate=");
		builder.append(modifiedDate);
		builder.append(", modifiedBy=");
		builder.append(modifiedBy);
		builder.append(", modifiedTerminal=");
		builder.append(modifiedTerminal);
		builder.append("]");
		return builder.toString();
	}
}
