package com.chrismeehan.productandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrismeehan.productandcategories.models.Category;
import com.chrismeehan.productandcategories.models.Product;
import com.chrismeehan.productandcategories.repositories.CategoryRepository;

@Service
public class CategoryServices {

	@Autowired
	CategoryRepository catRepo;
	
	// returns all categories
		public List<Category> allCategories(){
			return catRepo.findAll();
		}
		
		// Retrieves a list of any categories a particular product
	    // does not belong to
		public List<Category> catsNotWithProduct(Product product){
			return catRepo.findByProductsNotContains(product);
		}
		
		// create a category
		public Category createCategory(Category c) {
			return catRepo.save(c);
		}
		
		// get a category
		public Category getCategory(Long id) {
			Optional<Category> optionalCategory = catRepo.findById(id);
			if (optionalCategory.isPresent()) {
				return optionalCategory.get();
			}
			return null;
		}
		
		// update a category
		public Category updateCategory(Category c) {
			return catRepo.save(c);
		}
		
		// delete a category
		public Category deleteCategory(Long id) {
			Optional<Category> optionalCategory = catRepo.findById(id);
			if (optionalCategory.isPresent()) {
				catRepo.deleteById(id);
			}
			return null;
		}
}
