package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;

public interface BookService {
	
	Book getById(int id);

	List<Book> getAll();
	
	List<Book> findByTitle(String title);
	
	List<Book> findByAuthor(String author);

	Book create(Book book);

	Book update(int id, String title, String author, String genre, Integer pages, String releaseYear);

	void delete(int id);


}
