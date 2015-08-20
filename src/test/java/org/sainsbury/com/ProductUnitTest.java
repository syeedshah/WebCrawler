package org.sainsbury.com;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.sainsbury.com.Product;

/**
 * Unit test for simple App.
 */
public class ProductUnitTest {
	
	
	@Before
    public void setUp() {
		
	
    }

	@Test
	public void testCreation() {	
		Product product = new Product();
		assertNull(product.getTitle());
		assertNull(product.getDescription());
		assertNull(product.getSize());
		assertTrue(0.00 == product.getPrice());
	}
	
	@Test
	public void testSetTitle() {	
		Product product = new Product();
		product.setTitle("title");
		assertEquals("title", product.getTitle());
	}
	
	@Test
	public void testSetDescription() {	
		Product product = new Product();
		product.setDescription("description");
		assertEquals("description", product.getDescription());
	}
	
	@Test
	public void testSetSize() {	
		Product product = new Product();
		product.setSize("300 kb");
		assertEquals("300 kb", product.getSize());
	}
	
	@Test
	public void testSetPrice() {	
		Product product = new Product();
		product.setPrice(1.50);
		assertTrue(1.50 == product.getPrice());
	}
	
	
	
}
