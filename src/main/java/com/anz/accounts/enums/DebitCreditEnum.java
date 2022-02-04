package com.anz.accounts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DebitCreditEnum {

    DEBIT("Debit"),
    CREDIT("Credit");

    public String value;

    private DebitCreditEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return this.value;
    }

    @JsonCreator
    public static DebitCreditEnum valueOfLabel(String value) {
        for (DebitCreditEnum e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }
}
