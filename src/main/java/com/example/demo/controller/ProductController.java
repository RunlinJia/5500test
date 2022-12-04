package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "product")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<Product> getAll() {
		return productService.getAll();
	}

	@GetMapping(path = "{id}")
	public Optional<Product> get(@PathVariable("id") Long id) {
		return productService.get(id);
	}

	@PostMapping
	public void add(@RequestBody Product product) {
		productService.add(product);
	}

	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable("id") Long id) {
		productService.delete(id);
	}

	@PutMapping(path = "{id}")
	public void update(
		@PathVariable("id") Long id,
		@RequestParam(required = false) String name,
		@RequestParam(required = false) Integer quantity,
		@RequestParam(required = false) Float price) {
		productService.update(id, name, quantity, price);
	}
}

