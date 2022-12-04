package com.example.demo.config;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository repository) {
//		return args -> {
//			User user = new User("admin", "admin", "admin@gmail.com");
//			repository.saveAll(
//				List.of(user)
//			);
//		};
//	}
}