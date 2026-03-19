package com.modernize.ledger.repository;

import com.modernize.ledger.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    List<Transaction> findByAccountIdOrderByCreatedAtDesc(int accountId);
}
