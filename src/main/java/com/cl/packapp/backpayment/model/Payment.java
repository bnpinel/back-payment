package com.cl.packapp.backpayment.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

public class Payment {
	@Id
    private String id;
	private String date;
	private String description;

	 public Payment(String id, String date, String description) {
	    	this.id = id;
	    	this.date = date;
	    	this.description = description;
	    }
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String Id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}

