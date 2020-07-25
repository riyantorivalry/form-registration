package com.technolins.registrationform.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseEntity {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
	@Temporal(TemporalType.DATE)
	@Column(name="created_date", nullable=true)
	protected Date createdDate;
	@Column(name="created_by", nullable=true)
	protected String createdBy;
	@Column(name="created_terminal", nullable=true)
	protected String createdTerminal;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
	@Temporal(TemporalType.DATE)
	@Column(name="update_date", nullable=true)
	protected Date modifiedDate;
	@Column(name="update_by", nullable=true)
	protected String modifiedBy;
	@Column(name="update_terminal", nullable=true)
	protected String modifiedTerminal;

	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedTerminal() {
		return createdTerminal;
	}
	public void setCreatedTerminal(String createdTerminal) {
		this.createdTerminal = createdTerminal;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedTerminal() {
		return modifiedTerminal;
	}
	public void setModifiedTerminal(String modifiedTerminal) {
		this.modifiedTerminal = modifiedTerminal;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseEntity [createdDate=");
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
