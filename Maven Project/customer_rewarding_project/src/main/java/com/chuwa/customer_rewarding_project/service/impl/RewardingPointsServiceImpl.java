package com.chuwa.customer_rewarding_project.service.impl;

import com.chuwa.customer_rewarding_project.dao.CustomerRepository;
import com.chuwa.customer_rewarding_project.dao.RewardingPointsRepository;
import com.chuwa.customer_rewarding_project.entity.Customer;
import com.chuwa.customer_rewarding_project.entity.RewardingPoints;
import com.chuwa.customer_rewarding_project.exception.ResourceNotFoundException;
import com.chuwa.customer_rewarding_project.payload.RewardingPointsDto;
import com.chuwa.customer_rewarding_project.payload.RewardingPointsResponseDto;
import com.chuwa.customer_rewarding_project.payload.TransactionDto;
import com.chuwa.customer_rewarding_project.service.RewardingPointsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RewardingPointsServiceImpl implements RewardingPointsService {
    private final RewardingPointsRepository rewardingPointsRepository;
    private final CustomerRepository customerRepository;

    @Override
    public RewardingPointsDto createRewardingPoints(long customerId, TransactionDto transactionDto) {
        Customer customer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        RewardingPoints rewardingPoints = new RewardingPoints();
        rewardingPoints.setCustomer(customer);
        rewardingPoints.setAmount(rewardingPointsCalculator(transactionDto.getAmount()));
        RewardingPoints savedRewardingPoints = this.rewardingPointsRepository.save(rewardingPoints);
        return mapToDto(savedRewardingPoints);
    }

    @Override
    public RewardingPointsResponseDto getRewardingPointsInPastThreeMonths(long customerId) {
        this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

        // Get all points within 3 months
        LocalDate currentDate = LocalDate.now();
        LocalDate threeMonthsAgo = currentDate.minusMonths(3);
        List<RewardingPoints> rewardingPoints = this.rewardingPointsRepository
                .findAllByCustomer_IdAndCreationDateTimeAfter(customerId, threeMonthsAgo);

        // Map to response object
        RewardingPointsResponseDto responseDto = new RewardingPointsResponseDto();
        responseDto.setAmount(getRewardingPointsSum(rewardingPoints));
        responseDto.setStartDate(threeMonthsAgo);
        responseDto.setEndDate(currentDate);
        return responseDto;
    }

    @Override
    public RewardingPointsResponseDto getRewardingPointsInCurrentMonths(long customerId) {
        this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

        // Get all points within this month
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        List<RewardingPoints> rewardingPoints = this.rewardingPointsRepository
                .findAllByCustomer_IdAndCreationDateTimeAfter(customerId, firstDayOfMonth);

        // Map to response object
        RewardingPointsResponseDto responseDto = new RewardingPointsResponseDto();
        responseDto.setAmount(getRewardingPointsSum(rewardingPoints));
        responseDto.setStartDate(firstDayOfMonth);
        responseDto.setEndDate(currentDate);
        return responseDto;
    }

    @Override
    public double getRewardingPointsByCustomerIdInTotal(long customerId) {
        this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        List<RewardingPoints> rewardingPoints = this.rewardingPointsRepository
                .findAllByCustomer_Id(customerId);
        return getRewardingPointsSum(rewardingPoints);
    }

    @Override
    public List<RewardingPointsDto> getAllRewardingPointsRecord() {
        List<RewardingPoints> records = this.rewardingPointsRepository.findAll();
        return records.stream().map(record -> mapToDto(record)).collect(Collectors.toList());
    }

    @Override
    public void deleteRewardingPoints(long id) {
        RewardingPoints rewardingPoints = this.rewardingPointsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rewarding Points Record", "id", id));
        this.rewardingPointsRepository.delete(rewardingPoints);
    }

    private double getRewardingPointsSum(List<RewardingPoints> rewardingPoints){
        return rewardingPoints.stream().map(RewardingPoints::getAmount)
                .mapToDouble(Double::doubleValue).sum();
    }
    
    private double rewardingPointsCalculator(double transactionAmount){
        if(transactionAmount <= 50.0){
            return 0.00;
        } else if (transactionAmount > 50.0 && transactionAmount <= 100.0) {
            return Math.round((transactionAmount - 50.0) * 1 * 100.0) / 100.0;
        } else return Math.round((50.0 + (transactionAmount - 100.0) * 2) * 100.0) / 100.0;
    }

    private static RewardingPointsDto mapToDto(RewardingPoints rewardingPoints){
        RewardingPointsDto rewardingPointsDto = new RewardingPointsDto();
        rewardingPointsDto.setId(rewardingPoints.getId());
        rewardingPointsDto.setAmount(rewardingPoints.getAmount());
        return rewardingPointsDto;
    }
}
