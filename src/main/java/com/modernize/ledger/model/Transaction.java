package com.modernize.ledger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Table("transactions")
public class Transaction {

    @Id
    private Integer txnId;
    private Integer accountId;
    private String direction;
    private Long amountCents;
    private String description;
    private OffsetDateTime createdAt;

    public Integer getTxnId() { return txnId; }
    public void setTxnId(Integer txnId) { this.txnId = txnId; }

    public Integer getAccountId() { return accountId; }
    public void setAccountId(Integer accountId) { this.accountId = accountId; }

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }

    public Long getAmountCents() { return amountCents; }
    public void setAmountCents(Long amountCents) { this.amountCents = amountCents; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
