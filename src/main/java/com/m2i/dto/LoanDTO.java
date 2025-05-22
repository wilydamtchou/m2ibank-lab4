package com.m2i.dto;

import java.time.LocalDateTime;

import com.m2i.model.LoanStatus;

public record LoanDTO(
    Long loanId,
    Long clientId,
    double montant,
    double taux,
    LocalDateTime dateDebut,
    LocalDateTime dateEcheance,
    LoanStatus statut
) {}

