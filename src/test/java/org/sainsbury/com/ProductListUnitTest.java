package org.sainsbury.com;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.sainsbury.com.Product;
import org.sainsbury.com.ProductList;

public class ProductListUnitTest {

	@Before
    public void setUp() {
		
    }
	
	@Test
	public void testCreation() {	
		ProductList productList = new ProductList();
		 assertEquals(0, productList.size());
	}
	
	
	@Test
	public void testAddingProductToProductList() {	
		ProductList productList = new ProductList();
		Product product =  new Product();
		
		productList.add(product);
		assertEquals(1, productList.size());
		
	}
	
	@Test
	public void testRemovingProductFromProductList() {	
		ProductList productList = new ProductList();
		Product product =  new Product();
		
		productList.add(product);
		productList.remove(product);
		assertEquals(0, productList.size());
		
	}
	
	@Test
	public void testToArrayList(){
		ProductList productList = new ProductList();
		assertTrue(productList.toArrayList() instanceof ArrayList);
	}
	
	@Test
	public void testGetTotalPrice(){
		ProductList productList = new ProductList();
		Product product = new Product();
		assertTrue(0.00 == productList.getTotalPrice(product));
	}
	
	

}
