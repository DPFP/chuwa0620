package com.demo.rewardprogram.model;

import java.math.BigDecimal;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rewards {

	private CustomerDTO customer;

	private Map<Month, List<TransactionDTO>> monthlyTrans = new HashMap<>();

	public Rewards() {
		super();
	}
	public Rewards(CustomerDTO customer) {
		super();
		this.customer = customer;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public Map<Month, BigDecimal> getMonthlyTotalRewardPoint() {
		Map<Month, BigDecimal> monthlyRewardPoint = new HashMap<>();
		monthlyTrans.forEach((m, transRecords) -> {
			BigDecimal totalPoint = new BigDecimal("0");
			for (TransactionDTO tr : transRecords) {
				totalPoint = totalPoint.add(tr.getRewardPoint());
			}
			monthlyRewardPoint.put(m, totalPoint);

		});
		return monthlyRewardPoint;
	}

	public Map<Month, List<TransactionDTO>> getMonthlyTrans() {
		return monthlyTrans;
	}

}
