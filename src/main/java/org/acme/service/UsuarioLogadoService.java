package org.acme.service;

import jakarta.ws.rs.core.Response;
import org.acme.dto.*;

import java.util.List;

public interface UsuarioLogadoService {
    public UsuarioResponseDTO updateSenha(MudarSenhaDTO senha);

    public UsuarioResponseDTO updateLogin(UsuarioUpdateLoginDTO login);

    public UsuarioResponseDTO updateNome(UsuarioUpdateNomeDTO nome);

    public UsuarioResponseDTO updateEmail(UsuarioUpdateEmailDTO email);

    public Response updateEndereco(Long id, EnderecoDTO enderecoDTO);

    public UsuarioResponseDTO getPerfilUsuarioLogado();

    public Response insertTelefone(TelefoneDTO telefoneDTO);
    public Response insertEndereco(EnderecoDTO enderecoDTO);

    public Response getVendas();

    public Response deleteOn();
}
