package com.example.demo.entity;

//import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Book;

import nl.jqno.equalsverifier.EqualsVerifier;


public class BookIntegrationTest {
	 @Test
	    public void testEquals() {
	        EqualsVerifier.simple().forClass(Book.class).verify();
	    }
}
