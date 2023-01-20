package com.chrismeehan.productmanagement.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chrismeehan.productmanagement.models.LoginUser;
import com.chrismeehan.productmanagement.models.User;
import com.chrismeehan.productmanagement.services.ProjectService;
import com.chrismeehan.productmanagement.services.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userServ;
	
	@Autowired
	ProjectService projectServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user,
			BindingResult result, Model model, HttpSession session) {
		userServ.register(user, result);
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		User createdUser = userServ.create(user);
		session.setAttribute("userId", createdUser.getId());
		return "redirect:/dashboard";
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
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}
}
