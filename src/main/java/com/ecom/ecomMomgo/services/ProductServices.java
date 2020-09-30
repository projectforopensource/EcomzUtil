package com.ecom.ecomMomgo.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ecom.ecomMongo.model.Product;
import com.ecom.ecomMongo.model.Specification;
import com.ecom.ecomMongo.repository.ProductRepository;
import com.ecom.ecomMongo.repository.SpecificationRepository;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	public List<Product> saveProductService(List<Product> products)
	{
		
		return repository.saveAll(products);
	}
	
	public Optional<Product> getProductById(Integer specid)
	{
		return repository.findById(specid);
	}
	
	public List<Product> getAllProducts()
	{
		return repository.findAll();
	}
	
	public List<Product> findProductsBySubCatId(int id){
		Query query=new Query();
		query.addCriteria(Criteria.where("prodRefId").is(id));
		return mongoTemplate.find(query, Product.class);
	}

	public List<Product> getProdctsBySearchCriteria(Map<String, Object> filterMap, Integer limit, Integer offset) {
		// TODO Auto-generated method stub
		return null;
	}
}
