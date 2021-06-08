package com.ecom.ecomMomgo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<SubCategory> saveSubcategoryService(List<SubCategory> subCategories) {
		
		return repository.saveAll(subCategories);
	}

	public Optional<SubCategory> getSubCategoryById(Integer subCatId) {
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

	public void deleteSubCategoryById(Integer subcatId) {
		// TODO Auto-generated method stub
		 repository.deleteById(subcatId);
		
	}

	public List<SubCategory> getSubcategoryByCategoryId(Integer categoryId) {
		// TODO Auto-generated method stub
		return repository.findByCategoryId(categoryId);
	}
}
