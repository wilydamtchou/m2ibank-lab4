package com.m2i.dao.impl;

import java.util.List;

import com.m2i.dao.ClientDAO;
import com.m2i.entity.Client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class ClientDAOImpl implements ClientDAO {

    @PersistenceContext(unitName = "M2iBankPU")
    private EntityManager em;

    @Override
    public void create(Client client) {
        em.persist(client);
    }

    @Override
    public Client findById(Long id) {
        return em.find(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    @Override
    public void update(Client client) {
        em.merge(client);
    }

    @Override
    public void delete(Long id) {
        Client client = findById(id);
        if (client != null) {
            em.remove(client);
        }
    }

    @Override
    public Client findByEmail(String email) {
        return em.createQuery("SELECT c FROM Client c WHERE c.email = :email", Client.class)
                 .setParameter("email", email)
                 .getResultStream()
                 .findFirst()
                 .orElse(null);
    }
}

