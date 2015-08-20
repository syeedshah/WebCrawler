package org.sainsbury.com;

public class Product {
	String title;
	String description;
	double price;
	String size;

	public Product() {
		super();
		this.price = 0.00;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title.replaceAll("[^a-zA-Z0-9 ]","");
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description.replaceAll("[^a-zA-Z0-9 ]","");
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
