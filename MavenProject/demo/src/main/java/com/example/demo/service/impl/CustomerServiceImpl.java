package com.example.demo.service.impl;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.payload.CustomerDto;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    private static CustomerDto mapToDto(Customer customer){
        CustomerDto response = new CustomerDto();
        response.setId(customer.getId());
        response.setFirstname(customer.getFirstname());
        response.setLastname(customer.getLastname());
        response.setEmail(customer.getEmail());
        return response;
    }
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());
        customer.setEmail(customerDto.getEmail());

        Customer savedCustomer = this.customerRepository.save(customer);
        CustomerDto result = modelMapper.map(savedCustomer, CustomerDto.class);
        return result;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = this.customerRepository.findAll();
        return customers.stream().map(customer -> modelMapper.map(customer,CustomerDto.class)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomerInfo(CustomerDto customerDto, long id) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customer.setEmail(customerDto.getEmail());
        Customer savedCustomer = this.customerRepository.save(customer);
        return modelMapper.map(savedCustomer,CustomerDto.class);
    }

    @Override
    public void deleteCustomerById(long id) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        this.customerRepository.delete(customer);
    }
}