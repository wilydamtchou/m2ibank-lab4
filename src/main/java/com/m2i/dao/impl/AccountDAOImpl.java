package com.m2i.dao.impl;

import java.util.List;

import com.m2i.dao.AccountDAO;
import com.m2i.entity.Account;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO {

    @PersistenceContext(unitName = "M2iBankPU")
    private EntityManager em;

    @Override
    public void create(Account account) {
        em.persist(account);
    }

    @Override
    public Account findById(Long id) {
        return em.find(Account.class, id);
    }

    @Override
    public List<Account> findAll() {
        return em.createQuery("SELECT a FROM Account a", Account.class).getResultList();
    }

    @Override
    public void update(Account account) {
        em.merge(account);
    }

    @Override
    public void delete(Long id) {
        Account account = findById(id);
        if (account != null) {
            em.remove(account);
        }
    }

    @Override
    public List<Account> findByClientId(Long clientId) {
        return em.createQuery("SELECT a FROM Account a WHERE a.client.clientId = :clientId", Account.class)
                 .setParameter("clientId", clientId)
                 .getResultList();
    }
}

