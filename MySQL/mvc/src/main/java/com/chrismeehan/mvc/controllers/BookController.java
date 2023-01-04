package com.chrismeehan.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chrismeehan.mvc.models.Book;
import com.chrismeehan.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
//	@GetMapping("/books/{bookId}")
//	public String index(Model model, @PathVariable("bookId") Long bookId) {
//		System.out.println(bookId);
//		Book book = bookService.findBook(bookId);
//		System.out.println(book);
//		
//		ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
//		
//		model.addAttribute("book", book);
//		model.addAttribute("books", books);
//		
//		return "index.jsp";
//	}
	
	@GetMapping("/books/{bookId}")
	public String show(Model model, @PathVariable("bookId") Long bookId) {
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	// Note: We'll be altering this a bit after we introduce data binding.
//	@PostMapping("/books")
//	public String create(
//	    @RequestParam("title") String title,
//	    @RequestParam("description") String description,
//	    @RequestParam("language") String language,
//	    @RequestParam("pages") Integer pages) 
//	{
//	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
//	    Book book = new Book(title, description, language, pages);
//	    bookService.createBook(book);
//	    return "redirect:/books";
//	}
	//NEW DATA BINDING WAY BELOW
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		bookService.createBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}


}
