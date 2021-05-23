package com.ecom.ecomMongo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GeneratorType;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
public class UpperBody {

	
	
	private String collar;
	private String chest;
	private String waist;
	private String hip;
	private String seat;
	private String shoulder;
	private String armhole;
	private String sleevLength;
	private String biceps;
	private String wrist;
	private String forearm;
	private String shirtLength;
	private String shoulderToKneeLength;
	
}
