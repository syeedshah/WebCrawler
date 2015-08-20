package org.sainsbury.com;

import java.util.ArrayList;

public class ProductList {
	private ArrayList<Product> products;

	public ProductList() {
		super();
		products = new ArrayList<Product>();
	}

	public void add(Product product) {
		this.products.add(product);

	}

	public void remove(Product product) {
		this.products.remove(product);
	}
	
	public double getTotalPrice(Product product){
		for(Product price : products){
			
		}
		return 0;
	}
	
	public ArrayList<Product> toArrayList(){
		return products;
		
	}
	
	public int size(){
		return products.size();
	}

}
