package com.m2i.dao;

import com.m2i.entity.Account;
import java.util.List;

public interface AccountDAO {
    void create(Account account);
    Account findById(Long id);
    List<Account> findAll();
    void update(Account account);
    void delete(Long id);
    List<Account> findByClientId(Long clientId);
}
