package com.chrismeehan.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.chrismeehan.savetravels.models.Expense;
import com.chrismeehan.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

		@Autowired
		ExpenseService expenseService;
		
		@GetMapping("/expenses")
		public String index(@ModelAttribute("expense") Expense expense, Model model) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		
		@PostMapping("/addExpense")
		public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
			if (result.hasErrors()) {
				return "index.jsp";
			}
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
		
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable("id") Long id,
				@ModelAttribute("expense") Expense expense, Model model) {
			model.addAttribute("expense", expenseService.findExpense(id));
			return "edit.jsp";
		}
		
		@PutMapping("/edit/{id}")
		public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result,
				@PathVariable("id") Long id, Model model) {
			if (result.hasErrors()) {
				model.addAttribute("expense", expense);
				return "edit.jsp";
			}
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
		
		@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			expenseService.deleteExpense(id);
			return "redirect:/expenses";
		}
		
		@GetMapping("/show/{id}")
		public String show(@PathVariable("id") Long id, @ModelAttribute("expense") Expense expense, Model model) {
			model.addAttribute("expense", expenseService.findExpense(id));
			return "show.jsp";
		}
}
