package org.acme.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.EnderecoDTO;
import org.acme.dto.EnderecoResponseDTO;
import org.acme.service.EnderecoService;

import java.util.List;

@Path("/endereco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {
    @Inject
    EnderecoService service;

    @GET
    @PermitAll
    public List<EnderecoResponseDTO> getAll(){
        return service.getAll();
    }
    @GET
    @PermitAll
    @Path("/{id}")
    public EnderecoResponseDTO getId(@PathParam("id") long id){
        return service.getId(id);
    }

    @POST
    @PermitAll
    @Path("/{id}")
    public Response insert(@PathParam("id") String id, EnderecoDTO enderecoDTO){
        return service.insert(id, enderecoDTO);
    }

    @DELETE
    @PermitAll
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        return service.delete(id);
    }
}
