package com.chuwa.rewardprogram.service.impl;

import com.chuwa.rewardprogram.dao.CustomerRepository;
import com.chuwa.rewardprogram.dao.TranscationRepository;
import com.chuwa.rewardprogram.entity.Customer;
import com.chuwa.rewardprogram.entity.Transaction;
import com.chuwa.rewardprogram.exception.ResourceNotFoundException;
import com.chuwa.rewardprogram.payload.TransactionDto;
import com.chuwa.rewardprogram.service.TransactionService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.slf4j.Logger;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TranscationRepository transcationRepository;

    @Override
    public TransactionDto createTransaction(long customerId, TransactionDto dto) {
        Transaction t = ttoToT(dto);
        Customer c = customerRepository.findById(customerId)
                .orElseThrow( () -> {
                    logger.error("Failed to create transaction because customer id " + customerId + " does not exist.");
                    return new ResourceNotFoundException("Customer", "id", customerId);
                });

        t.setCustomer(c);
        Transaction transaction = transcationRepository.save(t);
        logger.info("Successfully created transaction id " + transaction.getId());
        return tToTto(transaction);
    }

    @Override
    public int calculateCustomerTotalPoints(long id) {
        List<Transaction> ls = transcationRepository.findByCustomerId(id);
        return ls.stream().map(e->calculatePoint(e.getAmount())).reduce(0, Integer::sum);
    }

    @Override
    public int pointsInPastNMonths(long id, int monthsBefore) {
        LocalDate currentDate = LocalDate.now();
        LocalDate resultDate = currentDate.minusMonths(monthsBefore);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String endDate = currentDate.format(formatter);
        String startDate = resultDate.format(formatter);
        List<Transaction> ls = transcationRepository.findByCustomerIdAndPurchaseTimeBetween(id, startDate, endDate);
        return ls.stream().map(e->calculatePoint(e.getAmount())).reduce(0, Integer::sum);
    }

    public static TransactionDto tToTto(Transaction t) {
        TransactionDto response = new TransactionDto();
        response.setId(t.getId());
        response.setAmount(t.getAmount());
        response.setPurchaseTime(t.getPurchaseTime());
        return response;
    }

    public static Transaction ttoToT(TransactionDto tto) {
        Transaction t = new Transaction();
        t.setId(tto.getId());
        t.setAmount(tto.getAmount());
        t.setPurchaseTime(tto.getPurchaseTime());
        return t;
    }

    public static int calculatePoint(int amount) {
        int point;
        if (amount <= 50) {
            point = 0;
        } else if (amount <= 100) {
            point = amount-50;
        } else {
            point = 50 + (amount-100)*2;
        }
        return point;
    }
}
