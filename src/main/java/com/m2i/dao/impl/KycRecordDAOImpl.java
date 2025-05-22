package com.m2i.dao.impl;


import java.util.List;

import com.m2i.dao.KycRecordDAO;
import com.m2i.entity.KycRecord;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class KycRecordDAOImpl implements KycRecordDAO {

	@PersistenceContext(unitName = "M2iBankPU")
    private EntityManager em;

    @Override
    public void create(KycRecord record) {
        em.persist(record);
    }

    @Override
    public KycRecord findById(Long id) {
        return em.find(KycRecord.class, id);
    }

    @Override
    public List<KycRecord> findByClientId(Long clientId) {
        return em.createQuery("SELECT k FROM KycRecord k WHERE k.client.id = :clientId", KycRecord.class)
                 .setParameter("clientId", clientId)
                 .getResultList();
    }

    @Override
    public void update(KycRecord record) {
        em.merge(record);
    }

    @Override
    public void delete(KycRecord record) {
        em.remove(em.contains(record) ? record : em.merge(record));
    }
}
