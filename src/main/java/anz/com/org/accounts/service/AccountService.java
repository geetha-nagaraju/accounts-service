package anz.com.org.accounts.service;

import anz.com.org.accounts.dao.AccountDao;
import anz.com.org.accounts.model.Account;
import anz.com.org.accounts.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {

    @Autowired
    AccountDao accountDao;

    public List<Account> getAllAccountDetails() {

        List<Account> accounts = accountDao.getAccountList();
        return accounts;
    }

    public List<Transaction> getTransactionDetails(String accountId) {

        List<Transaction> accountTransactions = accountDao.getAccountTransactionDetails();
        return  accountTransactions;

    }
}