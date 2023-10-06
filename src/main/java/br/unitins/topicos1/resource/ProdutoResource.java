package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.model.Produto;
import br.unitins.topicos1.repository.ProdutoRepository;
import br.unitins.topicos1.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoService service;

    @POST
    public ProdutoResponseDTO insert(ProdutoDTO dto) {
        return service.insert(dto);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public ProdutoResponseDTO update(ProdutoDTO dto, @PathParam("id") Long id) {
        return service.update(dto, id);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }

    @GET
    public List<ProdutoResponseDTO> findAll() {
        return service.findByAll();
    }

    @GET
    @Path("/{id}")
    public ProdutoResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }
    
    @GET
    @Path("/search/nome/{nome}")
    public ProdutoResponseDTO findByNome(@PathParam("nome") Long nome) {
        return service.findById(nome);
    }
}
