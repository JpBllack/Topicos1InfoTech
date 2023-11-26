package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.acme.dto.*;

@ApplicationScoped
public interface UsuarioLogadoService {
    public UsuarioResponseDTO updateSenha(MudarSenhaDTO senha);

    public UsuarioResponseDTO updateLogin(UsuarioUpdateLoginDTO login);

    public UsuarioResponseDTO updateNome(UsuarioUpdateNomeDTO nome);

    public UsuarioResponseDTO updateEmail(UsuarioUpdateEmailDTO email);

    public UsuarioResponseDTO getPerfilUsuarioLogado();

    public Response deleteOn();
}
