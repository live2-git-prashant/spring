package com.live.repository;

import java.util.ArrayList;
import java.util.List;

import com.live.model.Product;

public class MySqlRepository implements ProductRepository {

	@Override
	public List<Product> getProducts() {
		System.out.println("MySQL Repository");
		List<Product> products = new ArrayList<>();

		Product product = new Product();

		product.setProductId("P11");
		product.setProductName("MySQl");

		products.add(product);

		return products;
	}

}