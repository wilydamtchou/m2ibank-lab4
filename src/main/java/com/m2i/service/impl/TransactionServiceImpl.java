package com.m2i.service.impl;

import com.m2i.dao.TransactionDAO;
import com.m2i.dto.TransactionCreateDTO;
import com.m2i.dto.TransactionDTO;
import com.m2i.entity.Transaction;
import com.m2i.mapper.TransactionCreateMapper;
import com.m2i.mapper.TransactionMapper;
import com.m2i.service.TransactionService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class TransactionServiceImpl implements TransactionService {

    @Inject
    private TransactionDAO transactionDAO;

    @Inject
    private TransactionMapper transactionMapper;

    @Inject
    private TransactionCreateMapper transactionCreateMapper;

    @Override
    public void createTransaction(TransactionCreateDTO dto) {
        Transaction transaction = transactionCreateMapper.toEntity(dto);
        transactionDAO.create(transaction);
    }

    @Override
    public TransactionDTO getTransactionById(Long id) {
        return transactionMapper.toDto(transactionDAO.findById(id));
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionDAO.findAll().stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateTransaction(TransactionDTO dto) {
        Transaction transaction = transactionMapper.toEntity(dto);
        transactionDAO.update(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionDAO.delete(id);
    }
}
