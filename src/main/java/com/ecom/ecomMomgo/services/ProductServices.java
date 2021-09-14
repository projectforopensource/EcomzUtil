package com.ecom.ecomMomgo.services;

import java.util.Arrays;
import java.util.List;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.ecom.ecomMongo.model.CustomizedProduct;
import com.ecom.ecomMongo.model.Product;
import com.ecom.ecomMongo.model.SkuProduct;
import com.ecom.ecomMongo.repository.CustomizeProductRepository;
import com.ecom.ecomMongo.repository.ProductRepository;
import com.ecom.ecomMongo.repository.SkuProductRepository;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private CustomizeProductRepository custProductRepo;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private SkuProductRepository skuProductRepository;

	public List<Product> saveProductService(List<Product> products) {

		products.forEach(p -> {
			if (getProductByRowIndex(p.getId()) == null) {
				saveMongoOperations(products);
			} else {
				Product product = getProductByRowIndex(p.getId());
				p.setId(product.getId());
				mongoTemplate.save(p);

			}
		});
		return products;
	}

	private void copyToExistingProduct(Product p, Product product) {
		// TODO Auto-generated method stub

	}

	public Optional<Product> getProductById(Integer specid) {
		return repository.findById(specid);
	}

	public Product getProductByRowIndex(Long rowIndex) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(rowIndex));
		return mongoOperations.findOne(query, Product.class);
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public List<Product> findProductsBySubCatId(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("subCategoryId").is(id));
		return mongoTemplate.find(query, Product.class);
	}

	public List<Product> getProdctsBySearchCriteria(Map<String, Object> filterMap, Integer limit, Integer offset) {
		// TODO Auto-generated method stub
		return null;
	}

	public String saveMongoOperations(List<Product> products) {
		/*
		 * for (Product product : products) {
		 * 
		 * TextIndexDefinition textIndex = new
		 * TextIndexDefinition.TextIndexDefinitionBuilder().onField("prdDesc")
		 * .onField("prdName").onField("color").onField("skuCode").build();
		 * mongoTemplate.indexOps(Product.class).ensureIndex(textIndex);
		 * mongoTemplate.save(product);
		 * 
		 * }
		 */
		products.stream().forEach(p -> {
			TextIndexDefinition textIndex = new TextIndexDefinition.TextIndexDefinitionBuilder().onField("prdDesc")
					.onField("prdName").onField("color").onField("skuCode").build();
			mongoTemplate.indexOps(Product.class).ensureIndex(textIndex);
			p.setId(sequenceGeneratorService.generateSequence(Product.PRODUCTSEQUENCE));
			Product product = mongoTemplate.save(p);
			Query query = new Query();
			query.addCriteria(Criteria.where("productId").is(p.getId()));
			// mongoTemplate.findAndRemove(query, SkuProduct.class);
			mongoTemplate.remove(query, SkuProduct.class);
			List<String> skuList = Arrays.asList(product.getSkuCode().split(","));
			if (skuList.size() > 1) {
				skuList.stream().forEach(size -> {
					mongoTemplate.save(createSkuProduct(product, size));
				});

			}

		});
		return "Saved sucessful";

	}

	private SkuProduct createSkuProduct(Product p, String size) {

		SkuProduct skuProduct = new SkuProduct();
		skuProduct.setActive(p.isActive());
		skuProduct.setApproved(p.isApproved());
		skuProduct.setApprovedBy(p.getApprovedBy());
		skuProduct.setBrand(p.getBrand());
		skuProduct.setCodAvl(p.isCodAvl());
		skuProduct.setColor(p.getColor());
		skuProduct.setCurrencyType(p.getCurrencyType());
		skuProduct.setDesignerId(p.getDesignerId());
		skuProduct.setDesignerName(p.getDesignerName());
		skuProduct.setFrdURL(p.getFrdURL());
		skuProduct.setGender(p.getGender());
		skuProduct.setGiftWrapAmt(p.getGiftWrapAmt());
		skuProduct.setGiftWrapAvl(p.isGiftWrapAvl());
		skuProduct.setIfLowerCustomization(p.getIfLowerCustomization());
		skuProduct.setIfUpperBodyCustomization(p.getIfUpperBodyCustomization());
		skuProduct.setImg1(p.getImg1());
		skuProduct.setImg2(p.getImg2());
		skuProduct.setImg3(p.getImg3());
		skuProduct.setProductId(p.getId());
		skuProduct.setSize(size);
		skuProduct.setId(sequenceGeneratorService.generateSequence(SkuProduct.SIZESEQUENCE));

		return skuProduct;
	}

	public List<Product> findBySearch(String searchValue) {
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(searchValue);
		List<Product> products = mongoOperations.find(query(criteria), Product.class);
		return products;
	}

	public List<Product> findProductsByDesigner(String designer) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("designerName").is(designer));
		return mongoTemplate.find(query, Product.class);
	}

	public List<Product> findProductsByDesignerId(String id) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("designerId").is(id));
		return mongoTemplate.find(query, Product.class);
	}

	public List<Product> getProductByApproval(Boolean isApproved) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("isApproved").is(isApproved));
		return mongoTemplate.find(query, Product.class);
	}

	public List<Product> findApprovedProductsByDesignerId(String designerId, Boolean approved) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("designerId").is(designerId));
		List<Product> prodList = mongoTemplate.find(query, Product.class);
		return prodList.stream().filter(p -> p.isApproved == approved).collect(Collectors.toList());
	}

	public List<CustomizedProduct> findcustomizedProductsByDesignerId(String designerId) {
		// TODO Auto-generated method stub
		return custProductRepo.findByDesignerId(designerId);
	}

	public List<CustomizedProduct> findcustomizedProductsByProductId(String productId) {
		// TODO Auto-generated method stub
		return custProductRepo.findByProductId(productId);
	}
}
