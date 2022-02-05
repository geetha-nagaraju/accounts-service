package com.anz.accounts.service;

import com.anz.accounts.TestHelper;
import com.anz.accounts.dao.AccountDao;
import com.anz.accounts.enums.AccountType;
import com.anz.accounts.enums.DebitCreditEnum;
import com.anz.accounts.model.Account;
import com.anz.accounts.model.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    AccountService accountService;

    @Mock
    AccountDao accountDao;

    @BeforeEach
    public void setUp() { }

    List<Account> getAccounts() {
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

    @Test
    void test_getAccounts() {
        Mockito.when(accountDao.getAccountList()).thenReturn(TestHelper.getAccounts ());
        List<Account> accounts = accountService.getAllAccountDetails();
        Assertions.assertEquals(accounts.size(),2);
        Assertions.assertEquals(accounts.get(0).getAccountNumber(), "595309209");
    }

    @Test
    void test_getAccountsTransactions() {
        String accountId = "595309209";
        Mockito.when(accountDao.getAccountTransactionDetails(accountId)).thenReturn(TestHelper.getAccountTransactions(accountId));
        List<Transaction> transactions = accountService.getTransactionDetails(accountId);
        Assertions.assertEquals(transactions.size(),2);
        Assertions.assertEquals(transactions.get(0).getAccountNumber(), "595309209");
        Assertions.assertEquals(transactions.get(0).getTransactionId(), "12345");
    }

    @Test
    void test_getAccountsTransactions_single() {
        String accountId = "781066619";
        Mockito.when(accountDao.getAccountTransactionDetails(accountId)).thenReturn(TestHelper.getAccountTransactions(accountId));
        List<Transaction> transactions = accountService.getTransactionDetails(accountId);
        Assertions.assertEquals(transactions.size(),1);
        Assertions.assertEquals(transactions.get(0).getAccountNumber(), "781066619");
        Assertions.assertEquals(transactions.get(0).getTransactionId(), "12347");
    }

}
