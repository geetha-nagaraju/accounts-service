package com.anz.accounts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountType {

    CURRENT("Current"),
    SAVINGS("Savings");

    private String accountType;

    private AccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return this.accountType;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(accountType);
    }

    @JsonCreator
    public static AccountType getValue(String value) {
        for (AccountType accType : AccountType.values()) {
            if (accType.getAccountType().equals(value)) {
                return accType;
            }
        }
        return null;
    }
}
