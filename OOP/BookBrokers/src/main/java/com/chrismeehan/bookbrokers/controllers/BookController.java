package com.chrismeehan.bookbrokers.controllers;

import javax.servlet.http.HttpSession;
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

import com.chrismeehan.bookbrokers.models.Book;
import com.chrismeehan.bookbrokers.services.BookService;
import com.chrismeehan.bookbrokers.services.UserService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookServ;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book") Book book, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		return "newBook.jsp";
	}
	
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			return "newBook.jsp";
		}
		bookServ.createBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/add/borrower/{id}")
	public String updateBookStatus(@PathVariable("id") Long id, Model model, HttpSession session) {
	  Long userId = (Long) session.getAttribute("userId");
	     if (userId == null) {
	         return "redirect:/";
	     }
	 Book oneBook = bookServ.getBook(id);
	 oneBook.setBorrower(userServ.getById((userId)));
	 bookServ.updateBook(oneBook);
	 return "redirect:/books";
	}
	
	@GetMapping("/return/borrower/{id}")
	public String returnBorrow(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		Book oneBook = bookServ.getBook(id);
		oneBook.setBorrower(null);
		bookServ.updateBook(oneBook);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		model.addAttribute("book", bookServ.getBook(id));
		return "show.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		Book bookid = bookServ.getBook(id);
		if (bookid != null && !bookid.getUser().getId().equals(userId)) {
			return "redirect:/books";
		}
//		if (!userId.)
//		if (!userId.equals(bookid).getUser().getId()) {
//			return "redirect:/books";
//		}
		model.addAttribute("book", bookServ.getBook(id));
		return "edit.jsp";
	}
	
	@PutMapping("/books/{id}/edit")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, @PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			return "edit.jsp";
		}
		Book books = bookServ.getBook(id);
		if (!userId.equals(books.getUser().getId())) {
			return "redirect:/books/{id}";
		}
		bookServ.updateBook(book);
		return "redirect:/books/{id}";
	}
	
	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		Book book = bookServ.getBook(id);
		if (!userId.equals(book.getUser().getId())) {
			return "redirect:/books/{id}";
		}
		bookServ.deleteBook(id);
		return "redirect:/books";
	}
}

