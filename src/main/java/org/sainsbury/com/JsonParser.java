package org.sainsbury.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParser {

	public void print(ProductList products) {

		Map output = new HashMap();
		output.put("results", products.toArrayList());
		output.put("total", products.getTotalPrice());
		

		//
		// convert to json and prettyprint for output
		//
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(output));

	}

}
