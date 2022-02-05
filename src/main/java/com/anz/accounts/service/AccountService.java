package com.anz.accounts.service;

import com.anz.accounts.dao.AccountDao;
import com.anz.accounts.model.Account;
import com.anz.accounts.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountDao accountDao;

    /**
     * get List of account Details
     * @return account List
     */
    public List<Account> getAllAccountDetails() {
        List<Account> accounts = accountDao.getAccountList();
        return accounts;
    }

    /**
     * Get Transactions for given Account
     * @param accountId Account Id
     * @return transactions List
     */
    public List<Transaction> getTransactionDetails(final String accountId) {

        List<Transaction> accountTransactions = accountDao.getAccountTransactionDetails(accountId);
        return  accountTransactions;
    }

    /**
     * Get Single Account Information
     * @param accountNumber Account Number
     * @return Account
     */
    public Account getAccountDetails(final String accountNumber) {
        Account account = accountDao.getAccount(accountNumber);
        return account;
    }
}
