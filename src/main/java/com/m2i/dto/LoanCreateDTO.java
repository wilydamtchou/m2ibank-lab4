package com.m2i.dto;

public record LoanCreateDTO(
    Long clientId,
    double montant,
    double taux
) {}

