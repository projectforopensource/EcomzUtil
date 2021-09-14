package com.ecom.ecomMomgo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ecomMomgo.services.SubcategoryServices;
import com.ecom.ecomMongo.model.SubCategory;

@RestController
@RequestMapping("/v1")
public class SubCategoryController {

	@Autowired
	private SubcategoryServices services;

	@PostMapping("/addSubCategory")
	public void saveSubCategory(@RequestBody List<SubCategory> subCategories) {
		services.saveSubcategoryService(subCategories);
		System.out.println("subcatagory saved sucessfully");
		;
	}

	@GetMapping(path = "/subCategory/{subCatId}")
	public ResponseEntity<?> findCatagoryById(@PathVariable Long subCatId) {

		return (ResponseEntity<?>) Optional.of(services.getSubCategoryById(subCatId))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get Fund events"));

	}

	@GetMapping(path = "/subCategory/allSubCatagory")
	public ResponseEntity<?> findAllSubCategory() {

		return (ResponseEntity<?>) Optional.of(services.getAllSubCategory())
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get Fund events"));

	}
	
	@GetMapping(path = "/subCategory/allSubCatagoryByStatus/{status}")
	public ResponseEntity<?> findAllSubCategoryByStatus(@PathVariable Boolean status) {

		return (ResponseEntity<?>) Optional.of(services.getAllSubCategoryByStatus(status))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get any record"));

	}
	@DeleteMapping(path="/deleteSubCategoryById/{subcatId}")
	public void deleteSubCategoryById(@PathVariable Long subcatId)
	{
		services.deleteSubCategoryById(subcatId);
	}
	
	@GetMapping(path = "/subCategory/getSubcategoryByCategoryId/{categoryId}")
	public ResponseEntity<?> getSubcategoryByCategoryId(@PathVariable Integer categoryId) {

		return (ResponseEntity<?>) Optional.of(services.getSubcategoryByCategoryId(categoryId))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get any record"));

	}
	
}
