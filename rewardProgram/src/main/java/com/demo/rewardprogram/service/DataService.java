package com.demo.rewardprogram.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.rewardprogram.entity.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.demo.rewardprogram.model.CustomerDTO;
import com.demo.rewardprogram.model.Rewards;
import com.demo.rewardprogram.model.TransactionDTO;

@Component
public class DataService {

	public CustomerDTO toCustomerModel(Customer custEnt) {
		CustomerDTO cust = new CustomerDTO();
		BeanUtils.copyProperties(custEnt, cust);

		return cust;
	}

	public Map<CustomerDTO, List<TransactionDTO>> retrieveCustomerTransactions(List<TransactionDTO> transRecords) {
		Map<CustomerDTO, List<TransactionDTO>> customerTrans = new HashMap<>();

		for (TransactionDTO tranRecord : transRecords) {
			if (!customerTrans.containsKey(tranRecord.getCustomer())) {
				customerTrans.put(tranRecord.getCustomer(), new ArrayList<TransactionDTO>());
			}
			customerTrans.get(tranRecord.getCustomer()).add(tranRecord);
		}

		return customerTrans;

	}
	
	public Rewards calculateMonthlyRewards(CustomerDTO cust, List<TransactionDTO> transRecords) {
		Rewards monthlyRewards = new Rewards(cust);
		for (TransactionDTO tranRecord : transRecords) {
			if (!monthlyRewards.getMonthlyTrans().containsKey(tranRecord.getPurchaseDate().getMonth())) {
				monthlyRewards.getMonthlyTrans().put(tranRecord.getPurchaseDate().getMonth(),
						new ArrayList<TransactionDTO>());
			}

			monthlyRewards.getMonthlyTrans().get(tranRecord.getPurchaseDate().getMonth()).add(tranRecord);
		}

		return monthlyRewards;

	}
}
