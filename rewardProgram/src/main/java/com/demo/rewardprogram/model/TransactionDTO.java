package com.demo.rewardprogram.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TransactionDTO {

	private static final BigDecimal ONE_POINT_MARK = new BigDecimal("50");
	private static final BigDecimal TWO_POINT_MARK = new BigDecimal("100");

	private BigDecimal amount;

	@JsonIgnore
	private CustomerDTO customer;

	private Long id;

	private LocalDateTime purchaseDate;

	public TransactionDTO() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionDTO other = (TransactionDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public BigDecimal getRewardPoint() {
		if (amount.compareTo(TWO_POINT_MARK) > 0) {
			BigDecimal twoPoints = amount.subtract(TWO_POINT_MARK).multiply(new BigDecimal("2"));
			return ONE_POINT_MARK.add(twoPoints);
		} else {
			if (amount.compareTo(ONE_POINT_MARK) > 0) {
				return amount.subtract(ONE_POINT_MARK);
			} else {
				return new BigDecimal("0");
			}
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
