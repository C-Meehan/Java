package com.chrismeehan.productandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrismeehan.productandcategories.models.Category;
import com.chrismeehan.productandcategories.models.Product;
import com.chrismeehan.productandcategories.repositories.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepository productRepo;
	
	// returns all products
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	// Retrieves a list of products that don't belong to a category
	public List<Product> productsNotWithCat(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	// create a product
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}
	
	// get a product
	public Product getProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	// update a product
	public Product updateProduct(Product p) {
		return productRepo.save(p);
	}
	
	// delete a product
	public Product deleteProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			productRepo.deleteById(id);
		}
		return null;
	}
}
