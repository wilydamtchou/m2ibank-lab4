package com.m2i.service;

import com.m2i.dto.TransactionCreateDTO;
import com.m2i.dto.TransactionDTO;

import jakarta.ejb.LocalBean;

import java.util.List;

@LocalBean
public interface TransactionService {
    void createTransaction(TransactionCreateDTO dto);
    TransactionDTO getTransactionById(Long id);
    List<TransactionDTO> getAllTransactions();
    void updateTransaction(TransactionDTO dto);
    void deleteTransaction(Long id);
}
