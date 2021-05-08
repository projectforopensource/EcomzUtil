package com.ecom.ecomMongo.model;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document(collection = "CustomizedProduct")
@Data
public class CustomizedProduct {
	
	@Id
	private Integer id;
	private String productId;
	private String designerId;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "upperBody_id", referencedColumnName = "id")
	private UpperBody uBody;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lowerBody_id", referencedColumnName = "id")
	private LowerBody lBody;
	
	

}
