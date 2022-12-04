package com.example.demo.controller;

import com.example.demo.domain.CreditCard;
import com.example.demo.service.CreditCardService;
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
@RequestMapping(path = "credit_card")
public class CreditCardController {

	private final CreditCardService creditCardService;

	@Autowired
	public CreditCardController(CreditCardService creditCardService) {
		this.creditCardService = creditCardService;
	}

	@GetMapping
	public List<CreditCard> getAll() {
		return creditCardService.getAll();
	}

	@GetMapping(path = "{id}")
	public Optional<CreditCard> get(@PathVariable("id") Long id) {
		return creditCardService.get(id);
	}

	@PostMapping
	public void add(@RequestBody CreditCard creditCard) {
		creditCardService.add(creditCard);
	}

	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable("id") Long id) {
		creditCardService.delete(id);
	}

	@PutMapping(path = "{id}")
	public void update(
		@PathVariable("id") Long id,
		@RequestParam(required = false) String number,
		@RequestParam(required = false) String validThru,
		@RequestParam(required = false) String name,
		@RequestParam(required = false) String csv,
		@RequestParam(required = false) String billAddress,
		@RequestParam(required = false) Float balance) {
		creditCardService.update(id, number, validThru, name, csv, billAddress, balance);
	}
}

