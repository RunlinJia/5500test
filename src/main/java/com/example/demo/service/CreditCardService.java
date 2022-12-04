package com.example.demo.service;

import com.example.demo.domain.CreditCard;
import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.repository.CreditCardRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
	private CreditCardRepository creditCardRepository;

	@Autowired
	public CreditCardService(CreditCardRepository creditCardRepository) {
		this.creditCardRepository = creditCardRepository;
	}

	public List<CreditCard> getAll() {
		return creditCardRepository.findAll();
	}

	public Optional<CreditCard> get(Long id) {
		return creditCardRepository.findById(id);
	}

	public void add(CreditCard creditCard) {
		creditCardRepository.save(creditCard);
	}

	public void delete(Long id) {
		boolean exists = creditCardRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("Credit card with id " + id + " does not exists");
		}
		creditCardRepository.deleteById(id);
	}

	@Transactional(rollbackOn = Exception.class)
	public void update(
		Long id,
		String number,
		String validThru,
		String name,
		String csv,
		String billAddress,
		Float balance) {
		CreditCard creditCard = creditCardRepository.findById(id)
			.orElseThrow( () -> new IllegalStateException(
				"CreditCard with id " + id + " does not exist"
			));
		if (number != null) {
			creditCard.setNumber(number);
		}
		if (validThru != null) {
			creditCard.setValidThru(validThru);
		}
		if (name != null) {
			creditCard.setName(name);
		}
		if (csv != null) {
			creditCard.setCsv(csv);
		}
		if (billAddress != null) {
			creditCard.setBillAddress(billAddress);
		}
		if (balance != null) {
			creditCard.setBalance(balance);
		}
		creditCardRepository.save(creditCard);
	}

	public void updateBalance(Long id, Float totalPrice) {
		CreditCard creditCard = creditCardRepository.findById(id)
			.orElseThrow( () -> new IllegalStateException(
				"CreditCard with id " + id + " does not exist"
			));
		Float newBalance = creditCard.getBalance()-totalPrice;
		if (newBalance < 0) {
			throw new IllegalStateException("Not enough balance");
		}
		update(id, null, null, null, null,null, newBalance);
	}
}
