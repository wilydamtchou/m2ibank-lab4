package com.m2i.service.impl;

import com.m2i.dao.AccountDAO;
import com.m2i.dto.AccountCreateDTO;
import com.m2i.dto.AccountDTO;
import com.m2i.entity.Account;
import com.m2i.mapper.AccountCreateMapper;
import com.m2i.mapper.AccountMapper;
import com.m2i.service.AccountService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountDAO accountDAO;

    @Inject
    private AccountMapper accountMapper;

    @Inject
    private AccountCreateMapper accountCreateMapper;

    @Override
    public void createAccount(AccountCreateDTO dto) {
        Account account = accountCreateMapper.toEntity(dto);
        accountDAO.create(account);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        return accountMapper.toDto(accountDAO.findById(id));
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountDAO.findAll().stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateAccount(AccountDTO dto) {
        Account account = accountMapper.toEntity(dto);
        accountDAO.update(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountDAO.delete(id);
    }

    @Override
    public List<AccountDTO> getAccountsByClientId(Long clientId) {
        return accountDAO.findByClientId(clientId).stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());
    }
}
