package com.m2i.mapper.impl;

import com.m2i.dto.ClientCreateDTO;
import com.m2i.dto.JSFClientCreateDTO;
import com.m2i.mapper.JSFClientCreateMapper;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JSFClientCreateMapperImpl implements JSFClientCreateMapper {

    @Override
    public ClientCreateDTO toEntity(JSFClientCreateDTO dto) {
    	return new ClientCreateDTO(
    			dto.getNom(),
    			dto.getPrenom(),
    			dto.getEmail(),
    			dto.getTelephone()
    			);
    }

    @Override
    public JSFClientCreateDTO toDto(ClientCreateDTO entity) {
    	JSFClientCreateDTO dto = new JSFClientCreateDTO();
        dto.setNom(entity.nom());
        dto.setPrenom(entity.prenom());
        dto.setEmail(entity.email());
        dto.setTelephone(entity.telephone());
    	return dto;
    }
}
