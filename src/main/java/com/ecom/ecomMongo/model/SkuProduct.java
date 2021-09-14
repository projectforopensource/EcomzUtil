package com.ecom.ecomMongo.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GeneratorType;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection ="SkuProduct")
public class SkuProduct {
	


	@Transient
	public static final String SIZESEQUENCE = "size_sequence";

	private int rowIndex;
	
	@Id
	private Long id;
	
	private Long productId;
	
	private String prdName;
	
	private String brand;
	
	private int modelNumber;
	
	private String frdURL;
	
	private String skuCode;
	
	private String prdDesc;
	
	private String occasion;
	
	private String tags;
	
	private String gender;
	
	private boolean kids;
	
	private int minAge;
	
	private int maxAge;
	
	private boolean selfInvMgt;
	
	private boolean itemReturn;
	
	private boolean itemCancel;
	
	private int qty;
	
	private int qtyForOOSS;
	
	private int minQtyForCart;
	
	private int maxQtyForCart;
	
	private int notifyQty;
	
	private String shipping;
	
	private String shpTerms;
	
	private int shpCharges;
	
	private String priceType;
	
	private float mrp;
	
	private float listPrice;
	
	private String currencyType;
	
	private String taxType;
	
	private float taxPercentage;
	
	private boolean taxInclusive;
	
	private boolean giftWrapAvl;
	
	private float giftWrapAmt;
	
	private boolean codAvl;
	
	private boolean active;
	
	private String size;
	
	private int length;
	
	private String color;
	
	private String img1;
	
	private String img2;
	
	private String img3;
	
	private String img4;
	
	private String img5;
	
	private int prodRefId;
	
	private String uploadBy;
	
	private String designerName;
	
	private String designerId;
	
	private boolean isApproved=false;
	
	private String approvedBy;
	
	private Boolean isCustomizationPossible;
	
	private Boolean ifUpperBodyCustomization;
	
	private Boolean ifLowerCustomization;
	
	private String subCategoryId;


}
