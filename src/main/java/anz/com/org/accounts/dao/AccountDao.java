package anz.com.org.accounts.dao;

import anz.com.org.accounts.enums.AccountType;
import anz.com.org.accounts.enums.DebitCreditEnum;
import anz.com.org.accounts.model.Account;
import anz.com.org.accounts.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountDao {

    public List<Account> getAccountList() {
        List<Account> accounts = new ArrayList<>();

        Account account1 = Account.builder().accountNumber("595309209")
                .accountName("SGSavings726").accountType(AccountType.CURRENT).balanceDate("")
                .currency("SGD").balanceAmount("15000").build();

        Account account2 = Account.builder().accountNumber("781066619")
                .accountName("AUSavings726").accountType(AccountType.SAVINGS).balanceDate("")
                .currency("AUD").balanceAmount("2000").build();

        accounts.add(account1);
        accounts.add(account2);

        return accounts;
    }

    public List<Transaction> getAccountTransactionDetails() {
        List<Transaction> transactions = new ArrayList<>();

        Transaction transaction1 = Transaction.builder().accountNumber("595309209")
                .accountName("SGSavings726").transactionId("12345").valueDate("").currency("SGD").debitAmount("1000").creditAmount("")
                .debitCreditIndicator(DebitCreditEnum.DEBIT).comments("Debited").build();

        Transaction transaction2 = Transaction.builder().accountNumber("595309209")
                .accountName("SGSavings726").transactionId("12346").valueDate("").currency("SGD").creditAmount("1500")
                .debitCreditIndicator(DebitCreditEnum.CREDIT).comments("Credited").build();

        transactions.add(transaction1);
        transactions.add(transaction1);

        return transactions;
    }
}
