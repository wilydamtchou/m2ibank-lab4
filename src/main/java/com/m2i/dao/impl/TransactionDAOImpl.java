package com.m2i.dao.impl;

import java.util.List;

import com.m2i.dao.TransactionDAO;
import com.m2i.entity.Transaction;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class TransactionDAOImpl implements TransactionDAO {

	@PersistenceContext(unitName = "M2iBankPU")
    private EntityManager em;

    @Override
    public void create(Transaction transaction) {
        em.persist(transaction);
    }

    @Override
    public Transaction findById(Long id) {
        return em.find(Transaction.class, id);
    }

    @Override
    public List<Transaction> findByAccountId(Long accountId) {
        return em.createQuery(
                "SELECT t FROM Transaction t WHERE t.accountSource.id = :id OR t.accountTarget.id = :id",
                Transaction.class)
                .setParameter("id", accountId)
                .getResultList();
    }

    @Override
    public void update(Transaction transaction) {
        em.merge(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        em.remove(em.contains(transaction) ? transaction : em.merge(transaction));
    }
    
	@Override
	public List<Transaction> findAll() {
		return em.createQuery("SELECT t FROM Transaction t", Transaction.class).getResultList();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Transaction transaction = em.find(Transaction.class, id);
		
		if (transaction != null )
			em.remove(transaction);
	}
}

