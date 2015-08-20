package org.sainsbury.com;

/**
 * A Console Application to Scrape a WebPage and return json result of products
 *
 */

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class Console {
	static final String URL = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";

	public static void main(String[] args) {

		// instantiate objects
		WebCrawler webCrawler = new WebCrawler();
		JsonParser jsonParser = new JsonParser();

		// fetch a list of products
		ProductList products;
		products = webCrawler.getProductInformation(URL);

		// parse product string to json and output to console
		jsonParser.print(products);

	}

}