package com.chrismeehan.burgertracker.controllers;

import java.util.List;

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

import com.chrismeehan.burgertracker.models.Burger;
import com.chrismeehan.burgertracker.services.BurgerService;

@Controller
public class BurgerController {

		@Autowired
		BurgerService burgerService;
		
		@GetMapping("/burgers")
		public String index(@ModelAttribute("burger") Burger burger, Model model) {
			List<Burger> burgers = burgerService.allBurgers();
			model.addAttribute("burgers", burgers);
			return "index.jsp";
		}
		
		@PostMapping("/addBurger")
		public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
			if (result.hasErrors()) {
				return "index.jsp";
			}
			burgerService.createBurger(burger);
			return "redirect:/burgers";
		}
		
		@GetMapping("/burgers/edit/{id}")
		public String edit(@ModelAttribute("burger") Burger burger,Model model,@PathVariable("id") Long id) {
//			Burger burger = burgerService.findBurger(id);
			model.addAttribute("burger", burgerService.findBurger(id));
			return "edit.jsp";
		}
		
		@PutMapping("/editBurger/{id}")
		public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, @PathVariable("id") Long id, Model model){
			if (result.hasErrors()) {
				model.addAttribute("burger", burger);
				return "edit.jsp";
			}
			burgerService.updateBurger(burger);
			return "redirect:/burgers";
		}
}
		
