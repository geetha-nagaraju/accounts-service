package com.anz.accounts.model;

import com.anz.accounts.enums.DebitCreditEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction implements Serializable {

    private static final long serialVersionUID = 6373611555563483048L;

    private String accountNumber;

    private String accountName;

    private String transactionId;

    private String valueDate;

    private String currency;

    private String debitAmount;

    private String creditAmount;

    private DebitCreditEnum debitCreditIndicator;

    private String comments;

    @Builder
    public Transaction (String accountNumber, String accountName, String transactionId, String valueDate, String currency, String debitAmount, String creditAmount, DebitCreditEnum debitCreditIndicator, String comments) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.transactionId = transactionId;
        this.valueDate = valueDate;
        this.currency = currency;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.debitCreditIndicator = debitCreditIndicator;
        this.comments = comments;
    }
}
