package com.m2i.dao.impl;

import java.util.List;

import com.m2i.dao.ApiClientDAO;
import com.m2i.entity.ApiClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class ApiClientDAOImpl implements ApiClientDAO {

	@PersistenceContext(unitName = "M2iBankPU")
    private EntityManager em;

    @Override
    public void create(ApiClient apiClient) {
        em.persist(apiClient);
    }

    @Override
    public ApiClient findByApiKey(String apiKey) {
        return em.createQuery("SELECT a FROM ApiClient a WHERE a.apiKey = :key", ApiClient.class)
                 .setParameter("key", apiKey)
                 .getSingleResult();
    }

    @Override
    public List<ApiClient> findAll() {
        return em.createQuery("SELECT a FROM ApiClient a", ApiClient.class).getResultList();
    }

    @Override
    public void update(ApiClient apiClient) {
        em.merge(apiClient);
    } 

    @Override
    public void delete(ApiClient apiClient) {
        em.remove(em.contains(apiClient) ? apiClient : em.merge(apiClient));
    }
}

