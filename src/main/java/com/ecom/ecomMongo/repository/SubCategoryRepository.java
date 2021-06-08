package com.ecom.ecomMongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecom.ecomMongo.model.SubCategory;

public interface SubCategoryRepository extends MongoRepository<SubCategory, Integer>  {

	List<SubCategory> findByStatus(Boolean status);
	List<SubCategory> findByCategoryId(Integer categoryId);
}
