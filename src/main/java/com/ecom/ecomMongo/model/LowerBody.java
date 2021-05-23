package com.ecom.ecomMongo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
public class LowerBody {


	private String waiste;
	private String hip;
	private String crotch;
	private String thigh;
	private String ankel;
	private String legLenth;
	private String seat;
	private String inseamLength;
	private String heapToKnee;
	private String calf;
	
	
}
