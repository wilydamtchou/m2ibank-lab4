package com.m2i.dao;

import com.m2i.entity.Client;
import java.util.List;

public interface ClientDAO {
    void create(Client client);
    Client findById(Long id);
    List<Client> findAll();
    void update(Client client);
    void delete(Long id);
    Client findByEmail(String email);
}
