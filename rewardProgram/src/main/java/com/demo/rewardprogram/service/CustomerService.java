package com.demo.rewardprogram.service;

import java.util.List;

import com.demo.rewardprogram.model.CustomerDTO;
import com.demo.rewardprogram.model.TransactionDTO;

public interface CustomerService {

	CustomerDTO findById(Long custId);

	List<TransactionDTO> findThreeMonthTrans();

}