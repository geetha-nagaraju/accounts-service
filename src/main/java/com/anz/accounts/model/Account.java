package com.anz.accounts.model;

import com.anz.accounts.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements Serializable {

    private static final long serialVersionUID = 6373611532663483048L;

    private String accountNumber;

    private String accountName;

    private AccountType accountType;

    private String balanceDate;

    private String currency;

    private String balanceAmount;

    @Builder
    public Account (String accountNumber, String accountName, AccountType accountType, String balanceDate, String currency, String balanceAmount) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.balanceAmount = balanceAmount;
    }
}
