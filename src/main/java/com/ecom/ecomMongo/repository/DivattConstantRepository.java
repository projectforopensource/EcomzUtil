package com.ecom.ecomMongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecom.ecomMomgo.constants.DivattConstants;

public interface DivattConstantRepository extends MongoRepository<DivattConstants, Integer> {

	List<DivattConstants> findByConstType(String constType);
	List<DivattConstants> findByConstId(Integer constId);
}
