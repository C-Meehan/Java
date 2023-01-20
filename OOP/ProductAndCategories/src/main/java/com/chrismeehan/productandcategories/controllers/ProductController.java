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
import org.springframework.web.bind.annotation.PutMapping;

import com.chrismeehan.productandcategories.models.Category;
import com.chrismeehan.productandcategories.models.Product;
import com.chrismeehan.productandcategories.services.CategoryServices;
import com.chrismeehan.productandcategories.services.ProductServices;

@Controller
public class ProductController {

	@Autowired
	ProductServices productServ;
	
	@Autowired
	CategoryServices catServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", productServ.allProducts());
		model.addAttribute("categories", catServ.allCategories());
		return "index.jsp";
	}
	
	@GetMapping("/product/create")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "newProduct.jsp";
	}
	
	@PostMapping("/product/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product,
			BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}
		productServ.createProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productServ.getProduct(id);
		model.addAttribute("category", new Category());
		model.addAttribute("product", product);
		model.addAttribute("categories", catServ.catsNotWithProduct(product));
		return "product.jsp";
	}
	
	@PostMapping("/product/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("category") Category category, Model model) {
		Product product = productServ.getProduct(id);
		Category cat = catServ.getCategory(category.getId());
		product.getCategories().add(cat);
		productServ.createProduct(product);
		return "redirect:/product/" + id;
	}
}
