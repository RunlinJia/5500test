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
public class UserOrder {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_id", unique = true)
	@NotNull
	private Long userId;

	@Column(name = "product_name", unique = true)
	@NotNull
	private String productName;

	@Column(name = "quantity")
	@NotNull
	private Integer quantity;

	@Column(name = "price")
	@NotNull
	private Float price;

	@Column(name = "total_price")
	@NotNull
	private Float totalPrice;

	@Column(name = "credit_card_id")
	@NotNull
	private Long creditCardId;

	@Column(name = "status")
	@NotNull
	private String status;

	public UserOrder(Long userId,
		String productName, Integer quantity,
		Float price,
		Float totalPrice,
		Long creditCardId,
		String status) {
		this.userId = userId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.creditCardId = creditCardId;
		this.status = status;
	}
}

