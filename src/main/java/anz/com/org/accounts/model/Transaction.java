package anz.com.org.accounts.model;

import anz.com.org.accounts.enums.AccountType;
import anz.com.org.accounts.enums.DebitCreditEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Transaction {

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
