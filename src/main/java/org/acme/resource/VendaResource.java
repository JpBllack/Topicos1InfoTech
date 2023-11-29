package org.acme.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.*;
import org.acme.dto.VendaDTO;
import org.acme.service.VendaService;

import java.util.List;

@Path("/venda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendaResource {
    @Inject
    VendaService service;

    @GET
    @RolesAllowed({"Admin"})
    public List<VendaResponseDTO> getAll(){
        return service.getAll();
    }
    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public VendaResponseDTO getId(@PathParam("id") long id){
        return service.getId(id);
    }

    @PATCH
    @RolesAllowed({"Admin", "User"})
    @Path("/pagamento")
    public Response insertPagamento(VendaPagamentoDTO vendaPagamentoDTO) {
        return service.insertPagamento(vendaPagamentoDTO);
    }

    @POST
    @RolesAllowed({"Admin", "User"})
    public Response insert(VendaDTO dto) {
        return service.insert(dto);
    }

    @POST
    @RolesAllowed({"Admin", "User"})
    @Path("/itemvenda/insert")
    public Response insertItemVenda(VendaItemVendaDTO vendaDTO) {
        return service.insertItemVenda(vendaDTO);
    }

    @PATCH
    @RolesAllowed({"Admin","User"})
    @Path("/itemvenda/insertid")
    public Response insertItemVendaId(VendaItemVendaId vendaItemVendaId) {
        return service.insertItemVendaId(vendaItemVendaId);
    }

    @PATCH
    @RolesAllowed({"Admin", "User"})
    @Path("/itemvenda/removeid")
    public Response removeItemVendaId(VendaItemVendaId dto) {
        return service.removeItemVendaId(dto);
    }

    @POST
    @RolesAllowed({"Admin", "user"})
    @Path("/avaliacao/insert")
    public Response insertAvaliacao(AvaliacaoProdutoVendaDTO dto) {
        return service.adicionaAvaliacao(dto);
    }

    @PATCH
    @RolesAllowed({"Admin", "user"})
    @Path("/avaliacao/insertid")
    public Response adicionaAvaliacaoId(AvaliacaoProdutoVendaIdDTO dto) {
        return service.adicionaAvaliacaoId(dto);
    }

    @DELETE
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        return service.delete(id);
    }
}
