package com.chrismeehan.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {

		@RequestMapping("")
		public String index() {
			return "Welcome!";
		}
		
		@RequestMapping("/today")
		public String today() {
			return "Today you will find luck in all your endeavors!";
		}
		
		@RequestMapping("/tomorrow")
		public String future() {
			return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
		}
		
		@RequestMapping("/travel/{city}")
		public String vacation(@PathVariable("city") String city) {
			return "Congratulations! You will soon travel to " + city;
		}
		
		@RequestMapping("/lotto/{num}")
		public String fortune(@PathVariable("num") String num) {
			int number = Integer.parseInt(num);
			if (number % 2 == 0) {
				return String.format("You will take a grand journey in the near future, but be weary of tempting offers.");		
			}
			else {
				return String.format("You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.");
			}
		}
}
