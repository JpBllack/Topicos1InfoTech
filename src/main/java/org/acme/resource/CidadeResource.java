package org.acme.resource;

import org.acme.dto.CidadeDTO;
import org.acme.dto.CidadeResponseDTO;
import org.acme.repository.EstadoRepository;
import org.acme.service.CidadeService;
import org.acme.service.impl.CidadeServiceImpl;

import jakarta.inject.Inject;
import jakarta.transaction.Status;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CidadeResource {
    
    @Inject
    CidadeService service;

    @Inject
    EstadoRepository estadoRepository;

    
    @POST
    public Response insert(CidadeDTO cidadeDTO){
        return service.insert(cidadeDTO);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(CidadeDTO cidadeDTO, @PathParam("id") Long id) {
    service.update(cidadeDTO, id);
    return Response.ok().build();

    }   

    @GET
    public Response findAll() {
        return Response.ok(service.findAll()).build();
    }

}
