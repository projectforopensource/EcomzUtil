package com.ecom.ecomMomgo.constants;

import java.util.Date;

import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "DivattConstant")
public class DivattConstants {

	@Transient
	public static  final String SEARCH_DELIMITER = ":";
	
	@Transient
	public static final String CONSTANT_SEQ_GENERATOR="Divatt_constant_Sequence";
	
	
	
	@Id
	private  Integer constId;
	private String constType;
	private String constValue;
	private Boolean status;
	private Date created;
	private Date lastModified;
	private String createdBy;
	private String imagePath;

}
