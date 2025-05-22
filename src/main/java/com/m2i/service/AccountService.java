package com.m2i.service;

import com.m2i.dto.AccountCreateDTO;
import com.m2i.dto.AccountDTO;

import jakarta.ejb.LocalBean;

import java.util.List;

@LocalBean
public interface AccountService {
    void createAccount(AccountCreateDTO dto);
    AccountDTO getAccountById(Long id);
    List<AccountDTO> getAllAccounts();
    void updateAccount(AccountDTO dto);
    void deleteAccount(Long id);
    List<AccountDTO> getAccountsByClientId(Long clientId);
}
