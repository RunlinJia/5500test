package com.example.demo.repository;

import com.example.demo.domain.Product;
import com.example.demo.student.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Long> {
	@Query("SELECT p from Product p WHERE p.name = ?1")
	Optional<Product> findProductByName(String name);
}
