package com.ecom.ecomMongo.model;

import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SubCategory")
public class SubCategory {

	@Transient
	public static final String SUBCATEGORYSEQUENCE = "subcategory_sequence";
	private Integer categoryId;
	@Id
	private Long id;
	private String subCategoryName;
	private String subCategoryDescription;
	private Boolean status;
	private Integer mandatoryAttribute;
	private String attribute;
	private Integer preferedAttribute;
	private Integer indexingAttribute;
	private String subCategoryUrl;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getSubCategoryDescription() {
		return subCategoryDescription;
	}
	public void setSubCategoryDescription(String subCategoryDescription) {
		this.subCategoryDescription = subCategoryDescription;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Integer getMandatoryAttribute() {
		return mandatoryAttribute;
	}
	public void setMandatoryAttribute(Integer mandatoryAttribute) {
		this.mandatoryAttribute = mandatoryAttribute;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public Integer getPreferedAttribute() {
		return preferedAttribute;
	}
	public void setPreferedAttribute(Integer preferedAttribute) {
		this.preferedAttribute = preferedAttribute;
	}
	public Integer getIndexingAttribute() {
		return indexingAttribute;
	}
	public void setIndexingAttribute(Integer indexingAttribute) {
		this.indexingAttribute = indexingAttribute;
	}
	public String getSubCategoryUrl() {
		return subCategoryUrl;
	}
	public void setSubCategoryUrl(String subCategoryUrl) {
		this.subCategoryUrl = subCategoryUrl;
	}

	
}
