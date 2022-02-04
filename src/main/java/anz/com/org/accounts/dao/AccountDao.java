package anz.com.org.accounts.dao;

import anz.com.org.accounts.enums.AccountType;
import anz.com.org.accounts.enums.DebitCreditEnum;
import anz.com.org.accounts.model.Account;
import anz.com.org.accounts.model.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountDao {

    /**
     * Get Account Details for user
     * @return List of Accounts
     */
    public List<Account> getAccountList() {
        List<Account> accounts = new ArrayList<>();

        Account account1 = Account.builder().accountNumber("595309209")
                .accountName("SGSavings726").accountType(AccountType.CURRENT).balanceDate("")
                .currency("SGD").balanceAmount("15000").build();

        Account account2 = Account.builder().accountNumber("781066619")
                .accountName("AUSavings726").accountType(AccountType.SAVINGS).balanceDate("")
                .currency("AUD").balanceAmount("2000").build();

        Account account3 = Account.builder().accountNumber("321143048")
                .accountName("AUCurrent433").accountType(AccountType.CURRENT).balanceDate("")
                .currency("AUD").balanceAmount("2000").build();

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }

    /**
     * Get Transaction Details for given AccountId
     * @param accountId
     * @return List Of Transactions
     */
    public List<Transaction> getAccountTransactionDetails(String accountId) {
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

       //return transactions;
    }

    /**
     * Get single Account information
     * @param accountNumber
     * @return account
     */
    public Account getAccount(String accountNumber) {

        List<Account> accounts = getAccountList();
        Account account = null;

        Optional<Account> acc = accounts.stream()
                .filter(acct-> acct.getAccountNumber().equals(accountNumber))
                .findAny();

        if (acc.isPresent()) {
            account = acc.get();
        }

        return account;
    }
}
