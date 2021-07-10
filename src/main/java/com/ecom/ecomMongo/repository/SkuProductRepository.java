package com.ecom.ecomMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecom.ecomMongo.model.SkuProduct;

public interface SkuProductRepository extends MongoRepository<SkuProduct, Integer> {

}
