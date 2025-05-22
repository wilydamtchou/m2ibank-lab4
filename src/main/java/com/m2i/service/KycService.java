package com.m2i.service;

import com.m2i.dto.KycRecordDTO;
import java.util.List;

public interface KycService {
    void submitKyc(KycRecordDTO dto);
    List<KycRecordDTO> getKycByClient(Long clientId);
    void updateKycStatus(Long kycId, String status);
}
