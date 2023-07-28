package com.chuwa.learn.demo.Service.Impl;

import com.chuwa.learn.demo.Service.CustomerService;
import com.chuwa.learn.demo.dao.CustomerRepository;
import com.chuwa.learn.demo.entity.Customer;
import com.chuwa.learn.demo.exception.ResourceNotFoundException;
import com.chuwa.learn.demo.payload.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private CustomerDTO convertToDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();

        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        return dto;
    }
    private Customer convertToEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        //id 自增
        customer.setLastName(dto.getLastName());
        customer.setFirstName(dto.getFirstName());
        return customer;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDto) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(customerDto.getFirstName());
        newCustomer.setLastName(customerDto.getLastName());

        Customer savedCustomer = this.customerRepository.save(newCustomer);

        return convertToDto(savedCustomer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> convertToDto(customer))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("customer","id",id));
        return convertToDto(customer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDto, long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("customer","id",id));

        customer.setLastName(customerDto.getLastName());
        customer.setFirstName(customerDto.getFirstName());

        Customer updatedCustomer = customerRepository.save(customer);

        return convertToDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
}
