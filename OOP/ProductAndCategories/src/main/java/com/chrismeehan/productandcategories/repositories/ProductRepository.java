package com.chrismeehan.productandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chrismeehan.productandcategories.models.Category;
import com.chrismeehan.productandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	
    // Retrieves a list of all categories for a particular product
    List<Product> findAllByCategories(Category category);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category category);

}
