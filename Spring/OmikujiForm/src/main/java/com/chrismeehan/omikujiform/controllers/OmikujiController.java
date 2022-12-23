package com.chrismeehan.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	
	@GetMapping("")
	public String index() {
		return ("index.jsp");
	}
	
	
	@PostMapping("/complete")
	public String form(
			@RequestParam (value = "number") Integer number,
			@RequestParam (value = "city") String city,
			@RequestParam (value = "person") String person,
			@RequestParam (value = "hobby") String hobby,
			@RequestParam (value = "living") String living,
			@RequestParam (value = "compliment") String compliment,
			HttpSession session) {
			String quote = String.format("In %s years, you will live in %s with %s as your roomate, %s for a living. The next time you see %s, you will have good luck. Also, %s.", number, city, person, hobby, living, compliment);
			session.setAttribute("quote", quote);
			return "redirect:/omikuji/show";
	}
	
	@GetMapping("/show")
	public String show(HttpSession session, Model model) {
		String results = (String) session.getAttribute("quote");
		model.addAttribute("results", results);
		return "show.jsp";
	}
	

}
