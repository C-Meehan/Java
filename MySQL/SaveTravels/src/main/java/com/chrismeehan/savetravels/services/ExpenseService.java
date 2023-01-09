package com.chrismeehan.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chrismeehan.savetravels.models.Expense;
import com.chrismeehan.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	// returns all expenses
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	// creates an expense
	public Expense createExpense(Expense e) {
		return expenseRepo.save(e);
	}
	
	// retrieves an expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		return null;
	}
	
	// updates an expense
	public Expense updateExpense(Expense e) {
		return expenseRepo.save(e);
	}
	
	// deletes an expense
	public Expense deleteExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			expenseRepo.deleteById(id); 
		}
		return null;
	}
}