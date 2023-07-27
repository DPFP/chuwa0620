package com.demo.rewardprogram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.rewardprogram.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rewardprogram.model.CustomerDTO;
import com.demo.rewardprogram.model.Rewards;
import com.demo.rewardprogram.model.TransactionDTO;
import com.demo.rewardprogram.service.DataService;


@RestController
@RequestMapping("/api/v1")
public class RewardPointController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DataService dataService;

	@GetMapping("rewards/customer/{customerId}")
	public Rewards rewardsByCustomer(@PathVariable(value = "customerId") Long customerId) {
		Rewards monthlyReward = null;
		CustomerDTO cust = customerService.findById(customerId);

		List<TransactionDTO> threeMonthTrans = customerService.findThreeMonthTrans();
		Map<CustomerDTO, List<TransactionDTO>> custTrans = dataService.retrieveCustomerTransactions(threeMonthTrans);
		if (custTrans.containsKey(cust)) {
			monthlyReward = dataService.calculateMonthlyRewards(cust, custTrans.get(cust));
		}

		return monthlyReward;

	}

	@GetMapping("/rewards")
	public List<Rewards> monthlyRewardsReport() {

		List<Rewards> reward = new ArrayList<>();

		List<TransactionDTO> threeMonthTrans = customerService.findThreeMonthTrans();

		Map<CustomerDTO, List<TransactionDTO>> custTrans = dataService.retrieveCustomerTransactions(threeMonthTrans);

		custTrans.forEach((k, v) -> {
			Rewards monthlyReward = dataService.calculateMonthlyRewards(k, v);

			reward.add(monthlyReward);

		});

		return reward;
	}

}