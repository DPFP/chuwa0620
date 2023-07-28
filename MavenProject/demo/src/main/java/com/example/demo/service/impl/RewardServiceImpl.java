package com.example.demo.service.impl;

import com.example.demo.dao.TransactionRepository;
import com.example.demo.model.Transaction;
import com.example.demo.payload.RewardDto;
import com.example.demo.service.RewardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RewardServiceImpl implements RewardService {

    private final TransactionRepository transactionRepository;
    @Override
    public RewardDto getRewardById(Long id,Integer month) {
        // get all transaction for current user within given time range.
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.add(Calendar.MONTH,month*-1);
        Date targetDate = ca.getTime();

        List<Transaction> res = transactionRepository.findByUserIdAndDateAfter(id,targetDate);

        double[] rewards = new double[]{0.0};

        res.stream().mapToDouble(Transaction::getAmount).forEach(value -> {
            if(value > 100){
                rewards[0] += (value-100)*2;
            }
            if(value > 50) {
                rewards[0] += 50;
            }
        });

        double amount = res.stream().mapToDouble(Transaction::getAmount).sum();

        RewardDto finalResult = new RewardDto(id,amount,rewards[0],targetDate);
        return finalResult;
    }
}
