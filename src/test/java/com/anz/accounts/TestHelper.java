package com.anz.accounts;

import com.anz.accounts.enums.AccountType;
import com.anz.accounts.enums.DebitCreditEnum;
import com.anz.accounts.model.Account;
import com.anz.accounts.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestHelper {

    public static List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<> ();

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

    public static List<Transaction> getAccountTransactions(String accountId) {

        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = Transaction.builder().accountNumber("595309209")
                .accountName("SGSavings726").transactionId("12345").valueDate("2021-12-02").currency("SGD").debitAmount("1000").creditAmount("")
                .debitCreditIndicator(DebitCreditEnum.DEBIT).comments("Debited").build();

        Transaction transaction2 = Transaction.builder().accountNumber("595309209")
                .accountName("SGSavings726").transactionId("12346").valueDate("2021-12-01").currency("SGD").creditAmount("1500")
                .debitCreditIndicator(DebitCreditEnum.CREDIT).comments("Credited").build();

        Transaction transaction3 = Transaction.builder().accountNumber("781066619")
                .accountName("AUDSavings726").transactionId("12347").valueDate("2022-02-01").currency("SGD").creditAmount("1500")
                .debitCreditIndicator(DebitCreditEnum.CREDIT).comments("Credited").build();

        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);

        Map<String, List<Transaction>> acctTransactionMap = transactions.stream().collect(
                Collectors.groupingBy(Transaction::getAccountNumber,
                        Collectors.toList()));

        return acctTransactionMap.get(accountId);
    }
}
