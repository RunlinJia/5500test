package com.example.demo.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", unique = true)
    @NotNull
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @Column(name = "balance")
    private Float balance;

//    @Column(name = "credit_card_id")
//    private Long creditCardId; // todo

    public User(String username, String password, String email, Float balance) {
    }

    public User(String username, String password, String email) {
    }

}
