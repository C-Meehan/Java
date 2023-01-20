package com.chrismeehan.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrismeehan.bookclub.models.Book;
import com.chrismeehan.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	// returns all books
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	// create a book
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	// get one book
	public Book getBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}
	
	//update a book
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}
	
	// delete a book
	public Book deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			bookRepo.deleteById(id);
		}
		return null;
	}
}
