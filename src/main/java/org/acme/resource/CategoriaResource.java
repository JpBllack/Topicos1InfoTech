package org.acme.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CategoriaDTO;
import org.acme.dto.CategoriaResponseDTO;
import org.acme.service.CategoriaService;

import java.util.List;

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {
    @Inject
    CategoriaService service;

    @GET
    @PermitAll
    public List<CategoriaResponseDTO> getAll(){
        return service.getAll();
    }
    @GET
    @PermitAll
    @Path("/{id}")
    public CategoriaResponseDTO getId(@PathParam("id") long id){
        return service.getId(id);
    }
    @GET
    @PermitAll
    @Path("/{nome}")
    public List<CategoriaResponseDTO> getINome(@PathParam("nome") String nome){
        return service.getNome(nome);
    }

    @POST
    @PermitAll
    public Response insert(CategoriaDTO categoriaDTO){
        return service.insert(categoriaDTO);
    }

    @DELETE
    @PermitAll
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        return service.delete(id);
    }
}
