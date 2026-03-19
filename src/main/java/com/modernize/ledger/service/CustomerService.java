package com.modernize.ledger.service;

import com.modernize.ledger.model.Account;
import com.modernize.ledger.model.Customer;
import com.modernize.ledger.repository.AccountRepository;
import com.modernize.ledger.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public CustomerService(CustomerRepository customerRepository,
                           AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    public Optional<Customer> findById(int customerId) {
        return customerRepository.findById(customerId);
    }

    public List<Account> findAccountsByCustomerId(int customerId) {
        return accountRepository.findByCustomerId(customerId);
    }
}
