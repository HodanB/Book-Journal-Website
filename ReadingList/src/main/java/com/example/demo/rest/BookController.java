package com.example.demo.rest;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@CrossOrigin
@RestController
public class BookController {

	

	@Autowired
	private BookService service; // dependency



	
//		to find a book from the reading list using ID
		@GetMapping("/getBook/{id}")
		public Book getById(@PathVariable int id) {
			return this.service.getById(id);
		}
//		to find a book from the reading list using TITLE
		@GetMapping("/getBookByTitle/{title}")
		public Book getByTitle(@PathVariable String title) {
			return this.service.findByTitle(title);
		}
//		to find a book from the reading list using AUTHOR
		@GetMapping("/getBookByAuthor/{author}")
		public Book getByAuthor(@PathVariable String author) {
			return this.service.findByAuthor(author);
		}
		
//		to find all books from the reading list
		@GetMapping("/getBooks")
		public List<Book> getAll() {
			return this.service.getAll();
		}
		
//		to create a book for the reading list
		@PostMapping("/createBook")
		public ResponseEntity<Book> create(@RequestBody Book book) {
			System.out.println("Created: " + book);
			Book created = this.service.create(book);

			return new ResponseEntity<Book>(created, HttpStatus.CREATED);
		}
		
//		to update a book from the reading list
		@PatchMapping("/updateBook/{id}")
		public Book update(@PathVariable("id") int id, @PathParam("title") String title,
				@PathParam("author") String author, @PathParam("genre") String genre, 
				@PathParam("pages") Integer pages, @PathParam("releaseYear") String releaseYear) {
			return this.service.update(id, title, author, genre, pages, releaseYear);
		}
//		to delete a book from the reading list
			@DeleteMapping("/removeBook/{id}")
			public ResponseEntity<?> delete(@PathVariable int id) {
				this.service.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
	}