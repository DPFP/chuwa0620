package com.demo.rewardprogram.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TransactionData {

	private BigDecimal amount;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Id
	@GeneratedValue
	private Long id;

	private LocalDateTime purchaseDate;

	public TransactionData() {
		super();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
