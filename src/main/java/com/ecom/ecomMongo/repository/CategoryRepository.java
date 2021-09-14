package com.ecom.ecomMongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecom.ecomMongo.model.Category;
import com.ecom.ecomMongo.model.Product;

public interface CategoryRepository extends MongoRepository<Category, Long> {

	List<Category> findByStatus(Boolean status);
}
