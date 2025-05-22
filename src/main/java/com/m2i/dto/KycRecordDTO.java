package com.m2i.dto;

import java.time.LocalDateTime;

import com.m2i.model.KycStatus;

public record KycRecordDTO(
    Long kycId,
    Long clientId,
    LocalDateTime dateSoumission,
    KycStatus statut
) {}
