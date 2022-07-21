//package com.example.demo.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//
//import com.example.demo.entity.Book;
//
//
//@Service
//public class BookServiceList implements BookService {
//
//	private List<Book> books = new ArrayList<>();
//
//	@Override
//	public Book getById(int id) {
//		return this.books.get(id);
//
//	}
//
//	@Override
//	public List<Book> getAll() {
//		return this.books;
//	}
//
//	@Override
//	public Book create(Book book) {
//		this.books.add(book);
//		return this.books.get(this.books.size() - 1);
//
//	}
//
//	@Override
//	public Book update(int id, String title, String author, String genre, Integer pages, String releaseyear) {
//		
//		Book toUpdate = this.getById(id);
//		if (title != null)
//			toUpdate.setTitle(title);
//		if (author != null)
//			toUpdate.setAuthor(author);
//		if (genre != null)
//			toUpdate.setGenre(genre);
//		if (pages != 0)
//			toUpdate.setPages(pages);
//		if (releaseyear != null)
//			toUpdate.setReleaseYear(releaseyear);
//		return toUpdate;	
//	}
//
//	@Override
//	public void delete(int id) {
//		this.books.remove(id);
//	}
//
//	@Override
//	public Book findByTitle(String title) {
//		
//		return null;
//	}
//
//	@Override
//	public Book findByAuthor(String author) {
//		
//		return null;
//	}
//
//}