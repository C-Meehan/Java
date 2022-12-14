package com.chrismeehan.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello") creates a default route so the "/" route would actually be just "" and the new_route would now be /hello/new_route
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/new_route")
	public String newRoute() {
		return "Yayy you did it";
	}
}
