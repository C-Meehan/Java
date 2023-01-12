package com.chrismeehan.dojoandninja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chrismeehan.dojoandninja.models.Dojo;
import com.chrismeehan.dojoandninja.models.Ninja;
import com.chrismeehan.dojoandninja.services.DojoService;
import com.chrismeehan.dojoandninja.services.NinjaService;

@Controller
public class MainController {

	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "index.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		Dojo newDojo = dojoService.createDojo(dojo);
		return String.format("redirect:/dojos/%s", newDojo.getId());
	}
	
	@GetMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "show.jsp";
	}
	
	@GetMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "ninja.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "ninja.jsp";
		}
//		Ninja newNinja = ninjaService.createNinja(ninja);
		return String.format("redirect:/dojos/%s", ninjaService.createNinja(ninja).getDojo().getId());
	}
}
