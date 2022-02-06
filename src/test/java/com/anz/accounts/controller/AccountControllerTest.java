package com.anz.accounts.controller;

import com.anz.accounts.TestHelper;
import com.anz.accounts.model.Account;
import com.anz.accounts.model.Transaction;
import com.anz.accounts.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    AccountService accountService;

    @Test
    void getAllAccounts() throws Exception {
        List<Account> accounts = TestHelper.getAccounts ();
        Mockito.when(accountService.getAllAccountDetails ()).thenReturn (accounts);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/accounts")
                        .contentType (MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    void getAccountTransactions() throws Exception {
        List<Transaction> transactions = TestHelper.getAccountTransactions ("595309209");
        Mockito.when(accountService.getTransactionDetails ("595309209")).thenReturn (transactions);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/accounts/595309209/transactions")
                        .contentType (MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }


}
