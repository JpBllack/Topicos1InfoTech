package org.acme.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.*;
import org.acme.dto.CidadeDTO;
import org.acme.dto.CidadeResponseDTO;
import org.acme.repository.EstadoRepository;
import org.acme.service.CidadeService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cidade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CidadeResource {
    
    @Inject
    CidadeService service;
    
    @POST
    public Response insert(CidadeDTO cidadeDTO){
        return service.insert(cidadeDTO);
    }

    @PUT
    @Transactional
    @Path("/update/{id}")
    public Response update(CidadeDTO cidadeDTO, @PathParam("id") Long id) {
    service.update(cidadeDTO, id);
    return Response.ok().build();

    }
    @GET
    @PermitAll
    @Path("/{id}")
    public CidadeResponseDTO getId(@PathParam("id") long id){
        return service.findById(id);
    }
    @GET
    @PermitAll
    @Path("/{nome}")
    public List<CidadeResponseDTO> getINome(@PathParam("nome") String nome){
        return service.findByNome(nome);
    }

    @GET
    @PermitAll
    public Response findAll() {
        return Response.ok(service.findAll()).build();
    }

    @DELETE
    @PermitAll
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") long id){
        return service.delete(id);
    }


}
