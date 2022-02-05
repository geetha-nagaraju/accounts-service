package com.anz.accounts.model;

import com.anz.accounts.enums.DebitCreditEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction implements Serializable {

    private static final long serialVersionUID = 201L;

    private String accountNumber;

    private String accountName;

    private String transactionId;

    private String valueDate;

    private String currency;

    private String debitAmount;

    private String creditAmount;

    private DebitCreditEnum debitCreditIndicator;

    private String comments;

}
