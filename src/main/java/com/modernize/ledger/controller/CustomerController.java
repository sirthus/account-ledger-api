package com.modernize.ledger.controller;

import com.modernize.ledger.model.Account;
import com.modernize.ledger.model.Customer;
import com.modernize.ledger.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCustomer(@PathVariable int id) {
        return customerService.findById(id)
                .map(customer -> {
                    Map<String, Object> body = new HashMap<>();
                    body.put("customerId", customer.getCustomerId());
                    body.put("fullName",   customer.getFullName());
                    body.put("email",      customer.getEmail() != null ? customer.getEmail() : "");
                    return ResponseEntity.ok(body);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/accounts")
    public ResponseEntity<List<Account>> getCustomerAccounts(@PathVariable int id) {
        if (customerService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerService.findAccountsByCustomerId(id));
    }
}
