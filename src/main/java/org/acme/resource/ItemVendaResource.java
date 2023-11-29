package org.acme.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ItemVendaDTO;
import org.acme.dto.ItemVendaResponseDTO;
import org.acme.service.ItemVendaService;

import java.util.List;

@Path("/itemvenda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemVendaResource {
    @Inject
    ItemVendaService service;

    @GET
    @PermitAll
    public List<ItemVendaResponseDTO> getAll(){
        return service.getAll();
    }
    @GET
    @PermitAll
    @Path("/{id}")
    public ItemVendaResponseDTO getId(@PathParam("id") long id){
        return service.getId(id);
    }

    @POST
    @PermitAll
    public Response insert(ItemVendaDTO dto){
        return service.insert(dto);
    }

    @DELETE
    @PermitAll
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        return service.delete(id);
    }
}
