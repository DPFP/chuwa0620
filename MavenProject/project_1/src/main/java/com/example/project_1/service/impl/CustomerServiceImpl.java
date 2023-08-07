package com.example.project_1.service.impl;

import com.example.project_1.repo.CustomerRepository;
import com.example.project_1.entity.Customer;
import com.example.project_1.exception.ResourceNotFoundException;
import com.example.project_1.payload.CustomerDTO;
import com.example.project_1.service.CustomerService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setUserName(customerDTO.getUsername());
        Customer savedCustomer = customerRepository.save(customer);
        return mapToDto(savedCustomer);
    }

    @Override
    public List<CustomerDTO> findAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOs = customers.stream().map(this::mapToDto).toList();
        return customerDTOs;
    }

    @Override
    public CustomerDTO getCustomerById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer", "id", id));
        return mapToDto(customer);
    }

    @Override
    public CustomerDTO updateCustomerById(long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer", "id", id));
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        Customer savedCustomer = customerRepository.save(customer);
        return mapToDto(savedCustomer);
    }

    @Override
    public void deleteCustomerById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer", "id", id));
        customerRepository.delete(customer);
    }

    private CustomerDTO mapToDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setUsername(customer.getUserName());
        return customerDTO;
    }
}
