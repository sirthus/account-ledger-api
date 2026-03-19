package com.modernize.ledger.repository;

import com.modernize.ledger.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    List<Account> findByCustomerId(int customerId);
}
