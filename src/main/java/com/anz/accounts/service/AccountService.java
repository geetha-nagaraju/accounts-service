package com.anz.accounts.service;

import com.anz.accounts.dao.AccountDao;
import com.anz.accounts.model.Account;
import com.anz.accounts.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountDao accountDao;;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

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
     * @param accountId
     * @return transactions List
     */
    public List<Transaction> getTransactionDetails(String accountId) {

        List<Transaction> accountTransactions = accountDao.getAccountTransactionDetails(accountId);
        return  accountTransactions;
    }

    /**
     * Get Single Account Information
     * @param accountNumber
     * @return Account
     */
    public Account getAccountDetails(String accountNumber) {
        Account account = accountDao.getAccount(accountNumber);
        return account;
    }
}
