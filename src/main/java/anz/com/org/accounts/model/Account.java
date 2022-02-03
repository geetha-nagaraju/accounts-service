package anz.com.org.accounts.model;

import anz.com.org.accounts.enums.AccountType;
import lombok.*;

@Getter
@Setter
@Builder
public class Account {

    private String accountNumber;

    private String accountName;

    private AccountType accountType;

    private String balanceDate;

    private String currency;

    private String balanceAmount;

}
