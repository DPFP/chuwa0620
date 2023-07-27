package com.chuwa.rewardprogram.service;

import com.chuwa.rewardprogram.payload.TransactionDto;

public interface TransactionService {

    TransactionDto createTransaction(long id, TransactionDto dto);

    int calculateCustomerTotalPoints(long id);

    int pointsInPastNMonths(long id, int monthsBefore);
}
