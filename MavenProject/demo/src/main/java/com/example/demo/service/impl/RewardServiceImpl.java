package com.example.demo.service.impl;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.RewardsRepository;
import com.example.demo.dao.TransactionRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.Rewards;
import com.example.demo.model.Transaction;
import com.example.demo.payload.RewardDto;
import com.example.demo.payload.RewardsResponseDto;
import com.example.demo.payload.TransactionDto;
import com.example.demo.service.RewardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RewardServiceImpl implements RewardService {
    private final RewardsRepository rewardingPointsRepository;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;
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
    @Override
    public RewardDto createRewardingPoints(long customerId, TransactionDto transactionDto) {
        Customer customer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        Rewards rewardingPoints = new Rewards();
        rewardingPoints.setCustomer(customer);
        rewardingPoints.setAmount(rewardingPointsCalculator(transactionDto.getAmount()));
        Rewards savedRewardingPoints = this.rewardingPointsRepository.save(rewardingPoints);
        return modelMapper.map(savedRewardingPoints,RewardDto.class);
    }

    @Override
    public RewardsResponseDto getRewardingPointsInPastThreeMonths(long customerId) {
        this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

        // Get all points within 3 months
        LocalDate currentDate = LocalDate.now();
        LocalDate threeMonthsAgo = currentDate.minusMonths(3);
        List<Rewards> rewardingPoints = this.rewardingPointsRepository
                .findAllByCustomer_IdAndCreationDateTimeAfter(customerId, threeMonthsAgo);

        // Map to response object
        RewardsResponseDto responseDto = new RewardsResponseDto();
        responseDto.setAmount(getRewardingPointsSum(rewardingPoints));
        responseDto.setStartDate(threeMonthsAgo);
        responseDto.setEndDate(currentDate);
        return responseDto;
    }

    @Override
    public RewardsResponseDto getRewardingPointsInCurrentMonths(long customerId) {
        this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

        // Get all points within this month
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        List<Rewards> rewardingPoints = this.rewardingPointsRepository
                .findAllByCustomer_IdAndCreationDateTimeAfter(customerId, firstDayOfMonth);

        // Map to response object
        RewardsResponseDto responseDto = new RewardsResponseDto();
        responseDto.setAmount(getRewardingPointsSum(rewardingPoints));
        responseDto.setStartDate(firstDayOfMonth);
        responseDto.setEndDate(currentDate);
        return responseDto;
    }

    @Override
    public double getRewardingPointsByCustomerIdInTotal(long customerId) {
        this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        List<Rewards> rewardingPoints = this.rewardingPointsRepository
                .findAllByCustomer_Id(customerId);
        return getRewardingPointsSum(rewardingPoints);
    }

    @Override
    public List<RewardDto> getAllRewardingPointsRecord() {
        List<Rewards> records = this.rewardingPointsRepository.findAll();
        return records.stream().map(record -> modelMapper.map(record,RewardDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteRewardingPoints(long id) {
        Rewards rewardingPoints = this.rewardingPointsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rewarding Points Record", "id", id));
        this.rewardingPointsRepository.delete(rewardingPoints);
    }

    private double getRewardingPointsSum(List<Rewards> rewardingPoints){
        return rewardingPoints.stream().map(Rewards::getAmount)
                .mapToDouble(Double::doubleValue).sum();
    }

    private double rewardingPointsCalculator(double transactionAmount){
        if(transactionAmount <= 50.0){
            return 0.00;
        } else if (transactionAmount > 50.0 && transactionAmount <= 100.0) {
            return Math.round((transactionAmount - 50.0) * 1 * 100.0) / 100.0;
        } else return Math.round((50.0 + (transactionAmount - 100.0) * 2) * 100.0) / 100.0;
    }
}
