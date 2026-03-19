package com.modernize.ledger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("accounts")
public class Account {

    @Id
    private Integer accountId;
    private Integer customerId;
    private String accountType;
    private String status;
    private Long balanceCents;

    public Integer getAccountId() { return accountId; }
    public void setAccountId(Integer accountId) { this.accountId = accountId; }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getBalanceCents() { return balanceCents; }
    public void setBalanceCents(Long balanceCents) { this.balanceCents = balanceCents; }
}
