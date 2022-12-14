package com.chrismeehan.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String searchQuery,@RequestParam(value="last_name", required=false) String searchQuery2,@RequestParam(value="times", required=false) String searchQuery3) {
		String greeting = "";
		if (searchQuery == null) {
			return ("Hello Human");
		}
		else {
			int times = Integer.parseInt(searchQuery3);
			for (int i = 0; i < times; i++) {
//				System.out.printf("Hello " + searchQuery + " " + searchQuery2 + " ");
				greeting += String.format("Hello %s %s <br>", searchQuery, searchQuery2);
			}
			return greeting;
		}
	}
}
