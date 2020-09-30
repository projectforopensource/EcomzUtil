package com.ecom.ecomMongo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;

/**
 * @author Naidu
 *
 */

@Document(collection = "ProductStore")
public class Product {
	@Id
    public int rowIndex;
	
	public String prdName;
	
	public String brand;
	
	public int modelNumber;
	
	public String frdURL;
	
	public String skuCode;
	
	public String prdDesc;
	
	public String occasion;
	
	public String tags;
	
	public String gender;
	
	public boolean kids;
	
	public int minAge;
	
	public int maxAge;
	
	public boolean selfInvMgt;
	
	public boolean itemReturn;
	
	public boolean itemCancel;
	
	public int qty;
	
	public int qtyForOOSS;
	
	public int minQtyForCart;
	
	public int maxQtyForCart;
	
	public int notifyQty;
	
	public String shipping;
	
	public String shpTerms;
	
	public int shpCharges;
	
	public String priceType;
	
	public float mrp;
	
	public float listPrice;
	
	public String currencyType;
	
	public String taxType;
	
	public float taxPercentage;
	
	public boolean taxInclusive;
	
	public boolean giftWrapAvl;
	
	public float giftWrapAmt;
	
	public boolean codAvl;
	
	public boolean active;
	
	public int size;
	
	public String img1;
	
	public String img2;
	
	public String img3;
	
	public String img4;
	
	public int prodRefId;
	
	 @Override
	    public String toString() {
	        return "Product{" +
	                "rowIndex=" + rowIndex +
	                ", prdName=" + prdName +
	                ", brand='" + brand + '\'' +
	                ", modelNumber='" + modelNumber + '\'' +
	                ", frdURL=" + frdURL +
	                ", skuCode=" + skuCode +
	                ", prdDesc=" + prdDesc +
	                ", occasion=" + occasion +
	                ", tags=" + tags +
	                ", kids=" + kids +
	                ", minAge=" + minAge +
	                ", maxAge=" + maxAge +
	                ", selfInvMgt=" + selfInvMgt +
	                ", itemReturn=" + itemReturn +
	                ", itemCancel=" + itemCancel +
	                ", qty=" + qty +
	                ", qtyForOOSS=" + qtyForOOSS +
	                ", minQtyForCart=" + minQtyForCart +
	                ", maxQtyForCart=" + maxQtyForCart +
	                ", notifyQty=" + notifyQty +
	                ", shipping=" + shipping +
	                ", shpTerms=" + shpTerms +
	                ", shpCharges=" + shpCharges +
	                ", priceType=" + priceType +
	                ", mrp=" + mrp +
	                ", listPrice=" + listPrice +
	                ", currencyType=" + currencyType +
	                ", taxType=" + taxType +
	                ", taxPercentage=" + taxPercentage +
	                ", taxInclusive=" + taxInclusive +
	                ", giftWrapAvl=" + giftWrapAvl +
	                ", giftWrapAmt=" + giftWrapAmt +
	                ", codAvl=" + codAvl +
	                ", active=" + active +
	                ", size=" + size +
	                ", img1=" + img1 +
	                ", img2=" + img2 +
	                ", img3=" + img3 +
	                ", img4=" + img4 +
	                ", prodRefId=" + prodRefId + '\''+
	                '}';
	    }
			
}
