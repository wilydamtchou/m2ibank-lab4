package com.m2i.bean;

import com.m2i.dto.ClientDTO;
import com.m2i.dto.JSFClientCreateDTO;
import com.m2i.mapper.JSFClientCreateMapper;
import com.m2i.service.ClientService;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

import java.io.Serializable;
import java.util.List;


@Named
@RequestScoped
public class ClientBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ClientService clientService;
    
    @Inject
    private JSFClientCreateMapper jsfClientCreateMapper;

    private JSFClientCreateDTO nouveauClient = new JSFClientCreateDTO();
    private ClientDTO client = new ClientDTO();
    private List<ClientDTO> clients;

    public List<ClientDTO> getClients() {
        clients = clientService.getAllClients();
        
        System.out.println("Liste clients: "+clients);
       
        return clients;
    }

    public String createClient() {
        clientService.createClient(jsfClientCreateMapper.toEntity(nouveauClient));
        nouveauClient = new JSFClientCreateDTO(); // Réinitialiser le formulaire
        
        return "clientList?faces-redirect=true";
    }

    public void updateClient() {
        clientService.updateClient(client);
    }

    public void deleteClient(Long id) {
        clientService.deleteClient(id);
    }

	public JSFClientCreateDTO getNouveauClient() {
		return nouveauClient;
	}

	public void setNouveauClient(JSFClientCreateDTO nouveauClient) {
		this.nouveauClient = nouveauClient;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public void setClients(List<ClientDTO> clients) {
		this.clients = clients;
	}
}
