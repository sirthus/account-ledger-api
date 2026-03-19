package com.modernize.ledger.controller;

import com.modernize.ledger.model.Transaction;
import com.modernize.ledger.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getAccount(@PathVariable int id) {
        return accountService.findById(id)
                .map(account -> {
                    Map<String, Object> body = new HashMap<>();
                    body.put("accountId",    account.getAccountId());
                    body.put("customerId",   account.getCustomerId());
                    body.put("accountType",  account.getAccountType());
                    body.put("status",       account.getStatus());
                    body.put("balanceCents", account.getBalanceCents());
                    return ResponseEntity.ok(body);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable int id) {
        if (accountService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountService.findTransactionsByAccountId(id));
    }
}
