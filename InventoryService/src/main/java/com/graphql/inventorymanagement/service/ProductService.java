package com.graphql.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.inventorymanagement.entity.Product;
import com.graphql.inventorymanagement.entity.ProductInput;
import com.graphql.inventorymanagement.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductByCategory(category);
	}
	
	public Product updateStock(int id,int quantity)
	{
		Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found with id"+id));
		product.setStock(quantity);
		return productRepository.save(product);

	}
	
	public Product addNewShipment(int id, int quantity)
	{
		Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found with id"+id));
		product.setStock(quantity+product.getStock());
		return productRepository.save(product);
	}
	
	public Product addNewProduct(ProductInput productInput)
	{
		Product product = new Product(productInput.name(),productInput.category(),productInput.price(),productInput.stock());
		return productRepository.save(product);
	}

}
