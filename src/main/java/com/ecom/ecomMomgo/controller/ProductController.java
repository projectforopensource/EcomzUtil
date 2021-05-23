package com.ecom.ecomMomgo.controller;

import java.util.ArrayList;
import java.util.Collections;
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

import com.ecom.ecomMomgo.services.ProductServices;
import com.ecom.ecomMongo.model.Category;
import com.ecom.ecomMongo.model.CustomizedProduct;
import com.ecom.ecomMongo.model.Product;
import com.ecom.ecomMongo.repository.CustomizeProductRepository;
import com.ecom.ecomMongo.repository.ProductRepository;

/**
 * @author aryansh
 *
 */

@RestController
@RequestMapping("/v1")
public class ProductController {

	@Autowired
	private ProductServices service;
	
	@Autowired
	CustomizeProductRepository custRepo;

	@PostMapping("/addProduct")
	public void saveProduct(@RequestBody List<Product> products) {
		service.saveProductService(products);
		System.out.println("Product saved sucessful");
	}

	
	@GetMapping("/findAllProducts")
	public ResponseEntity<?> getProducts() {
		return (ResponseEntity<?>) Optional.of(service.getAllProducts())
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get product"));

	}

	@GetMapping("/findProduct/{id}")
	public ResponseEntity<?> getProduct(@PathVariable int id) {

		return (ResponseEntity<?>) Optional.of(service.getProductById(id))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get product"));

	}

	@GetMapping("/findProductList/{SubCatid}")
	public ResponseEntity<?> getProductsBySubCatId(@PathVariable int SubCatid){
		
		return (ResponseEntity<?>) Optional.of(service.findProductsBySubCatId(SubCatid))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get product"));
	}
	
	@GetMapping("/findProductListByDesignerName/{designerName}")
	public ResponseEntity<?> getProductsByDesigner(@PathVariable String designerName){
		
		return (ResponseEntity<?>) Optional.of(service.findProductsByDesigner(designerName))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get product"));
	}
	
	@GetMapping("/findProductListByDesignerId/{designerId}")
	public ResponseEntity<?> getProductsByDesignerId(@PathVariable String designerId){
		
		return (ResponseEntity<?>) Optional.of(service.findProductsByDesignerId(designerId))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get product"));
	}
	@PostMapping("/approveProduct/{productId}/{approvedBy}/{isApproved}")
	public List<Product> approveProduct(@PathVariable Integer productId,@PathVariable String approvedBy,@PathVariable Boolean isApproved)
	{
		//ArrayList<Product> prodArray=new ArrayList<Product>();
		Optional<Product> products=service.getProductById(productId);
		List<Product> productList=products.isPresent()
        ?  Collections.singletonList(products.get())
        :  Collections.emptyList();
		ArrayList<Product> prodArray=new ArrayList<Product>(productList);
		if(products.isPresent())
		{
			Product p=products.get();
			p.setApproved(isApproved);
			p.setApprovedBy(approvedBy);
			
			prodArray.add(p);
			return service.saveProductService(prodArray);
			
		}else {
		return prodArray;
		}
	}
	
	@GetMapping("/findAllProduct/{isApproved}")
	public ResponseEntity<?> getProduct(@PathVariable Boolean isApproved) {

		return (ResponseEntity<?>) Optional.of(service.getProductByApproval(isApproved))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get product"));

	}
	@GetMapping("/findApprovedProductListByDesignerId/{designerId}/{approved}")
	public ResponseEntity<?> getApprovedProductsByDesignerId(@PathVariable String designerId,@PathVariable Boolean approved){
		
		return (ResponseEntity<?>) Optional.of(service.findApprovedProductsByDesignerId(designerId,approved))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get product"));
	}
	@PostMapping("/saveCustomizationProduct")
	public ResponseEntity<?> saveCustomisationDetails(@RequestBody CustomizedProduct custProduct)
	{		
		custProduct=custRepo.save(custProduct);
		return ResponseEntity.ok(custProduct);
		
	}
	
	@GetMapping("/findCustomizedProductListByDesignerId/{designerId}")
	public ResponseEntity<?> getCustomizedProductsByDesignerId(@PathVariable String designerId){
		
		return (ResponseEntity<?>) Optional.of(service.findcustomizedProductsByDesignerId(designerId))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get product"));
	}
	
	@GetMapping("/findAllCustomizedProduct")
	public ResponseEntity<?> getAllCustomizedProduct(){
		
		return (ResponseEntity<?>) Optional.of(custRepo.findAll())
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get product"));
	}
	
	@GetMapping("/findCustomizedProductByProductId/{productId}")
	public ResponseEntity<?> getCustomizedProductsByProductId(@PathVariable String productId){
		
		return (ResponseEntity<?>) Optional.of(service.findcustomizedProductsByProductId(productId))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Could not get product"));
	}
	
}
