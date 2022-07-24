package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;

@Service
@Primary
public class BookServiceDB implements BookService {
	
	@Autowired
	private BookRepo repo; 

	@Override
	public Book getById(int id) {
		
		return this.repo.findById(id).get();
	}

	@Override
	public List<Book> getAll() {

		return this.repo.findAll();
	}

	@Override
	public Book create(Book book) {
	
		return this.repo.save(book);
	}

	@Override
	public Book update(int id, String title, String author, String genre, Integer pages, String releaseYear) {
		
		Book toUpdate = this.getById(id);
		if (title != null)
			toUpdate.setTitle(title);
		if (author != null)
			toUpdate.setAuthor(author);
		if (genre != null)
			toUpdate.setGenre(genre);
		if (pages != null)
			toUpdate.setPages(pages);
		if (releaseYear != null)
			toUpdate.setReleaseYear(releaseYear);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);

	}

	@Override
	public List<Book> findByTitle(String title) {
		
		return this.repo.findByTitleStartingWithIgnoreCase(title);
	}

	@Override
	public List<Book> findByAuthor(String author) {
	
		return this.repo.findByAuthorStartingWithIgnoreCase(author);
	}
}