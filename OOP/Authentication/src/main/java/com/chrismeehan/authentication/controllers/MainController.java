package com.chrismeehan.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chrismeehan.authentication.models.LoginUser;
import com.chrismeehan.authentication.models.User;
import com.chrismeehan.authentication.services.UserService;

//.. don't forget to include all your imports! ..

@Controller
public class MainController {
 
 // Add once service is implemented:
  @Autowired
  private UserService userServ;
 
	 @GetMapping("/")
	 public String index(Model model) {
	 
	     // Bind empty User and LoginUser objects to the JSP
	     // to capture the form input
	     model.addAttribute("user", new User());
	     model.addAttribute("loginUser", new LoginUser());
	     return "index.jsp";
	 }
	 
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("user") User user, 
	         BindingResult result, Model model, HttpSession session) {
	     userServ.register(user, result);
	     if(result.hasErrors()) {
	         model.addAttribute("loginUser", new LoginUser());
	         return "index.jsp";
	     }
	     User createdUser = userServ.create(user);
	     session.setAttribute("userId", createdUser.getId());
	     return "redirect:/home";
	 }
	 
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, 
	         BindingResult result, Model model, HttpSession session) {
	     User loggedUser = userServ.login(loginUser, result);
	     if (loggedUser == null) {
	    	 model.addAttribute("user", new User());
	    	 return "index.jsp";
	     }
	     session.setAttribute("userId", loggedUser.getId());
	     return "redirect:/home";
	 }
	 
	 @GetMapping("/home")
	 public String home(Model model, HttpSession session) {
		 Long userId = (Long) session.getAttribute("userId");
		 model.addAttribute("user", userServ.getById(userId));
		 return "home.jsp";
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.removeAttribute("userId");
		 return "redirect:/";
	 }
 
}

