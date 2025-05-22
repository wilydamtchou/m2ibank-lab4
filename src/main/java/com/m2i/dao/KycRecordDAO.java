package com.m2i.dao;

import com.m2i.entity.KycRecord;
import java.util.List;

public interface KycRecordDAO {
    void create(KycRecord record);
    KycRecord findById(Long id);
    List<KycRecord> findByClientId(Long clientId);
    void update(KycRecord record);
    void delete(KycRecord record);
}

