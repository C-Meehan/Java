package com.chrismeehan.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chrismeehan.bookclub.models.LoginUser;
import com.chrismeehan.bookclub.models.User;
import com.chrismeehan.bookclub.services.BookService;
import com.chrismeehan.bookclub.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private BookService bookServ;
	
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
		return "redirect:/books";
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
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String home(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.getById(userId));
		model.addAttribute("books", bookServ.allBooks());
		return "books.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}
}
