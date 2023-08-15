package com.example.coding1reward.service.impl;

import com.example.coding1reward.dao.CustomerRepository;
import com.example.coding1reward.dao.TransactionRepository;
import com.example.coding1reward.entity.Customer;
import com.example.coding1reward.entity.Transaction;
import com.example.coding1reward.exception.ResourceNotFoundException;
import com.example.coding1reward.payload.CustomerDto;
import com.example.coding1reward.payload.RewardResponse;
import com.example.coding1reward.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RewardResponse getTotalRewardByCustomerId(long id) {
        // check customer exists
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));

        // get all transaction records with customer id
        List<Transaction> transactionList = transactionRepository.findTransactionByCustomer(customer);

        // loop transaction, calculate month-reward + total reward
        double totalReward = 0;
        for (Transaction transaction : transactionList) {
            double amount = transaction.getAmount();
            double curReward = calculateReward(amount);
            totalReward += curReward;
        }

        // set response
        RewardResponse response = new RewardResponse();
        response.setCustomerId(id);
        response.setRewardTotal(totalReward);
        response.setMonthToReward(new HashMap<>());

        return response;
    }

    @Override
    public RewardResponse getRewardByCustomerIdByMonthsLimit(long id, long monthsLimit, boolean zeroRecordShow) {
        // check customer exists
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));

        // current time
        LocalDateTime curTime = LocalDateTime.now();
        // first day of the month from month limit
        LocalDateTime preTime = LocalDateTime.now().minusMonths(monthsLimit - 1)
                .withDayOfMonth(1)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        // check if the given months limit is longer than the oldest record in current database
        Transaction oldestRecord = transactionRepository.findFirstTransactionByCustomerOrderByCreateDateTimeAsc(customer).orElseThrow(() -> new ResourceNotFoundException("transaction", "customer-id", id));
        LocalDateTime oldestCreateTime = oldestRecord.getCreateDateTime();
        Period period = Period.between(oldestCreateTime.toLocalDate(), curTime.toLocalDate());
        int oldestMonthLimit = period.getYears() * 12 + period.getMonths() + 1;
        if (monthsLimit > oldestMonthLimit) {
            throw new ResourceNotFoundException("Month Limit", "month_limit", monthsLimit);
        }


        // get transactions record
        List<Transaction> transactionList = transactionRepository.findTransactionByCustomerAndCreateDateTimeBetween(customer, preTime, curTime);

        // initialize the month to reward map for each month (included 0 reward months)
        Map<String, Double> monthToRewardMap = new TreeMap<>();
        if (zeroRecordShow) {
            LocalDateTime currentTimePoint = preTime;
            while (!currentTimePoint.isAfter(curTime)) {
                monthToRewardMap.put(currentTimePoint.format(DateTimeFormatter.ofPattern("yyyy-MM")), 0.0);
                currentTimePoint = currentTimePoint.plusMonths(1);
            }
        }

        // set record from transactionList into map
        double totalReward = 0;
        for (Transaction transaction : transactionList) {
            double amount = transaction.getAmount();
            double curReward = calculateReward(amount);
            totalReward += curReward;
            LocalDateTime createTime = transaction.getCreateDateTime();
            String createTimeStr = createTime.format(DateTimeFormatter.ofPattern("yyyy-MM"));
            monthToRewardMap.put(createTimeStr, monthToRewardMap.getOrDefault(createTimeStr, 0.0) + curReward);
        }

        // set response
        RewardResponse response = new RewardResponse();
        response.setCustomerId(id);
        response.setRewardTotal(totalReward);
        response.setMonthToReward(monthToRewardMap);

        return response;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer saveCustomer = customerRepository.save(customer);
        return modelMapper.map(saveCustomer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> modelMapper.map(customers, CustomerDto.class)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomerInfo(CustomerDto customerDto, long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customer.setEmail(customerDto.getEmail());
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public void deleteCustomerById(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepository.delete(customer);
    }


    // calculate the reward with given amount
    private double calculateReward(double amount) {
        double reward = 0;
        if (amount <= 50) {
            reward = 0;
        } else if (amount > 50 && amount <= 100) {
            reward = amount - 50;
        } else {
            reward = 50 + (amount - 100) * 2;
        }
        return reward;
    }

}







