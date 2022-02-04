package anz.com.org.accounts.model;

import anz.com.org.accounts.enums.DebitCreditEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction extends  User{

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
    public Transaction(String userId, String accountNumber, String accountName, String transactionId, String valueDate, String currency, String debitAmount, String creditAmount, DebitCreditEnum debitCreditIndicator, String comments) {
        super(userId);
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
