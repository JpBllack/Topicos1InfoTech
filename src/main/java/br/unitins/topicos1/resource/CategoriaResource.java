package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.CategoriaDTO;
import br.unitins.topicos1.dto.CategoriaResponseDTO;
import br.unitins.topicos1.service.CategoriaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Inject
    CategoriaService categoriaService;

    @POST
    public Response insert(CategoriaDTO dto) {
        CategoriaResponseDTO responseDTO = categoriaService.insert(dto);
        return Response.status(Response.Status.CREATED).entity(responseDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        CategoriaResponseDTO responseDTO = categoriaService.findById(id);
        if (responseDTO != null) {
            return Response.ok(responseDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // @GET
    // public List<CategoriaResponseDTO> findAll() {
        // return categoriaService.findAll();
    // }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CategoriaDTO dto) {
        CategoriaResponseDTO responseDTO = categoriaService.update(id, dto);
        if (responseDTO != null) {
            return Response.ok(responseDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (categoriaService.delete(id)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
