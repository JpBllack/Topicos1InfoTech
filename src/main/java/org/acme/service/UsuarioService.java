package org.acme.service;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.acme.dto.*;
import org.acme.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<UsuarioResponseDTO> getAll();

    public UsuarioResponseDTO getId(long id);

    public Usuario findByLoginAndSenha(String login, String senha);

    public List<UsuarioResponseDTO> getNome(String nome);

    public UsuarioResponseDTO getCpf(String cpf);

    public UsuarioResponseDTO updateEmail(Long id, UsuarioUpdateEmailDTO email);

    public UsuarioResponseDTO updateNome(Long id, UsuarioUpdateNomeDTO nome);

    public UsuarioResponseDTO updateLogin(Long id, UsuarioUpdateLoginDTO login);

    public UsuarioResponseDTO updateSenha(MudarSenhaDTO senha);

    public Response insert(UsuarioDTO usuarioDTO);

    public Response delete(@PathParam("id") Long id);

}
