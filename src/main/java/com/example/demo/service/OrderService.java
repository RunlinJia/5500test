package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.domain.UserOrder;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	private OrderRepository orderRepository;
	@Autowired
	private CreditCardService creditCardService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<UserOrder> getAll() {
		return orderRepository.findAll();
	}

	public Optional<UserOrder> get(Long id) {
		return orderRepository.findById(id);
	}

	@Transactional(rollbackOn = Exception.class)
	public void add(UserOrder userOrder) {
		orderRepository.save(userOrder);
		creditCardService.updateBalance(userOrder.getCreditCardId(), userOrder.getTotalPrice());
		Optional<Product> exists = productRepository.findProductByName(userOrder.getProductName());
		if (exists.isPresent()) {
			Product product = exists.get();
			Integer newQuantity = product.getQuantity()-userOrder.getQuantity();
			if (newQuantity < 0) {
				throw new IllegalStateException("not enough quantity in product " + product.getName());
			}
			productService.update(
				product.getId(),
				null,
				newQuantity,
				null);
		}
	}

	public void test1() {
		int a = 1;
		int b = 2;
	}

	@Transactional(rollbackOn = Exception.class)
	public void cancel(Long id) {
		UserOrder userOrder = orderRepository.findById(id)
			.orElseThrow( () -> new IllegalStateException(
				"Order with id " + id + " does not exist"
			));
		if (!userOrder.getStatus().equals("completed")) {
			throw new IllegalStateException("Order with id " + id + " cannot be canceled");
		}
		creditCardService.updateBalance(userOrder.getCreditCardId(), -userOrder.getTotalPrice());
		userOrder.setStatus("canceled");
		orderRepository.save(userOrder);

		Optional<Product> exists = productRepository.findProductByName(userOrder.getProductName());
		if (exists.isPresent()) {
			Product product = exists.get();
			Integer newQuantity = product.getQuantity()+userOrder.getQuantity();
			productService.update(
				product.getId(),
				null,
				newQuantity,
				null);
		}
	}

	public void delete(Long id) {
		boolean exists = orderRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("Order with id " + id + " does not exists");
		}
		orderRepository.deleteById(id);
	}


//	public void updateOrder(Long id, String status) {
//		Order order = orderRepository.findById(id)
//			.orElseThrow( () -> new IllegalStateException(
//				"Order with id " + id + " does not exist"
//			));
//		boolean isStatusValid = status != null &&
//			(status.equals("completed") ||
//			status.equals("canceled"));
//
//		if (!isStatusValid) {
//			throw new IllegalStateException("Status " + status + " does not exists");
//		}
//		order.setStatus(status);
//
//	}
}
