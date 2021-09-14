package com.ecom.ecomMomgo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.ecom.ecomMongo.model.Category;
import com.ecom.ecomMongo.model.SubCategory;
import com.ecom.ecomMongo.repository.SubCategoryRepository;

/**
 * @author situpand
 *
 */
@Service
public class SubcategoryServices {

	@Autowired
	private SubCategoryRepository repository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	public List<SubCategory> saveSubcategoryService(List<SubCategory> subCategories) {
		for(SubCategory subcategory:subCategories)
		{
			if(getSubCategoryById(subcategory.getId()).isEmpty())
			{
				subcategory.setId(sequenceGeneratorService.generateSequence(SubCategory.SUBCATEGORYSEQUENCE));
				repository.save(subcategory);
				}else {
					SubCategory existingsubCategory=getSubCategoryById(subcategory.getId()).get();
					subcategory.setId(existingsubCategory.getId());
					mongoTemplate.save(subcategory);
				}
				
			
		}
		return subCategories;
	}

	public Optional<SubCategory> getSubCategoryById(Long subCatId) {
		// TODO Auto-generated method stub
		return repository.findById(subCatId);
	}
	
	
	
	public List<SubCategory> getAllSubCategory() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public List<SubCategory> getAllSubCategoryByStatus(Boolean status) {
		// TODO Auto-generated method stub
		return repository.findByStatus(status);
	}

	public void deleteSubCategoryById(Long subcatId) {
		// TODO Auto-generated method stub
		 repository.deleteById(subcatId);
		
	}

	public List<SubCategory> getSubcategoryByCategoryId(Integer categoryId) {
		// TODO Auto-generated method stub
		return repository.findByCategoryId(categoryId);
	}
}
