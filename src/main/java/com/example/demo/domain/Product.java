package com.example.demo.domain;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class Product {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", unique = true)
	@NotNull
	private String name;

	@Column(name = "quantity")
	@NotNull
	private Integer quantity;

	@Column(name = "price")
	@NotNull
	private Float price;

	public Product(String name, Integer quantity, Float price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
}
