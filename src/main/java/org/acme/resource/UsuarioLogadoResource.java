package org.acme.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.*;
import org.acme.service.UsuarioLogadoService;


@Path("/usuariologado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioLogadoResource {

    @Inject
    UsuarioLogadoService service;

    @GET
    @RolesAllowed({"User", "Admin"})
    public UsuarioResponseDTO getPerfilUsuarioLogado() {
        return service.getPerfilUsuarioLogado();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    @Path("/venda")
    public Response getVendas() {
        return service.getVendas();
    }

    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/update/senha")
    public UsuarioResponseDTO updateSenha(MudarSenhaDTO senha) {
        return service.updateSenha(senha);
    }
    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/update/login")
    public UsuarioResponseDTO updateLogin(UsuarioUpdateLoginDTO login) {
        return service.updateLogin(login);
    }
    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/update/nome")
    public UsuarioResponseDTO updateNome(UsuarioUpdateNomeDTO nome) {
        return service.updateNome(nome);
    }
    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/update/email")
    public UsuarioResponseDTO updateEmail(UsuarioUpdateEmailDTO email) {
        return service.updateEmail(email);
    }

    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/update/endereco/{id}")
    public Response updateEndereco(@PathParam("id") Long id, EnderecoDTO enderecoDTO){
        return service.updateEndereco(id,enderecoDTO);
    }

    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/insert/telefone")
    public Response insertTelefone(TelefoneDTO telefoneDTO) {
        return service.insertTelefone(telefoneDTO);
    }
    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/insert/endereco")
    public Response insertEndereco(EnderecoDTO enderecoDTO) {
        return service.insertEndereco(enderecoDTO);
    }
    @DELETE
    @RolesAllowed({"User", "Admin"})
    public Response deleteOn() {
        return service.deleteOn();
    }
}
