package com.m2i.dao.impl;

import java.util.List;

import com.m2i.dao.LoanDAO;
import com.m2i.entity.Loan;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class LoanDAOImpl implements LoanDAO {

	@PersistenceContext(unitName = "M2iBankPU")
    private EntityManager em;

    @Override
    public void create(Loan loan) {
        em.persist(loan);
    }

    @Override
    public Loan findById(Long id) {
        return em.find(Loan.class, id);
    }

    @Override
    public List<Loan> findByClientId(Long clientId) {
        return em.createQuery("SELECT l FROM Loan l WHERE l.client.id = :clientId", Loan.class)
                 .setParameter("clientId", clientId)
                 .getResultList();
    }

    @Override
    public void update(Loan loan) {
        em.merge(loan);
    }

    @Override
    public void delete(Loan loan) {
        em.remove(em.contains(loan) ? loan : em.merge(loan));
    }
}

