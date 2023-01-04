package com.chrismeehan.ninjagoldgame.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("ninja") == null) {
			session.setAttribute("ninja", new Ninja());
		}
		return "index.jsp";
	}
	
	@PostMapping("/farm")
	public String farm() {	
		return "redirect:/";
	}
	
	@PostMapping("/cave")
	public String cave() {	
		return "redirect:/";
	}
	
	@PostMapping("/house")
	public String house() {	
		return "redirect:/";
	}
	
	@PostMapping("/quest")
	public String quest() {	
		return "redirect:/";
	}
	
}
