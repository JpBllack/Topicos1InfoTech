package org.acme.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.TelefoneDTO;
import org.acme.dto.TelefoneResponseDTO;
import org.acme.service.TelefoneService;

import java.util.List;

@Path("/telefone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TelefoneResource {
    @Inject
    TelefoneService service;

    @GET
    @PermitAll
    public List<TelefoneResponseDTO> getAll(){
        return service.getAll();
    }
    @GET
    @PermitAll
    @Path("/{id}")
    public TelefoneResponseDTO getId(@PathParam("id") long id){
        return service.getId(id);
    }
    @GET
    @PermitAll
    @Path("/codigo/{codigo}")
    public List<TelefoneResponseDTO> getId(@PathParam("codigo") String codigo){
        return service.getCodigoArea(codigo);
    }

    @POST
    @PermitAll
    @Path("/{id}")
    public Response insert(@PathParam("id") String id, TelefoneDTO dto){
        return service.insert(dto, id);
    }

    @PATCH
    @PermitAll
    @Path("/{id}")
    public Response update(@PathParam("id") long id, TelefoneDTO dto){
        return service.update(id, dto);
    }

    @DELETE
    @PermitAll
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        return service.delete(id);
    }
}
