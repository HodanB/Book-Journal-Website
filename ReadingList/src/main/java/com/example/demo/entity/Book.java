package com.example.demo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //How to Make Table
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AI
	private Integer id;
	
//	@Column(name = "bookTitle", nullable =  false, unique = true)
	private String title;
	private String author;
	private String genre;
	private int pages;
	private String releaseYear; 
	
	public Book() {
		super();

	}

	public Book(String title, String author, String genre, int pages, String releaseYear) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.pages = pages;
		this.releaseYear = releaseYear;
	}

	public Book(Integer id,String title, String author, String genre, int pages, String releaseYear) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.pages = pages;
		this.releaseYear = releaseYear;
		
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}


//	@Override
//	public int hashCode() {
//		return Objects.hash(author, genre, id, pages, releaseYear, title);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Book other = (Book) obj;
//		return Objects.equals(author, other.author) && Objects.equals(genre, other.genre)
//				&& Objects.equals(id, other.id) && pages == other.pages
//				&& Objects.equals(releaseYear, other.releaseYear) && Objects.equals(title, other.title);
//	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", pages=" + pages
				+ ", releaseYear=" + releaseYear + "]";
	}

}
