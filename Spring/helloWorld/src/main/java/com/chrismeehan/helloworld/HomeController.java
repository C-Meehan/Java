package com.chrismeehan.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/hello") creates a default route so the "/" route would actually be just "" and the new_route would now be /hello/new_route
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("fruit", "banana");
		return "demo.jsp";
	}
	
	@RequestMapping("/new_route")
	public String newRoute() {
		return "Yayy you did it";
	}
}
