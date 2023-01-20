package com.chrismeehan.bookbrokers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chrismeehan.bookbrokers.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();
}