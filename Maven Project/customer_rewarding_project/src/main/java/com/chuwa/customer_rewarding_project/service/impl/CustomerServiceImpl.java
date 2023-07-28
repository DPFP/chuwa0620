package com.chuwa.customer_rewarding_project.service.impl;

import com.chuwa.customer_rewarding_project.dao.CustomerRepository;
import com.chuwa.customer_rewarding_project.entity.Customer;
import com.chuwa.customer_rewarding_project.exception.ResourceNotFoundException;
import com.chuwa.customer_rewarding_project.payload.CustomerDto;
import com.chuwa.customer_rewarding_project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

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
        return mapToDto(savedCustomer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = this.customerRepository.findAll();
        return customers.stream().map(customer -> mapToDto(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return mapToDto(customer);
    }

    @Override
    public CustomerDto updateCustomerInfo(CustomerDto customerDto, long id) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customer.setEmail(customerDto.getEmail());
        Customer savedCustomer = this.customerRepository.save(customer);
        return mapToDto(savedCustomer);
    }

    @Override
    public void deleteCustomerById(long id) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        this.customerRepository.delete(customer);
    }
}
