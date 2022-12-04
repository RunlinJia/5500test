package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

//	@Bean
//	CommandLineRunner commandLineRunner(StudentRepository repository) {
//		return args -> {
//			Student Alex = new Student( "Alex", "a@gmail.com", LocalDate.of(2000, Month.JANUARY, 5));
//			Student Bob = new Student( "Bob", "b@gmail.com", LocalDate.of(1998, Month.MAY, 5));
//			repository.saveAll(
//				List.of(Alex, Bob)
//			);
//		};
//	}
}
