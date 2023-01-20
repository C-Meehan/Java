package com.chrismeehan.productandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chrismeehan.productandcategories.models.Category;
import com.chrismeehan.productandcategories.models.Product;
import com.chrismeehan.productandcategories.services.CategoryServices;
import com.chrismeehan.productandcategories.services.ProductServices;

@Controller
public class CategoryController {

	@Autowired
	CategoryServices catServ;
	
	@Autowired
	ProductServices productServ;
	
	@GetMapping("/category/create")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCat.jsp";
	}
	
	@PostMapping("/category/create")
	public String createCat(@Valid @ModelAttribute("category") Category category,
			BindingResult result) {
		if (result.hasErrors()) {
			return "newCat.jsp";
		}
		catServ.createCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/category/{id}")
	public String showCat(@PathVariable("id") Long id, Model model) {
		Category category = catServ.getCategory(id);
		model.addAttribute("product", new Product());
		model.addAttribute("category", category);
		model.addAttribute("products", productServ.productsNotWithCat(category));
		return "cat.jsp";
	}
	
	@PostMapping("/category/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("product") Product product, Model model) {
		Category category = catServ.getCategory(id);
		Product oneProduct = productServ.getProduct(product.getId());
		category.getProducts().add(oneProduct);
		catServ.createCategory(category);
		return "redirect:/category/" + id;
	}
}
