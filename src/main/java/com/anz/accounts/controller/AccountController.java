package com.anz.accounts.controller;

import com.anz.accounts.exception.ServiceException;
import com.anz.accounts.model.Account;
import com.anz.accounts.model.Transaction;
import com.anz.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping()
    public ResponseEntity<List<Account>> getAllAccounts() throws ServiceException {
        return new ResponseEntity<>( accountService.getAllAccountDetails(), HttpStatus.OK );
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getAccount(@PathVariable(value = "id") final String accountId) throws ServiceException {
        return new ResponseEntity<>( accountService.getAccountDetails(accountId), HttpStatus.OK );
    }

    @GetMapping("{id}/transactions")
    public ResponseEntity<List<Transaction>> getAccountTransactionsById( @PathVariable(value = "id") final String accountId)
            throws ServiceException {
        return new ResponseEntity<>( accountService.getTransactionDetails(accountId), HttpStatus.OK );
    }
}
