package com.ecom.ecomMongo.model;

import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author situpand
 *
 */
@Document(collection = "Category")
public class Category {
	@Transient
	public static final String CATEGORYSEQUENCE = "category_sequence";
	@Id
	private Long id;
	private String categoryName;
	private String categoryDescription;
	private Boolean status;
	private String categoryUrl;
	private String mobileImagePath;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCategoryUrl() {
		return categoryUrl;
	}

	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}

	public String getMobileImagePath() {
		return mobileImagePath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMobileImagePath(String mobileImagePath) {
		this.mobileImagePath = mobileImagePath;
	}

}
