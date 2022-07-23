package com.example.demo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.demo.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the testing class
@Sql(scripts = { "classpath:books-schema.sql",
		"classpath:books-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class BookControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Book testBook = new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling", "Fantasy", 636, "2000");
		String testBookAsJSON = this.mapper.writeValueAsString(testBook);
		RequestBuilder req = post("/createBook").content(testBookAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().is(201);
		Book createdBook = new Book(2, "Harry Potter and the Goblet of Fire", "J. K. Rowling", "Fantasy", 636, "2000");
		String createdBookAsJSON = this.mapper.writeValueAsString(createdBook);
		ResultMatcher checkBody = content().json(createdBookAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testRead() throws Exception {
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "Cookie", "Jacqueline_Wilson", "Children", 320, "2008"));
		this.mvc.perform(get("/getBooks")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(books)));
	
	}

	@Test
	void testReadByTitle() throws Exception {
		List<Book> testBookTitle =  new ArrayList<Book>();
		testBookTitle.add(new Book (1, "Cookie", "Jacqueline_Wilson", "Children", 320, "2008"));
			this.mvc.perform(get("/getBookByTitle/Cookie")).andExpect(status().isOk())
			.andExpect(content().json(this.mapper.writeValueAsString(testBookTitle)));
		}


	@Test
	void testReadById() throws Exception {
		Book books = new Book(1, "Cookie", "Jacqueline_Wilson", "Children", 320, "2008");
		this.mvc.perform(get("/getBook/1")).andExpect(status().isOk())
			.andExpect(content().json(this.mapper.writeValueAsString(books)));
	}
	@Test
	void testReadByAuthor() throws Exception {
		List<Book> testBookAuthor =  new ArrayList<Book>();
		testBookAuthor.add(new Book(1, "Cookie", "Jacqueline_Wilson", "Children", 320, "2008"));
		this.mvc.perform(get("/getBookByAuthor/Jacqueline_Wilson")).andExpect(status().isOk())
			.andExpect(content().json(this.mapper.writeValueAsString(testBookAuthor)));
	}

	@Test
	void testUpdate() throws Exception {
		Book updated = new Book(1, "Cookie", "Jacqueline_Wilson", "Horror", 320, "2008");
		this.mvc.perform(patch("/updateBook/1?title=Cookie&author=Jacqueline_Wilson&genre=Horror&pages=320&releaseYear=2008")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeBook/1")).andExpect(status().isNoContent());
	}
	
}