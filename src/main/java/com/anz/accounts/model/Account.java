package com.anz.accounts.model;

import com.anz.accounts.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements Serializable {

    private static final long serialVersionUID = 101L;

    private String accountNumber;

    private String accountName;

    private AccountType accountType;

    private String balanceDate;

    private String currency;

    private String balanceAmount;
}
