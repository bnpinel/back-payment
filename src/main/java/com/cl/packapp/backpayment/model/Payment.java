package com.cl.packapp.backpayment.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

public class Payment {
	@Id
    private String id;
	private String card_id;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate date;
	private String description;

	 public Payment(String id, String card_id, LocalDate date, String description) {
	    	this.id = id;
	    	this.card_id = card_id;
	    	this.date = date;
	    	this.description = description;
	    }
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String Id) {
		this.id = id;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}

