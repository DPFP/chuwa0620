package com.example.project.service.impl;

import com.example.project.dao.CustomerRepository;
import com.example.project.dao.ProductRepository;
import com.example.project.dao.TransactionRepository;
import com.example.project.entity.Product;
import com.example.project.entity.Transaction;
import com.example.project.exception.ResourceNotFoundException;
import com.example.project.payload.RewardDto;
import com.example.project.service.RewardService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RewardServiceImpl implements RewardService {
    private CustomerRepository customerRepository;
    private TransactionRepository transactionRepository;
    private ProductRepository productRepository;

    public RewardServiceImpl(CustomerRepository customerRepository, TransactionRepository transactionRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
    }

    @Override
    public RewardDto getRewardsByCustomerIdAndPeriod(Long customerId, LocalDate endDate, int period) {
        customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer","id",customerId));

        long totalRewards = 0;
        RewardDto rewardDto = new RewardDto();

        for(int i = period; i > 0; i--){
            LocalDate startDate = endDate.minusMonths(i);
            LocalDate tmpDate = startDate.plusMonths(1);
            List<Transaction> transactions = transactionRepository.findByIdWithinMonth(customerId, startDate, tmpDate);
            int sumMonthlyReward = transactions.stream()
                    .mapToInt(Transaction::rewardOfEachTransaction)
                    .sum();

            rewardDto.getMonthlyReport().put(startDate.toString()+" - "+tmpDate.toString(), (long) sumMonthlyReward);
            totalRewards += sumMonthlyReward;
        }

        rewardDto.setTotalRewards(totalRewards);
        rewardDto.setPeriod(period);
        rewardDto.setEndDate(endDate);

        return rewardDto;
    }


}
