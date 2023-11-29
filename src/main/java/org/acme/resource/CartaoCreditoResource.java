package org.acme.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CartaoCreditoDTO;
import org.acme.dto.CartaoCreditoResponseDTO;
import org.acme.service.CartaoCreditoService;

import java.util.List;

@Path("/cartao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartaoCreditoResource {
    @Inject
    CartaoCreditoService service;

    @GET
    @PermitAll
    public List<CartaoCreditoResponseDTO> getAll(){
        return service.getAll();
    }
    @GET
    @PermitAll
    @Path("/{id}")
    public CartaoCreditoResponseDTO getId(@PathParam("id") long id){
        return service.getId(id);
    }

    @POST
    @PermitAll
    public Response insert(CartaoCreditoDTO CartaoCreditoDTO){
        return service.insert(CartaoCreditoDTO);
    }

    @DELETE
    @PermitAll
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        return service.delete(id);
    }
}
