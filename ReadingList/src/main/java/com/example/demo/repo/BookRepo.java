package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

	List<Book> findByTitleStartingWithIgnoreCase(String title);
	List<Book> findByAuthorStartingWithIgnoreCase(String author);
}