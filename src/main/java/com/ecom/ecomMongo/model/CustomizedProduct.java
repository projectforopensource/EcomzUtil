package com.ecom.ecomMongo.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document(collection = "CustomizedProduct")
@Data
public class CustomizedProduct {
	
	@Id
	private Integer id;
	private String productId;
	private String designerId;
	private String orderId;
	private String status;
	private String custZName;
	
	private UpperBody uBody;
	
	
	public UpperBody getuBody() {
		return uBody;
	}


	public void setuBody(UpperBody uBody) {
		this.uBody = uBody;
	}


	public LowerBody getlBody() {
		return lBody;
	}


	public void setlBody(LowerBody lBody) {
		this.lBody = lBody;
	}


	private LowerBody lBody;
	
	

}
