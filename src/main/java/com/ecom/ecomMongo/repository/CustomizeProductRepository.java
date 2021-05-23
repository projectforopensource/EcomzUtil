package com.ecom.ecomMongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecom.ecomMongo.model.CustomizedProduct;

public interface CustomizeProductRepository extends MongoRepository<CustomizedProduct, Integer>{

	List<CustomizedProduct> findByDesignerId(String designerId);

	List<CustomizedProduct> findByProductId(String productId);
	

}
