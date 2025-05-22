package com.m2i.dao;

import com.m2i.entity.Transaction;
import java.util.List;

public interface TransactionDAO {
    void create(Transaction transaction);
    Transaction findById(Long id);
    List<Transaction> findByAccountId(Long accountId);
    void update(Transaction transaction);
    void delete(Transaction transaction);
    List<Transaction> findAll();
    void delete(Long id);
}

