package com.modernize.ledger.service;

import com.modernize.ledger.model.Account;
import com.modernize.ledger.model.Transaction;
import com.modernize.ledger.repository.AccountRepository;
import com.modernize.ledger.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository,
                          TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Optional<Account> findById(int accountId) {
        return accountRepository.findById(accountId);
    }

    public List<Transaction> findTransactionsByAccountId(int accountId) {
        return transactionRepository.findByAccountIdOrderByCreatedAtDesc(accountId);
    }
}
