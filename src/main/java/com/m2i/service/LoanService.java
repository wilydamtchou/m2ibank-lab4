package com.m2i.service;

import com.m2i.dto.LoanDTO;
import java.util.List;

public interface LoanService {
    void requestLoan(LoanDTO dto);
    List<LoanDTO> getLoansByClient(Long clientId);
    void updateLoanStatus(Long loanId, String status);
}
