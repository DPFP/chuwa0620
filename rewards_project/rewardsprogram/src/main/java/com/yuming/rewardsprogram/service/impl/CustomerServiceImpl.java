package com.yuming.rewardsprogram.service.impl;

import com.yuming.rewardsprogram.dao.CustomerRepo;
import com.yuming.rewardsprogram.dto.CustomerDto;
import com.yuming.rewardsprogram.entity.Customer;
import com.yuming.rewardsprogram.exception.ResourceNotFoundException;
import com.yuming.rewardsprogram.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo;
    private ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper modelMapper) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer = customerRepo.save(customer);
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer existingCustomer = customerRepo.findById(id)
                                                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        existingCustomer.setName(customerDto.getName());
        existingCustomer.setEmail(customerDto.getEmail());

        existingCustomer = customerRepo.save(existingCustomer);
        return modelMapper.map(existingCustomer, CustomerDto.class);
    }


    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepo.delete(customer);

    }
}
