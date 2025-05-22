package com.m2i.dao;

import com.m2i.entity.Loan;
import java.util.List;

public interface LoanDAO {
    void create(Loan loan);
    Loan findById(Long id);
    List<Loan> findByClientId(Long clientId);
    void update(Loan loan);
    void delete(Loan loan);
}
