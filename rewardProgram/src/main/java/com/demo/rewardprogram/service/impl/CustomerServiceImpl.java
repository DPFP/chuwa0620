package com.demo.rewardprogram.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demo.rewardprogram.entity.Customer;
import com.demo.rewardprogram.entity.TransactionData;
import com.demo.rewardprogram.model.CustomerDTO;
import com.demo.rewardprogram.model.TransactionDTO;
import com.demo.rewardprogram.service.DataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.rewardprogram.repo.CustomerRepository;
import com.demo.rewardprogram.repo.TransactionDataRepository;
import com.demo.rewardprogram.service.CustomerService;


@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private DataService dataService;

	private com.demo.rewardprogram.service.impl.DataMapper testData = new DataMapper();
	@Autowired
	private TransactionDataRepository tranRepo;

	@Override
	public CustomerDTO findById(Long custId) {
		Optional<Customer> foundCust = custRepo.findById(custId);
		if (foundCust.isPresent()) {
			return dataService.toCustomerModel(foundCust.get());
		}
		return null;
	}


	@Override
	public List<TransactionDTO> findThreeMonthTrans() {
		List<TransactionDTO> threeMonthTrans = new ArrayList<>();
		createData();
		List<TransactionData> threeMonthTranRecords = tranRepo
				.findAllInLastThreeMonth();


		threeMonthTranRecords.forEach(source -> {
			TransactionDTO target = new TransactionDTO();
			BeanUtils.copyProperties(source, target);
			target.setCustomer(dataService.toCustomerModel(source.getCustomer()));
			threeMonthTrans.add(target);
		});

		return threeMonthTrans;
	}

	public void createData() {
		if (custRepo.findAll().isEmpty()) {
			Customer mary = custRepo.save(testData.createCustomer("Mary"));
			Customer tom = custRepo.save(testData.createCustomer("Tom"));

			tranRepo.save(testData.createTransactionRecord(mary, "20", 0, 2));
			tranRepo.save(testData.createTransactionRecord(mary, "120", 1, 2));
			tranRepo.save(testData.createTransactionRecord(mary, "100", 1, 5));
			tranRepo.save(testData.createTransactionRecord(mary, "20", 2, 0));
			tranRepo.save(testData.createTransactionRecord(mary, "60", 2, 4));
			tranRepo.save(testData.createTransactionRecord(mary, "120", 2, 4));

			tranRepo.save(testData.createTransactionRecord(tom, "120", 1, 3));
			tranRepo.save(testData.createTransactionRecord(tom, "20", 2, 1));
			tranRepo.save(testData.createTransactionRecord(tom, "100", 1, 15));
			tranRepo.save(testData.createTransactionRecord(tom, "56", 2, 14));
			tranRepo.save(testData.createTransactionRecord(tom, "110", 0, 15));
			tranRepo.save(testData.createTransactionRecord(tom, "66", 0, 14));
		}
	}

}
