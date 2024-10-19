package com.graphql.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.inventorymanagement.entity.Product;

import com.graphql.inventorymanagement.entity.ProductInput;import com.graphql.inventorymanagement.entity.ProductInput;
import com.graphql.inventorymanagement.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@QueryMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@QueryMapping
	public List<Product> getProductsByCategory(@Argument String category) {
		return productService.getProductsByCategory(category);

	}
	
	@MutationMapping
	public Product updateStock(@Argument int id, @Argument int quantity)
	{
		return productService.updateStock(id, quantity);
	}
	
	@MutationMapping
	public Product addShipment(@Argument int id, @Argument int quantity )
	{
		return productService.addNewShipment(id, quantity);
	}
	
	@MutationMapping
	public Product addNewProduct(@Argument ProductInput product)
	{
		return productService.addNewProduct(product);
	}

}
