package com.example.demo.service;

import com.example.demo.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private User user1;
    @BeforeEach
    public void setUp() {
        user1 = new User("john","123456","john@gmail.com");
    }

    @Test
    public void test1() {
        User user2= new User();
        user2.setUsername("john2");
        assertEquals("john2", user2.getUsername());
    }
}