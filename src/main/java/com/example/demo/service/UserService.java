package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public Optional<User> get(Long id) {
		return userRepository.findById(id);
	}

	public void add(User user) {
		userRepository.save(user);
	}

	public void delete(Long id) {
		boolean exists = userRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("User with id " + id + " does not exists");
		}
		userRepository.deleteById(id);
	}

	@Transactional(rollbackOn = Exception.class)
	public void update(Long id, String username, String password, String email, Float balance) {

		User user = userRepository.findById(id)
			.orElseThrow(() -> new IllegalStateException(
				"user with id " + id + " does not exist"
			));

//		if (!user.getPassword().equals(password)) {
//			throw new IllegalStateException(
//				"username does not match password"
//			);
//		}
		if (username != null) {
			user.setUsername(username);
		}

		if (password != null) {
			user.setPassword(password);
		}

		if (email != null) {
			user.setEmail(email);
		}

		if (balance != null) {
			user.setBalance(balance);
		}

	}

}
