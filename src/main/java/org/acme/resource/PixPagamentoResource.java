package org.acme.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.PixPagamentoDTO;
import org.acme.dto.PixPagamentoResponseDTO;
import org.acme.service.PixPagamentoService;

import java.util.List;

@Path("/pix")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PixPagamentoResource {
    @Inject
    PixPagamentoService service;

    @GET
    @PermitAll
    public List<PixPagamentoResponseDTO> getAll(){
        return service.getAll();
    }
    @GET
    @PermitAll
    @Path("/{id}")
    public PixPagamentoResponseDTO getId(@PathParam("id") long id){
        return service.getId(id);
    }

    @POST
    @PermitAll
    public Response insert(PixPagamentoDTO dto){
        return service.insert(dto);
    }

    @PATCH
    @PermitAll
    @Path("/{id}")
    public Response update(@PathParam("id") long id, PixPagamentoDTO dto){
        return service.update(id, dto);
    }

    @DELETE
    @PermitAll
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        return service.delete(id);
    }
}
