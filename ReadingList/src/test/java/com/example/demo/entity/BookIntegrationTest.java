package com.example.demo.entity;

import org.junit.jupiter.api.Test;



import nl.jqno.equalsverifier.EqualsVerifier;


public class BookIntegrationTest {
	 @Test
	    public void testEquals() {
	        EqualsVerifier.simple().forClass(Book.class).verify();
	    }
}
