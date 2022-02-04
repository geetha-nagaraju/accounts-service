package com.anz.accounts.model;

import com.anz.accounts.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account extends User {

    private String accountNumber;

    private String accountName;

    private AccountType accountType;

    private String balanceDate;

    private String currency;

    private String balanceAmount;

    @Builder
    public Account(String userId, String accountNumber, String accountName, AccountType accountType, String balanceDate, String currency, String balanceAmount) {
        super(userId);
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.balanceAmount = balanceAmount;
    }
}
