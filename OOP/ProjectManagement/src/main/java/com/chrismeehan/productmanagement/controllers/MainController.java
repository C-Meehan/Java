package com.chrismeehan.productmanagement.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chrismeehan.productmanagement.services.ProjectService;
import com.chrismeehan.productmanagement.services.TaskService;
import com.chrismeehan.productmanagement.services.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userServ;
	@Autowired
	ProjectService projectServ;
	@Autowired
	TaskService taskServ;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		model.addAttribute("projects", projectServ.allProjects());
		model.addAttribute("user", userServ.getById(userId));
		return "dashboard.jsp";
	}
}
