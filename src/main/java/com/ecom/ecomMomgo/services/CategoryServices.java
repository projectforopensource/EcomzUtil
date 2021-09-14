package com.ecom.ecomMomgo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ecom.ecomMongo.model.Category;
import com.ecom.ecomMongo.model.Product;
import com.ecom.ecomMongo.repository.CategoryRepository;

@Service
public class CategoryServices {

	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	public List<Category> saveCategoryService(List<Category> catagories) {
		for(Category category:catagories)
		{
			if(getCategoryById(category.getId()).isEmpty())
			{
			category.setId(sequenceGeneratorService.generateSequence(Category.CATEGORYSEQUENCE));
			repository.save(category);
			}else {
				Category existingCategory=getCategoryById(category.getId()).get();
				category.setId(existingCategory.getId());
				mongoTemplate.save(category);
			}
		}
		//return repository.saveAll(catagories);
		return catagories;
	}
	
	

	public Optional<Category> getCategoryById(Long catId) {
		// TODO Auto-generated method stub
		return repository.findById(catId);
	}

	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public List<Category> getCategoryByStatus(Boolean status) {
		// TODO Auto-generated method stub
		return repository.findByStatus(status);
	}

	public void deleteCategory(Long catId) {
		// TODO Auto-generated method stub
		repository.deleteById(catId);
		
	}
}
