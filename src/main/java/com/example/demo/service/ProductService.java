package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.enums.Status;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAll() {
		return productRepository.findAll();
	}

	public Optional<Product> get(Long id) {
		return productRepository.findById(id);
	}

	public void add(Product product) {
		productRepository.save(product);
	}

	public void delete(Long id) {
		boolean exists = productRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("Product with id " + id + " does not exists");
		}
		productRepository.deleteById(id);
	}

	@Transactional(rollbackOn = Exception.class)
	public void update(Long id, String name, Integer quantity, Float price) {
		Product product = productRepository.findById(id)
			.orElseThrow( () -> new IllegalStateException(
				"Product with id " + id + " does not exist"
				));
		if (name != null) {
			product.setName(name);
		}
		if (quantity != null) {
			product.setQuantity(quantity);
		}
		if (price != null) {
			product.setPrice(price);
		}
	}

}
