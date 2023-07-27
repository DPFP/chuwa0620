package com.demo.rewardprogram.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.demo.rewardprogram.entity.Customer;
import com.demo.rewardprogram.entity.TransactionData;
import com.demo.rewardprogram.model.CustomerDTO;
import com.demo.rewardprogram.model.TransactionDTO;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {

	public Customer createCustomer(String custName) {
		Customer mary = new Customer();
		mary.setName(custName);
		return mary;
	}

	public TransactionData createTransactionRecord(Customer cust, String amount, int minusMonth, int minusDay) {
		TransactionData maryTran1 = new TransactionData();
		maryTran1.setCustomer(cust);

		maryTran1.setAmount(new BigDecimal(amount));

		LocalDateTime monthAgo = LocalDateTime.now().minusMonths(minusMonth).minusDays(minusDay);

		maryTran1.setPurchaseDate(monthAgo);
		return maryTran1;
	}

	public CustomerDTO createCustomerDTO(String custName) {
		CustomerDTO mary = new CustomerDTO();
		mary.setName(custName);
		mary.setId(1l);
		return mary;
	}

	public TransactionDTO createTransactionRecordDTO(CustomerDTO cust, String amount, int minusMonth, int minusDay) {
		TransactionDTO maryTran1 = new TransactionDTO();
		maryTran1.setCustomer(cust);
		maryTran1.setId(1l);

		maryTran1.setAmount(new BigDecimal(amount));


		LocalDateTime monthAgo = LocalDateTime.now().minusMonths(minusMonth).minusDays(minusDay);

		maryTran1.setPurchaseDate(monthAgo);
		return maryTran1;
	}


	
}
