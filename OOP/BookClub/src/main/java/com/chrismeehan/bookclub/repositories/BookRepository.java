package com.chrismeehan.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chrismeehan.bookclub.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();
}
