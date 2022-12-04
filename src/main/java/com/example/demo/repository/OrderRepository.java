package com.example.demo.repository;

import com.example.demo.domain.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<UserOrder,Long> {

}
