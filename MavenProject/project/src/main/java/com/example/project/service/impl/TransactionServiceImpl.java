package com.example.project.service.impl;

import com.example.project.dao.CustomerRepository;
import com.example.project.dao.ProductRepository;
import com.example.project.dao.TransactionRepository;
import com.example.project.entity.Customer;
import com.example.project.entity.Product;
import com.example.project.entity.Transaction;
import com.example.project.exception.ResourceNotFoundException;
import com.example.project.exception.StoreAPIException;
import com.example.project.payload.CustomerDto;
import com.example.project.payload.ProductDto;
import com.example.project.payload.TransactionDto;
import com.example.project.payload.TransactionDto;
import com.example.project.service.TransactionService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private CustomerRepository customerRepository;
    private TransactionRepository transactionRepository;
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, CustomerRepository customerRepository, ProductRepository productRepository, ModelMapper modelMapper){
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionDto createTransaction(Long customerId, TransactionDto transactionDto) {
        Transaction newTransaction = modelMapper.map(transactionDto, Transaction.class);
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

        newTransaction.setCustomer(customer);

        Transaction savedTransaction = this.transactionRepository.save(newTransaction);
        return modelMapper.map(savedTransaction, TransactionDto.class);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = transactions.stream().map(transaction -> modelMapper.map(transaction, TransactionDto.class)).collect(Collectors.toList());
        return transactionDtos;
    }

    @Override
    public List<TransactionDto> getAllTransactionsByCustomerId(Long customerId) {
        customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer","id",customerId));
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        List<TransactionDto> transactionDtos = transactions.stream().map(transaction -> modelMapper.map(transaction, TransactionDto.class)).collect(Collectors.toList());
        return transactionDtos;
    }

    @Override
    public TransactionDto getTransactionById(Long customerId, Long transactionId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer","id",customerId));
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() -> new ResourceNotFoundException("Transaction","id",transactionId));

        if (!transaction.getCustomer().getId().equals(customer.getId())) {
            throw new StoreAPIException(HttpStatus.BAD_REQUEST, "Transaction does not belong to customer");
        }

        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public void deleteTransactionById(Long customerId, Long transactionId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer","id",customerId));
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() -> new ResourceNotFoundException("Transaction","id",transactionId));

        if (!transaction.getCustomer().getId().equals(customer.getId())) {
            throw new StoreAPIException(HttpStatus.BAD_REQUEST, "Transaction does not belong to customer");
        }

        transactionRepository.deleteById(transactionId);
    }

    @Override
    @Transactional
    public TransactionDto deleteProductsInTransactionByProductIds(List<Long> productIds, Long customerId, Long transactionId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer","id",customerId));
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() -> new ResourceNotFoundException("Transaction","id",transactionId));

        if (!transaction.getCustomer().getId().equals(customer.getId())) {
            throw new StoreAPIException(HttpStatus.BAD_REQUEST, "Transaction does not belong to customer");
        }

        // get all products
        List<Product> productsToBeDeleted = productIds.stream()
                .map(productId -> productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product","id",productId)))
                .collect(Collectors.toList());

        // delete according products belong to the transaction
        Set<Product> products = transaction.getProducts();
        for(Product productToBeDeleted: productsToBeDeleted){
            if(!products.contains(productToBeDeleted)) throw new ResourceNotFoundException("Product","id",productToBeDeleted.getId());
            products.remove(productToBeDeleted);
        }

        transaction.setProducts(products);
        Transaction updateTransaction = transactionRepository.save(transaction);
        return modelMapper.map(updateTransaction, TransactionDto.class);
    }

    @Override
    public TransactionDto addProductsToTransactionByProductIds(List<Long> productIds, Long customerId, Long transactionId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer","id",customerId));
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() -> new ResourceNotFoundException("Transaction","id",transactionId));

        if (!transaction.getCustomer().getId().equals(customer.getId())) {
            throw new StoreAPIException(HttpStatus.BAD_REQUEST, "Transaction does not belong to customer");
        }

        // get all products
        List<Product> products = productIds.stream()
                .map(productId -> productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product","id",productId)))
                .collect(Collectors.toList());

        // add all products to the transaction
        transaction.getProducts().addAll(products);

        Transaction updateTransaction = transactionRepository.save(transaction);
        return modelMapper.map(updateTransaction, TransactionDto.class);
    }
}
