package com.m2i.api;

import com.m2i.dto.ClientCreateDTO;
import com.m2i.dto.ClientDTO;
import com.m2i.service.ClientService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Client", description = "Opérations CRUD sur les clients")
public class ClientResource {

    @EJB
    private ClientService clientService;

    @POST
    @Operation(summary = "Créer un client")
    public Response createClient(ClientCreateDTO dto) {
        clientService.createClient(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Récupérer un client par ID")
    public Response getClientById(@PathParam("id") Long id) {
        ClientDTO client = clientService.getClientById(id);
        if (client == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(client).build();
    }

    @GET
    @Operation(summary = "Lister tous les clients")
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @PUT
    @Operation(summary = "Mettre à jour un client")
    public Response updateClient(ClientDTO dto) {
        clientService.updateClient(dto);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Supprimer un client")
    public Response deleteClient(@PathParam("id") Long id) {
        clientService.deleteClient(id);
        return Response.noContent().build();
    }
}
