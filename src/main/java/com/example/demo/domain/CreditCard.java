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
public class CreditCard {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "number", unique = true)
	@NotNull
	private String number;

	@Column(name = "valid_thru", unique = true)
	@NotNull
	private String validThru;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "csv")
	@NotNull
	private String csv;

	@Column(name = "bill_address")
	@NotNull
	private String billAddress;

	@Column(name = "balance")
	@NotNull
	private Float balance;

	public CreditCard(String number, String validThru, String name, String csv, String billAddress,
		Float balance) {
		this.number = number;
		this.validThru = validThru;
		this.name = name;
		this.csv = csv;
		this.billAddress = billAddress;
		this.balance = balance;
	}
}


