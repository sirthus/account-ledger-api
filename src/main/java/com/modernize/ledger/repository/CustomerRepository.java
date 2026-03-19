package com.modernize.ledger.repository;

import com.modernize.ledger.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
