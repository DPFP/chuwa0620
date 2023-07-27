package com.demo.rewardprogram.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import com.demo.rewardprogram.service.impl.DataMapper;
import org.junit.jupiter.api.Test;

import com.demo.rewardprogram.service.impl.DataMapper;

class TransactionRecordTest {

	private DataMapper testData = new DataMapper();

	@Test
	void test_calculateRewardPoint_lessThan_51() {
		TransactionDTO trans = testData.createTransactionRecordDTO(null, "50", 2, 2);

		assertEquals(0, trans.getRewardPoint().compareTo(new BigDecimal("0")));
	}

	@Test
	void test_calculateRewardPoint_moreThan_100() {
		TransactionDTO trans = testData.createTransactionRecordDTO(null, "120", 2, 2);

		assertEquals(0, trans.getRewardPoint().compareTo(new BigDecimal("90")));
	}

	@Test
	void test_calculateRewardPoint_moreThan_50() {
		TransactionDTO trans = testData.createTransactionRecordDTO(null, "70", 2, 2);

		assertEquals(0, trans.getRewardPoint().compareTo(new BigDecimal("20")));
	}

}
