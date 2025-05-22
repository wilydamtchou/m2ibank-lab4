package com.m2i.service.impl;

import com.m2i.dao.ClientDAO;
import com.m2i.dto.ClientCreateDTO;
import com.m2i.dto.ClientDTO;
import com.m2i.entity.Client;
import com.m2i.mapper.ClientCreateMapper;
import com.m2i.mapper.ClientMapper;
import com.m2i.service.ClientService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ClientServiceImpl implements ClientService {

    @Inject
    private ClientDAO clientDAO;

    @Inject
    private ClientMapper clientMapper;

    @Inject
    private ClientCreateMapper clientCreateMapper;

    @Override
    public void createClient(ClientCreateDTO dto) {
        Client client = clientCreateMapper.toEntity(dto);
        clientDAO.create(client);
    }

    @Override
    public ClientDTO getClientById(Long id) {
        return clientMapper.toDto(clientDAO.findById(id));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientDAO.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateClient(ClientDTO dto) {
        Client client = clientMapper.toEntity(dto);
        clientDAO.update(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientDAO.delete(id);
    }
}
