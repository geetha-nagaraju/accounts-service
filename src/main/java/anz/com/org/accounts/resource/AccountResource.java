package anz.com.org.accounts.resource;

import anz.com.org.accounts.exception.ServiceException;
import anz.com.org.accounts.model.Account;
import anz.com.org.accounts.model.Transaction;
import anz.com.org.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountResource {

    @Autowired
    AccountService accountService;

    @GetMapping()
    public ResponseEntity<List<Account>> getAllAccounts() {                    //@RequestParam String userId
        return new ResponseEntity<>( accountService.getAllAccountDetails(), HttpStatus.OK );

    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getAccount(@PathVariable(value = "id") String accountId) {
        return new ResponseEntity<>( accountService.getAccountDetails(accountId), HttpStatus.OK );

    }

    @GetMapping("{id}/transactions")
    public ResponseEntity<List<Transaction>> getAccountTransactionsById(@PathVariable(value = "id") String accountId)
            throws ServiceException {
        return new ResponseEntity<>( accountService.getTransactionDetails(accountId), HttpStatus.OK );
    }
}
