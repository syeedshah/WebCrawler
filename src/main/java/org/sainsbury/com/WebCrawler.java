package org.sainsbury.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class WebCrawler {
	public static List<String> listOfProductLinks = new ArrayList<String>();
	//public static ArrayList<Product> listOfProductInformation = new ArrayList<Product>();
	private ProductList productList = new ProductList();
	public static double totalUnitPrice = 0.00;
	public static double unitPrice = 0.00;
	public static String pricePerUnit = "";

	public ProductList getProductInformation(String url) {
		// get list of all product urls
		getProductUrls(url);
		Document productPage;

		for (String linktocrawl : listOfProductLinks) {
			Product product = new Product();

			try {
				productPage = Jsoup.connect(linktocrawl).userAgent("Mozilla")
						.get();
				// get page title
				String title = productPage.select(
						".productTitleDescriptionContainer h1").text();
				product.setTitle(title);
				String description = productPage.select(".productText p")
						.first().text();
				product.setDescription(description);
				pricePerUnit = productPage.select(".priceperunit").first()
						.text().substring(1, 5);// strip /unit
				unitPrice = Double.parseDouble(pricePerUnit);
				product.setPrice(unitPrice);

				// TODO
				// get size of page
				String convertThisToPageSize = productPage.select("body")
						.text();
				String size = calculatePageSize(convertThisToPageSize);
				product.setSize(size);

				productList.add(product);

				// convert our set of ProductInformation to Json output
				// convertStringToJson(listOfProductInformation);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		

		return productList;

	}

	public String calculatePageSize(String convertThisToPageSize) {
		String size =  convertThisToPageSize.getBytes().length + " kb";
		return size;
	}


	public void getProductUrls(String url) {
		Document mainPageOfProductLinks;

		try {
			// need http protocol
			mainPageOfProductLinks = Jsoup.connect(url).userAgent("Mozilla")
					.get();

			// get all links
			Elements links = mainPageOfProductLinks.select("a[href]");

			for (Element link : links) {

				// get the value from href attribute for products only
				// add to list ready for scraping
				if (link.attr("href").contains("/ripe---ready/")) {
					listOfProductLinks.add(link.attr("href"));
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
