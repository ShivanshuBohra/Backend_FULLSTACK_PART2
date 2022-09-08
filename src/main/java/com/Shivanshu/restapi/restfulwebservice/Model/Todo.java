package com.Shivanshu.restapi.restfulwebservice.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Todos")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	//@Transient  use if not want to save any field in db or no column present
	@Column(name ="USERNAME")
	private String userName;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name= "TARGET_DATE")
	private Date targetDate;
	
	@Column(name= "Done")
	private Boolean isDone;
	
	public Todo() {
		
	}

	public Todo(long id, String userName, String description , Boolean isDone, Date targetDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.description= description;
		this.isDone = isDone;
		this.targetDate = targetDate;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", userName=" + userName + ", description=" + description + ", targetDate="
				+ targetDate + ", isDone=" + isDone + "]";
	}


}
